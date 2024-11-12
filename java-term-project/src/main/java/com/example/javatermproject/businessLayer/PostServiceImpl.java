package com.example.javatermproject.businessLayer;

import com.example.javatermproject.dataLayer.Post;
import com.example.javatermproject.dataLayer.PostRepository;
import com.example.javatermproject.dataMapperLayer.PostRequestMapper;
import com.example.javatermproject.dataMapperLayer.PostResponseMapper;
import com.example.javatermproject.presentationLayer.PostRequestModel;
import com.example.javatermproject.presentationLayer.PostResponseModel;
import com.example.javatermproject.utilities.InUseException;
import org.example.movielistapp.utilities.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final PostResponseMapper postResponseMapper;
    private final PostRequestMapper postRequestMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository,
                           PostResponseMapper postResponseMapper,
                           PostRequestMapper postRequestMapper ) {
        this.postRepository = postRepository;
        this.postResponseMapper = postResponseMapper;
        this.postRequestMapper = postRequestMapper;
    }

    @Override
    public List<PostResponseModel> getPosts() {
        List<Post> posts = this.postRepository.findAll();
        return this.postResponseMapper.entityToResponseModelList(posts);
    }

    @Override
    public PostResponseModel getPostById(String postId) {
        Post foundPost = this.postRepository.getPostByPostIdentifier(postId);
        if(foundPost == null) {
            throw new NotFoundException("Post with id "+postId+ " not found.");
        }
        return this.postResponseMapper.entityToResponseModel(foundPost);
    }

    @Override
    public PostResponseModel addOnePost(PostRequestModel postNewData) {
        Post newPost = this.postRequestMapper.requestMapperToEntity(postNewData);
        Post savedPost = this.postRepository.save(newPost);
        return this.postResponseMapper.entityToResponseModel(savedPost);
    }

    @Override
    public PostResponseModel updatePost(String postId, PostRequestModel postRequestModel) {
        Post foundPost = this.postRepository.getPostByPostIdentifier(postId);
        if(foundPost == null) {
            throw new NotFoundException("Post with id "+postId+ " not found.");
        }

        Post newPost = this.postRequestMapper.requestMapperToEntity(postRequestModel);

        foundPost.setPostIdentifier(newPost.getPostIdentifier());
        foundPost.setDatePosted(newPost.getDatePosted());
        foundPost.setDescription(newPost.getDescription());
        foundPost.setTitle(newPost.getTitle());

        Post savedPost = this.postRepository.save(foundPost);
        return this.postResponseMapper.entityToResponseModel(savedPost);
    }

    @Override
    public String deletePost(String postId) {
        String message =" ";
        Post foundPost = this.postRepository.getPostByPostIdentifier(postId);
        if(foundPost == null) {
            throw new NotFoundException("Post with id "+postId+ " not found.");
        }
        try{
            this.postRepository.delete(foundPost);
            message = "Post deleted";
        }
        catch(DataIntegrityViolationException ex) {
            throw new InUseException("Cannot delete post with id "+postId+" as it is " +
                    "associated with one user.");
        }
        return message;
    }
}
