package br.com.rest.webservices.spring.boot.api.model.application.service;

import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity.UserEntity;
import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.mapper.UserMapper;
import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.repository.UserRepository;
import br.com.rest.webservices.spring.boot.api.model.application.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private static int usersCount = 3;

    private static List<UserDTO> users = new ArrayList<>();
    private UserRepository userRepository;
    private UserMapper userMapper;

    static{
        users.add(new UserDTO(1, "Adam", new Date(), 19, "adam@email.com.br", "5511897621"));
        users.add(new UserDTO(2, "Eve", new Date(), 20, "eve@email.com.br", "55118932621"));
        users.add(new UserDTO(3, "Jack", new Date(), 21, "jack@email.com.br", "5511437621"));

    }
    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> entities = new ArrayList<>();
        entities.addAll(userRepository.findAll());
        List<UserDTO> users = new ArrayList<>();
        for (UserEntity entity: entities
             ) {
            users.add(userMapper.map(entity));
        }
        return users;
    }

    @Override
    public UserDTO save(UserDTO user) {
        UserEntity entity = userRepository.save(userMapper.mapping(user));
        return userMapper.map(entity);
    }

    @Override
    public UserDTO findOne(int id) {
        Optional<UserEntity> entity = Optional.of(new UserEntity());
        entity = userRepository.findById(id);
       return userMapper.map(entity.get());
    }

    @Override
    public void deleteOne(int id) {
        userRepository.deleteById(id);
    }


}
