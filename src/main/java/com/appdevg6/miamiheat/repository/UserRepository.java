package com.appdevg6.miamiheat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdevg6.miamiheat.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);

    boolean existsByEmail(String email);
    boolean existsByIdNumber(String idNumber);
}
