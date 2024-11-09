package com.example.javatermproject.presentationLayer;

//import com.example.javatermproject.businessLayer.LikeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/likes")
public class LikeController {

    private LikeService likeService;
    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping()
    public List<LikeResponseModel> getLikes(){
        return likeService.getMovies();
    }

    @GetMapping("/{like_id}")
    public LikeResponseModel getLikeById(@PathVariable String user_id){
        return likeService.getLikeById(user_id);
    }

    @PostMapping()
    public LikeResponseModel addOneLike(@RequestBody LikeRequestModel likeRequestModel) {
        return likeService.addOneLike(likeRequestModel);
    }

    @PutMapping("/{like_id}")
    public LikeResponseModel updateLike(@PathVariable String like_id, @RequestBody LikeRequestModel likeRequestModel) {
        return likeService.updateLike(like_id, likeRequestModel);
    }

    @DeleteMapping("/{like_id}")
    public String deleteLike(@PathVariable String like_id) {
        return likeService.deleteLike(like_id);
    }



}