package br.com.rest.webservices.spring.boot.api.model.application.service;

import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity.PostEntity;
import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity.UserEntity;
import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.repository.PostRepository;
import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private PostRepository postRepository;

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> entities = new ArrayList<>();
        entities.addAll(userRepository.findAll());
       return entities;

    }

    @Override
    public UserEntity save(UserEntity user) {
        UserEntity entity = userRepository.save(user);
        return entity;
    }

    @Override
    public UserEntity findOne(int id) {
        Optional<UserEntity> entity = userRepository.findById(id);
       return entity.get();
    }

    @Override
    public void deleteOne(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void savePost(PostEntity post, UserEntity user) {
        post.setUser(user);
        postRepository.save(post);
    }


}
