package br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="usertable")
@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "BIRTHDATE")
    private Date birthDate;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<PostEntity> posts;
}
