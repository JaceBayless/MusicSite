package tech.noahgeren.template.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.noahgeren.template.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
