package com.example.javatermproject.presentationLayer;

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
    public PostResponseModel getPostsById(@PathVariable String post_id) {
        return postService.getPostsById(post_id);
    }

    @PostMapping("/{post_id}")
    public PostResponseModel addOnePost(@RequestBody PostRequestModel postRequestModel) {
        return postService.addOnePost(postRequestModel);
    }

    @PutMapping("/{post_id}")
    public PostResponseModel updatePost(@PathVariable String post_id
                                        @RequestBody PostRequestModel postRequestModel) {
        return postService.updatePost(post_id, postRequestModel);
    }

    @DeleteMapping("/{post_id}")
    public String deletePost(@PathVariable String post_id) {
        return postService.deletePost(post_id);
    }


}