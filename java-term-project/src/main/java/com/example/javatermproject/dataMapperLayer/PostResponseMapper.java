package com.example.javatermproject.dataMapperLayer;

import com.example.javatermproject.dataLayer.Post;
import com.example.javatermproject.presentationLayer.PostResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostResponseMapper {
    List<PostResponseModel> entityToResponseModelList(List<Post> posts);

    PostResponseModel entityToResponseModel(Post foundPost);
}