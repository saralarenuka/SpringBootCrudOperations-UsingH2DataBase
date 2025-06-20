package com.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
