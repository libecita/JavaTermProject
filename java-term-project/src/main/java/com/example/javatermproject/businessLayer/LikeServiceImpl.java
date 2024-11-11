package com.example.javatermproject.businessLayer;

import com.example.javatermproject.dataLayer.LikeRepository;
import com.example.javatermproject.dataMapperLayer.LikeRequestMapper;
import com.example.javatermproject.dataMapperLayer.LikeResponseMapper;
import com.example.javatermproject.presentationLayer.LikeRequestModel;
import com.example.javatermproject.presentationLayer.LikeResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final LikeResponseMapper likeResponseMapper;
    private final LikeRequestMapper likeRequestMapper;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository,
                           LikeResponseMapper likeResponseMapper, LikeRequestMapper likeRequestMapper) {
        this.likeRepository = likeRepository;
        this.likeResponseMapper = likeResponseMapper;
        this.likeRequestMapper = likeRequestMapper;
    }

    @Override
    public String deleteLike(String likeId) {
        return "";
    }

    @Override
    public LikeResponseModel updateLike(String likeId, LikeRequestModel likeRequestModel) {
        return null;
    }

    @Override
    public LikeResponseModel getLikeById(String likeId) {
        return null;
    }

    @Override
    public List<LikeResponseModel> getLikes() {
        return List.of();
    }

    @Override
    public LikeResponseModel addOneLike(LikeRequestModel likeRequestModel) {
        return null;
    }
}
