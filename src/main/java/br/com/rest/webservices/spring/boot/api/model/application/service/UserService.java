package br.com.rest.webservices.spring.boot.api.model.application.service;

import br.com.rest.webservices.spring.boot.api.model.application.dto.UserDTO;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();
    UserDTO save(UserDTO user);
    UserDTO findOne(int id);
    void deleteOne(int id);
}
