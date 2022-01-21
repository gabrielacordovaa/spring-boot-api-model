package br.com.rest.webservices.spring.boot.api.model.application.service;

import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity.PostEntity;
import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();
    UserEntity save(UserEntity user);
    UserEntity findOne(int id);
    void deleteOne(int id);
    void savePost(PostEntity post, UserEntity user);
}
