package com.example.javatermproject.dataMapperLayer;

import com.example.javatermproject.dataLayer.Like;
import com.example.javatermproject.presentationLayer.LikeResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LikeResponseMapper {

    List<LikeResponseModel> entityToResponseModelList(List<Like> likes);

    LikeResponseModel entityToResponseModel(Like like);
}