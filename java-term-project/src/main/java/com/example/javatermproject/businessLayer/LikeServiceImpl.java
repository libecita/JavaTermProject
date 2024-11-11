package com.example.javatermproject.businessLayer;

import com.example.javatermproject.dataLayer.LikeRepository;
import com.example.javatermproject.dataMapperLayer.LikeResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final LikeResponseMapper likeResponseMapper;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository,
                           LikeResponseMapper likeResponseMapper){
        this.likeRepository = likeRepository;
        this.likeResponseMapper = likeResponseMapper;
    }

}
