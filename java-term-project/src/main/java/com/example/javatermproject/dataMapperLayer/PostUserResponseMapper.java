package com.example.javatermproject.dataMapperLayer;

import com.example.javatermproject.dataLayer.Post;
import com.example.javatermproject.dataLayer.User;
import com.example.javatermproject.presentationLayer.PostUserResponseModel;
import com.example.javatermproject.presentationLayer.LikeResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostUserResponseMapper {
    User responseModelToEntity(LikeResponseModel likeResponseModel);

    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userIdentifier", ignore = true)
    User responseModelToEntity(PostUserResponseModel postUserResponseModel);

    PostUserResponseModel entityToResponseModel(User user);


    List<PostUserResponseModel> entityListToResponseModelList(List<User> userList);
}