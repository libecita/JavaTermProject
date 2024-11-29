package com.example.javatermproject.businessLayer;

import com.example.javatermproject.dataLayer.Like;
import com.example.javatermproject.dataLayer.Post;
import com.example.javatermproject.dataLayer.User;
import jakarta.transaction.Transactional;
import com.example.javatermproject.dataLayer.LikeRepository;
import com.example.javatermproject.dataMapperLayer.LikeRequestMapper;
import com.example.javatermproject.dataMapperLayer.LikeResponseMapper;
import com.example.javatermproject.presentationLayer.LikeRequestModel;
import com.example.javatermproject.presentationLayer.LikeResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Transactional
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
        Like foundLike = this.likeRepository.getLikeByLikeIdentifier(likeId);
        if (foundLike == null) {
            throw new RuntimeException("Like with Id " + likeId + " not found.");
        }
        Set<User> users = foundLike.getUsers();
        if (users != null && !users.isEmpty()) {
            System.out.println("Deleting like associated with " + users + " users.");
        } else {
            System.out.println("No users associated with the like.");
        }
        this.likeRepository.delete(foundLike);
        return "Like with Id " + likeId + " deleted.";
    }

    @Override
    public LikeResponseModel updateLike(String likeId, LikeRequestModel likeRequestModel) {
        if (likeRequestModel.getLikeIdentifier() == null || likeRequestModel.getLikeIdentifier().isEmpty()) {
            throw new RuntimeException("Like ID in the request body is empty, keep same id from path variable.");
        }
        if (!likeRequestModel.getLikeIdentifier().equals(likeId)) {
            throw new RuntimeException("Like ID in the request body is not the same as the id in the path variable.");
        }
        Like foundLike = this.likeRepository.getLikeByLikeIdentifier(likeId);
        if (foundLike == null) {
            throw new RuntimeException("Like with Id " + likeId + " not found.");
        } else {
            BeanUtils.copyProperties(likeRequestModel, foundLike, "like_id");
            Like savedLike = this.likeRepository.save(foundLike);
            LikeResponseModel list2 = this.likeResponseMapper.entityToResponseModel(savedLike);
            return list2;
        }
    }

    @Override
    public LikeResponseModel getLikeById(String likeId) {
        Like like = this.likeRepository.getLikeByLikeIdentifier(likeId);
        LikeResponseModel result = null;
        if (like == null) {
            throw new org.example.movielistapp.utilities.NotFoundException("Like with " + likeId + " not found.");
        } else {
            result = this.likeResponseMapper.entityToResponseModel(like);
        }
        return result;
    }

    @Override
    public List<LikeResponseModel> getLikes() {
        List<Like> likes = this.likeRepository.findAll();
        return this.likeResponseMapper.entityToResponseModelList(likes);
    }

    @Override
    public LikeResponseModel addOneLike(LikeRequestModel likeNewData) {
        Like newLike = this.likeRequestMapper.requestMapperToEntity(likeNewData);
        Like savedLike = this.likeRepository.save(newLike);
        return this.likeResponseMapper.entityToResponseModel(savedLike);
    }

//    @Override
//    public List<Post> getPostsLikedByUsers() {
//       Like likes = this.likeRepository.findPostsLikedByUsers();
//       Set<Post> posts = likes.getPosts();
//       List<Post> postUserResponseMappers = new ArrayList<>(posts);
//
//       return postUserResponseMappers;
//    }

}
