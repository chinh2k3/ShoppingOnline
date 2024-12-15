package com.example.ClothesShoppingOnline.Service;

import com.example.ClothesShoppingOnline.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User addNewUser(User user);

    List<User> findAll();

    boolean isExist(Long userId);

    User updateUser(Long userId, User user);
    Page<User> findAll(Pageable pageable);

    User getUserByName(String name,String password);

    void delete(Long userId);
}
