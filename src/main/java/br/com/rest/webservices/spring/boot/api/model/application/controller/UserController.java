package br.com.rest.webservices.spring.boot.api.model.application.controller;


import br.com.rest.webservices.spring.boot.api.model.application.dto.UserDTO;
import br.com.rest.webservices.spring.boot.api.model.application.exception.UserNotFoundException;
import br.com.rest.webservices.spring.boot.api.model.application.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> retrieveAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserDTO retrieveUser(@PathVariable int id){
        UserDTO user =  userService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO user){
        UserDTO savedUser = userService.save(user);

         URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

       return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){

    }

}
