package com.example.javatermproject.dataMapperLayer;

import com.example.javatermproject.dataLayer.Like;
import com.example.javatermproject.presentationLayer.LikeRequestModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LikeRequestMapper {

    Like requestMapperToEntity(LikeRequestModel likeRequestModel);
}