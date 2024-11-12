package com.example.javatermproject.dataMapperLayer;

import com.example.javatermproject.dataLayer.Post;
import com.example.javatermproject.presentationLayer.PostRequestModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostRequestMapper {
    Post requestMapperToEntity(PostRequestModel postNewData);
}