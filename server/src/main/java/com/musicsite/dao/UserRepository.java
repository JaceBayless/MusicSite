package com.musicsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicsite.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
