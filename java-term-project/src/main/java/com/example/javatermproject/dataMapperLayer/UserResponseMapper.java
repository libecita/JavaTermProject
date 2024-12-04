package com.example.javatermproject.dataMapperLayer;

import com.example.javatermproject.dataLayer.User;
import com.example.javatermproject.presentationLayer.UserResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {

    UserResponseModel entityToResponseModel(User foundUser);

    List<UserResponseModel> entityToResponseModelList(List<User> users);

}