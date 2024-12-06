package com.example.javatermproject.presentationLayer;

import com.example.javatermproject.businessLayer.UserService;
import com.example.javatermproject.dataLayer.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin (origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<UserResponseModel> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/{user_id}")
    public UserResponseModel getUser(@PathVariable String user_id){
        return this.userService.getUserByUserId(user_id);
    }

    @PostMapping()
    public UserResponseModel addUser(@RequestBody UserRequestModel newUserData){
        return this.userService.addUser(newUserData);
    }

    @PutMapping("/{user_id}")
    public UserResponseModel updateUser(@PathVariable String user_id,
                             @RequestBody UserRequestModel newUserData){

        return this.userService.updateCustomer(user_id, newUserData);
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable String user_id){
        this.userService.deleteUserByUserId(user_id);
    }

    @GetMapping("/posts/{user_id}")
    public List<PostResponseModel> getPostsByUserIdentifier(@PathVariable String user_id){
        return this.userService.getPostsByUserIdentifier(user_id);
    }
}