package com.example.javatermproject.businessLayer;


import com.example.javatermproject.presentationLayer.PostRequestModel;
import com.example.javatermproject.presentationLayer.PostResponseModel;

import java.util.List;

public interface PostService {
    List<PostResponseModel> getPosts();

    PostResponseModel addOnePost(PostRequestModel postNewData);

    PostResponseModel updatePost(String postId, PostRequestModel postRequestModel);

    PostResponseModel getPostById(String postId);

    String deletePost(String postId);

}
