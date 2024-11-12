package com.example.javatermproject.presentationLayer;

import com.example.javatermproject.businessLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-users")
    public List<UserResponseModel> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/get-user/{user_id}")
    public UserResponseModel getUser(@PathVariable String user_id){
        return this.userService.getUserByUserId(user_id);
    }

    @PostMapping("add-user")
    public UserResponseModel addUser(@RequestBody UserRequestModel newUserData){
        return this.userService.addUser(newUserData);
    }

    @PutMapping("update-user/{user_id}")
    public UserResponseModel updateUser(@PathVariable String user_id,
                             @RequestBody UserRequestModel newUserData){

        return this.userService.updateCustomer(user_id, newUserData);
    }

    @DeleteMapping("delete-user/{user_id}")
    public String deleteUser(@PathVariable String user_id){
        return this.userService.deleteUserByUserId(user_id);
    }
}