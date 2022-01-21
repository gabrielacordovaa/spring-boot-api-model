package br.com.rest.webservices.spring.boot.api.model.application.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDTO {


    @NotNull(message = "ID can not be null")
    private Integer id;

    @Size(min = 2, message = "Name should have at least two characters")
    private String name;

    @Past(message = "The birth date needs to be past today")
    private Date birthDate;

    @Positive(message = "Age should be positive")
    private Integer age;

    @Email(message = "Pay attention at the email format")
    private String email;

    private String phoneNumber;

}
