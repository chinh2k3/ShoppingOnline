package com.example.ClothesShoppingOnline.Mapper.impl;

import com.example.ClothesShoppingOnline.Mapper.Mapper;
import com.example.ClothesShoppingOnline.domain.dto.UserDTO;
import com.example.ClothesShoppingOnline.domain.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserImpl implements Mapper<User, UserDTO> {
    private ModelMapper modelMapper;

    public UserImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO mapTo(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public User mapFrom(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
