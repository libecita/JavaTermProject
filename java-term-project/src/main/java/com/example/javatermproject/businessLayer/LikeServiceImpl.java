package com.example.javatermproject.businessLayer;

import jakarta.transaction.Transactional;
import com.example.javatermproject.dataLayer.LikeRepository;
import com.example.javatermproject.dataMapperLayer.LikeRequestMapper;
import com.example.javatermproject.dataMapperLayer.LikeResponseMapper;
import com.example.javatermproject.presentationLayer.LikeRequestModel;
import com.example.javatermproject.presentationLayer.LikeResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Like foundLike = this.likeRepository.getLikeById(likeId);
        if (foundLike == null) {
            throw new RuntimeException("Like with Id " + likeId + " not found.");
        }
        Set<User> users = foundLike.getUsers();
        if (users != null && !users.isEmpty()) {
            System.out.println("Deleting like associated with " + users + " users.");
        } else {
            System.out.println("No users associated with the like.");
        }
        this.likeRepository.deleteLike(foundLike);
        return "Like with Id " + likeId + " deleted.";
    }

    @Override
    public LikeResponseModel updateLike(String likeId, LikeRequestModel likeRequestModel) {
        if (likeRequestModel.getLikeId() == null || likeRequestModel.getLikeid().isEmpty()) {
            throw new RuntimeException("Like ID in the request body is empty, keep same id from path variable.);
        }
        if (!likeRequestModel.getLikeId().equals(likeId)) {
            throw new RuntimeException("Like ID in the request body is not the same as the id in the path variable.");
        }
        Like foundLike = this.likeRepository.getLikeById(likeId);
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
        Like like = this.LikeRepository.getLikeById(likeId);
        LikeResponseModel result = null;
        if (like == null) {
            throw new NotFoundException("Like with " + likeId + " not found.");
        } else {
            result = this.likeResponseMapper.entityToResponseModel(like);
        }
        return result;
    }

    @Override
    public List<LikeResponseModel> getLikes() {
        List<Like> likes = this.LikeRepository.findAllLikes();
        List<LikeResponseModel> likeResponseModels = this.likeResponseMapper.entityListToResponseModelList(likes);
        return likeResponseModels;
    }

    @Override
    public LikeResponseModel addOneLike(LikeRequestModel likeRequestModel) {
        Like like = this.likeRequestMapper.requestMapperToEntity(likeRequestModel);
        Like savedLike = this.likeRepository.save(like);
        return this.likeResponseMapper.entityToResponseModel(savedLike);
    }
}
