package com.example.ClothesShoppingOnline.Service.impl;

import com.example.ClothesShoppingOnline.Repositories.UserRepository;
import com.example.ClothesShoppingOnline.Service.UserService;
import com.example.ClothesShoppingOnline.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }
    @Transactional
    @Override
    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public User getUserByName(String name, String password) {
        return userRepository.findUserByName(name, password);
    }

    @Override
    public User updateUser(Long userId, User user) {
        user.setUser_id(userId);
        return userRepository.findById(userId).map(existingUser->{
            Optional.ofNullable(user.getName()).ifPresent(existingUser::setName);
            Optional.ofNullable(user.getPassword()).ifPresent(existingUser::setPassword);
            Optional.ofNullable(user.getAddress()).ifPresent(existingUser::setAddress);
            Optional.ofNullable(user.getPhone()).ifPresent(existingUser::setPhone);
            Optional.ofNullable(user.getEmail()).ifPresent(existingUser::setEmail);
            Optional.ofNullable(user.getCreateAt()).ifPresent(existingUser::setCreateAt);
            return userRepository.save(existingUser);
        }).orElseThrow(()->new RuntimeException("Error update"));
    }

    @Override
    public boolean isExist(Long userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
