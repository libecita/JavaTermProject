package com.example.javatermproject.businessLayer;

import com.example.javatermproject.dataLayer.Post;
import com.example.javatermproject.presentationLayer.PostResponseModel;
import com.example.javatermproject.presentationLayer.UserRequestModel;
import com.example.javatermproject.presentationLayer.UserResponseModel;

import java.util.List;

public interface UserService {
    List<UserResponseModel> getUsers();

    UserResponseModel getUserByUserId(String userId);

    UserResponseModel addUser(UserRequestModel newUserData);

    UserResponseModel updateCustomer(String userId, UserRequestModel newUserData);

    String deleteUserByUserId(String userId);


    List<PostResponseModel> getPostsByUsername(String username);
}
