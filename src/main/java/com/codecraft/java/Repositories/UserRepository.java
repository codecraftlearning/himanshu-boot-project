package com.codecraft.java.Repositories;

import com.codecraft.java.entities.User;
import com.codecraft.java.models.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByEmail(String email);

    @Query("select u from User u where u.name like %:name%")
    public List<User> findAllByName(@Param("name") String name);

    public List<User> findByNameContaining(String name);
}
