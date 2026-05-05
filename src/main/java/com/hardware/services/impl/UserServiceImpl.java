package com.hardware.services.impl;

import com.hardware.dtos.UserDTO;
import com.hardware.entities.User;
import com.hardware.exceptions.ResourceNotFoundException;
import com.hardware.mapper.UserMapper;
import com.hardware.repositories.UserRepository;
import com.hardware.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    // Create Users
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User savedUser =  userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("User not found"));
        return UserMapper.toDTO(user);
    }
}

