package com.example.javatermproject.businessLayer;

import com.example.javatermproject.dataLayer.User;
import com.example.javatermproject.dataLayer.UserRepository;
import com.example.javatermproject.dataMapperLayer.UserRequestMapper;
import com.example.javatermproject.dataMapperLayer.UserResponseMapper;
import com.example.javatermproject.presentationLayer.UserRequestModel;
import com.example.javatermproject.presentationLayer.UserResponseModel;
import com.example.javatermproject.utilities.InUseException;
import org.example.movielistapp.utilities.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserResponseMapper userResponseMapper;;
    private final UserRequestMapper userRequestMapper;

    public UserServiceImpl(UserRepository userRepository,
                           UserResponseMapper userResponseMapper,
                           UserRequestMapper userRequestMapper) {
        this.userRepository = userRepository;
        this.userResponseMapper = userResponseMapper;
        this.userRequestMapper = userRequestMapper;

    }

    @Override
    public List<UserResponseModel> getUsers() {
        List<User> users = userRepository.findAll();
        return this.userResponseMapper.entityToResponseModelList(users);
    }

    @Override
    public UserResponseModel getUserByUserId(String userId) {
        User foundUser = this.userRepository.getUserByUserIdentifier(userId);

        if(foundUser == null)
            throw new NotFoundException("User with id " + userId + " not found");

        return this.userResponseMapper.entityToResponseModel(foundUser);
    }

    @Override
    public UserResponseModel addUser(UserRequestModel newUserData) {
        User newUser = this.userRequestMapper.requestMapperToEntity(newUserData);
        User savedUser = this.userRepository.save(newUser);
        return this.userResponseMapper.entityToResponseModel(savedUser);
    }

    @Override
    public UserResponseModel updateCustomer(String userId, UserRequestModel newUserData) {
        User foundUser = this.userRepository.getUserByUserIdentifier(userId);
        if(foundUser == null){
            throw new NotFoundException("User with id " + userId + " not found");
        }

        User newUser = new User();
        newUser.setId(foundUser.getId());
        newUser.setUserIdentifier(foundUser.getUserIdentifier());
        newUser.setLastName(foundUser.getLastName());
        newUser.setFirstName(foundUser.getFirstName());
        newUser.setEmailAddress(foundUser.getEmailAddress());
        newUser.setUsername(foundUser.getUsername());
        newUser.setRelationshipStatus(foundUser.getRelationshipStatus());
        newUser.setDateOfBirth(foundUser.getDateOfBirth());
        newUser.setDateOfBirth(foundUser.getDateOfBirth());
        newUser.setPassword(foundUser.getPassword());

        User savedUser = userRepository.save(newUser);
        return this.userResponseMapper.entityToResponseModel(savedUser);
    }

    @Override
    public String deleteUserByUserId(String userId) {
        String response=" ";
        User foundUser = this.userRepository.getUserByUserIdentifier(userId);

        if(foundUser == null){
            throw new NotFoundException("User with id " + userId + " not found");

        }
        try {
            userRepository.delete(foundUser);
            response = "User deleted";
        }
        catch (DataIntegrityViolationException ex) {
            throw new InUseException("Cannot delete user with id "+userId+" as it is " +
                    "associated with one or many posts and/or likes.");
        }
        return response;
    }
}
