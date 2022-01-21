package br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="post")
@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class PostEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
