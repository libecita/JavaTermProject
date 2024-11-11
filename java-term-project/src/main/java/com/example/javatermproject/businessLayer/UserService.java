package com.example.javatermproject.businessLayer;

import com.example.javatermproject.presentationLayer.UserRequestModel;
import com.example.javatermproject.presentationLayer.UserResponseModel;

import java.util.List;

public interface UserService {
    List<UserResponseModel> getUsers();

    UserResponseModel getUserByUserId(String userId);

    String addUser(UserRequestModel newUserData);

    String updateCustomer(String userId, UserRequestModel newUserData);

    String deleteUserByUserId(String userId);
}
