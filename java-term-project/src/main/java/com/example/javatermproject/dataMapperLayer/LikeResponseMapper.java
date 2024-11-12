package com.example.javatermproject.dataMapperLayer;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LikeResponseMapper {

    List<LikeResponseModel> entityListToResponseModelList(List<Like> likes);

    LanguageResponseModel entityToResponseModel(Like like);
}