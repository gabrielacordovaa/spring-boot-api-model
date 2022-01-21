package br.com.rest.webservices.spring.boot.api.model.adapters.datastore.mapper;

import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity.UserEntity;
import br.com.rest.webservices.spring.boot.api.model.application.dto.UserDTO;

public interface UserMapper {

    UserDTO map(UserEntity userEntity);
    UserEntity mapping(UserDTO userDTO);
}
