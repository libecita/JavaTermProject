package com.example.javatermproject.dataMapperLayer;

import com.example.javatermproject.dataLayer.User;
import com.example.javatermproject.presentationLayer.UserRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    @Mapping(target = "id", ignore = true)
    User requestMapperToEntity(UserRequestModel newUserData);
}