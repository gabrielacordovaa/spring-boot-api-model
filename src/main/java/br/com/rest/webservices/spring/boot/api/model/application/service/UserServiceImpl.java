package br.com.rest.webservices.spring.boot.api.model.application.service;

import br.com.rest.webservices.spring.boot.api.model.application.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserServiceImpl implements UserService{

    private static int usersCount = 3;

    private static List<UserDTO> users = new ArrayList<>();

    static{
        users.add(new UserDTO(1, "Adam", new Date(), 19, "adam@email.com.br", "5511897621"));
        users.add(new UserDTO(2, "Eve", new Date(), 20, "eve@email.com.br", "55118932621"));
        users.add(new UserDTO(3, "Jack", new Date(), 21, "jack@email.com.br", "5511437621"));

    }
    @Override
    public List<UserDTO> findAll() {
        return users;
    }

    @Override
    public UserDTO save(UserDTO user) {
        if(user.getId() == null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    @Override
    public UserDTO findOne(int id) {
        for(UserDTO user: users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public UserDTO deleteOne(int id) {
        Iterator<UserDTO> iterator = users.iterator() ;
        while(iterator.hasNext()){
            UserDTO user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }


}
