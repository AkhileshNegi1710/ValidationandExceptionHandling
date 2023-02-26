package com.example.SpringExceptionHandling.Repository;

import com.example.SpringExceptionHandling.Entity.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<EntityUser, Integer>{


    EntityUser findByUserId(int id);
}
