package com.example.javatermproject.businessLayer;

import com.example.javatermproject.presentationLayer.LikeRequestModel;
import com.example.javatermproject.presentationLayer.LikeResponseModel;

import java.util.List;

public interface LikeService {
    String deleteLike(String likeId);

    LikeResponseModel updateLike(String likeId, LikeRequestModel likeRequestModel);

    LikeResponseModel getLikeById(String likeId);

    List<LikeResponseModel> getLikes();

    LikeResponseModel addOneLike(LikeRequestModel likeRequestModel);

}
