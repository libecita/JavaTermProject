package com.example.javatermproject.dataMapperLayer;

import com.example.javatermproject.dataLayer.Post;
import com.example.javatermproject.dataLayer.User;
import com.example.javatermproject.presentationLayer.LikeResponseModel;
import com.example.javatermproject.presentationLayer.PostUserResponseModel;
import com.example.javatermproject.presentationLayer.PostResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostUserResponseMapper {
    User responseModelToEntity(LikeResponseModel likeResponseModel);

    @Mapping(target = "post", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "likeId", ignore = true)
    User responseModelToEntity(PostUserResponseModel postUserResponseModel);

    PostUserResponseModel entityToResponseModel(User user);

    List<PostUserResponseModel> entityListToResponseModelList(List<User> userList);
}