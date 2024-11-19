package com.example.javatermproject.presentationLayer;

import com.example.javatermproject.businessLayer.PostService;
import com.example.javatermproject.dataLayer.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public List<PostResponseModel> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/{post_id}")
    public PostResponseModel getPostById(@PathVariable String post_id) {
        return postService.getPostById(post_id);
    }

    @PostMapping()
    public PostResponseModel addOnePost(@RequestBody PostRequestModel postNewData) {
        return postService.addOnePost(postNewData);
    }

    @PutMapping("/{post_id}")
    public PostResponseModel updatePost(@PathVariable String post_id,
                                        @RequestBody PostRequestModel postRequestModel) {
        return postService.updatePost(post_id, postRequestModel);
    }

    @DeleteMapping("/{post_id}")
    public String deletePost(@PathVariable String post_id) {
        return postService.deletePost(post_id);
    }

    @GetMapping("/{username}")
    public List<Post> getPostsByUsername(@PathVariable String username){
        return this.postService.getPostsByUsername(username);
    }


}