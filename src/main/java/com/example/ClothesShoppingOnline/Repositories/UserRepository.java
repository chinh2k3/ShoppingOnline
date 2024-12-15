package com.example.ClothesShoppingOnline.Repositories;

import com.example.ClothesShoppingOnline.domain.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, PagingAndSortingRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.name = :name and u.password=:password")
    User findUserByName(@Param("name") String name, @Param("password") String password);
}
