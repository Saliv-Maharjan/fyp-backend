package com.hardware.services;
import com.hardware.dtos.UserDTO;

public interface UserService {
    // Create User - Method
    UserDTO createUser(UserDTO userDTO);

    // Get User By ID
    UserDTO getUserById(Long id);
}
