package br.com.rest.webservices.spring.boot.api.model.adapters.datastore.repository;

import br.com.rest.webservices.spring.boot.api.model.adapters.datastore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
