package com.example.javatermproject.businessLayer;

import com.example.javatermproject.presentationLayer.PostRequestModel;
import com.example.javatermproject.presentationLayer.PostResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{


    @Override
    public List<PostResponseModel> getPosts() {
        return List.of();
    }

    @Override
    public String addOnePost(PostRequestModel postRequestModel) {
        return "";
    }

    @Override
    public String updatePost(String postId, PostRequestModel postRequestModel) {
        return "";
    }

    @Override
    public PostResponseModel getPostById(String postId) {
        return null;
    }

    @Override
    public String deletePost(String postId) {
        return "";
    }
}
