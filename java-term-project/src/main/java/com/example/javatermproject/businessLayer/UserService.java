package com.example.javatermproject.businessLayer;

import com.example.javatermproject.presentationLayer.UserRequestModel;
import com.example.javatermproject.presentationLayer.UserResponseModel;

import java.util.List;

public interface UserService {
    List<UserResponseModel> getUsers();

    UserResponseModel getUserByUserId(String userId);

    UserResponseModel addUser(UserRequestModel newUserData);

    UserResponseModel updateCustomer(String userId, UserRequestModel newUserData);

    String deleteUserByUserId(String userId);
}
