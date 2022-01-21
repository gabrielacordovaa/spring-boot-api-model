package br.com.rest.webservices.spring.boot.api.model.adapters.datastore.mapper;

import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity.UserEntity;
import br.com.rest.webservices.spring.boot.api.model.application.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{

    @Override
    public UserDTO map(UserEntity userEntity) {
        return UserDTO.builder()
                .id(userEntity.getId())
                .age(userEntity.getAge())
                .birthDate(userEntity.getBirthDate())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .phoneNumber(userEntity.getPhoneNumber())
                .build();
    }

    @Override
    public UserEntity mapping(UserDTO userDTO) {
        return UserEntity.builder()
                .id(userDTO.getId())
                .age(userDTO.getAge())
                .birthDate(userDTO.getBirthDate())
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .phoneNumber(userDTO.getPhoneNumber())
                .build();
    }
}
