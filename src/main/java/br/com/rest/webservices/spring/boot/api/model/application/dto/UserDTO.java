package br.com.rest.webservices.spring.boot.api.model.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private Integer id;
    private String name;
    private Date birthDate;
    private Integer age;
    private String email;
    private String phoneNumber;

}
