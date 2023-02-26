package com.example.SpringExceptionHandling.Service;

import com.example.SpringExceptionHandling.Dto.UserRequestDto;
import com.example.SpringExceptionHandling.Entity.EntityUser;
import com.example.SpringExceptionHandling.Exception.UserNotFoundException;
import com.example.SpringExceptionHandling.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//save user information
    public EntityUser saveUsers(UserRequestDto userRequestDto)
    {
        EntityUser user= EntityUser.
                build(0, userRequestDto.getName(), userRequestDto.getEmail(),
                        userRequestDto.getMobile(), userRequestDto.getGender(), userRequestDto.getAge(), userRequestDto.getNationality());
        return userRepository.save(user);

    }
//fetch all user
    public List<EntityUser> fetchAllUser()
    {
        return userRepository.findAll();

    }
//fetch single user

    public EntityUser getUser(int id) throws UserNotFoundException {
    EntityUser entityUser= userRepository.findByUserId(id);
    if(entityUser!=null)
    {
        return entityUser;

    }
    else
    {
        throw new UserNotFoundException("User not found with id "+id);

    }


    }
}
