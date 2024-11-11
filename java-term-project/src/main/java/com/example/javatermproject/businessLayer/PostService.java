package com.example.javatermproject.businessLayer;

import com.example.javatermproject.presentationLayer.PostRequestModel;
import com.example.javatermproject.presentationLayer.PostResponseModel;

import java.util.List;

public interface PostService {
    List<PostResponseModel> getPosts();

    String addOnePost(PostRequestModel postRequestModel);

    String updatePost(String postId, PostRequestModel postRequestModel);

    PostResponseModel getPostById(String postId);

    String deletePost(String postId);
}
