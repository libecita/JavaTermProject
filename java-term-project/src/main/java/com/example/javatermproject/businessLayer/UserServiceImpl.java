package com.example.javatermproject.businessLayer;

import com.example.javatermproject.dataLayer.UserRepository;
import com.example.javatermproject.presentationLayer.UserRequestModel;
import com.example.javatermproject.presentationLayer.UserResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseModel> getUsers() {
        return List.of();
    }

    @Override
    public UserResponseModel getUserByUserId(String userId) {
        return null;
    }

    @Override
    public String addUser(UserRequestModel newUserData) {
        return "";
    }

    @Override
    public String updateCustomer(String userId, UserRequestModel newUserData) {
        return "";
    }

    @Override
    public String deleteUserByUserId(String userId) {
        return "";
    }
}
