package br.com.rest.webservices.spring.boot.api.model.application.controller;


import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity.PostEntity;
import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity.UserEntity;
import br.com.rest.webservices.spring.boot.api.model.application.exception.UserNotFoundException;
import br.com.rest.webservices.spring.boot.api.model.application.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Log4j2
@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;


    @GetMapping("/users")
    public List<UserEntity> retrieveAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<UserEntity> retrieveUser(@PathVariable int id){
        UserEntity user =  userService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id-" + id);
        }
        EntityModel<UserEntity> model = EntityModel.of(user);
        WebMvcLinkBuilder linkToUsers =
                linkTo(methodOn(this.getClass()).retrieveAll());

        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserEntity user){
        UserEntity savedUser = userService.save(user);

         URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

       return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteOne(id);
    }

    @GetMapping("users/{id}/posts")
    public List<PostEntity> retrieveAllUsers(@PathVariable int id){
        UserEntity user = userService.findOne(id);
            log.info(user.toString());
            return user.getPosts();
    }

    @PostMapping("users/{id}/posts")
        public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody PostEntity post){
        UserEntity userFound = userService.findOne(id);

        userService.savePost(post, userFound);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
