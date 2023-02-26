package com.example.SpringExceptionHandling.Controller;

import com.example.SpringExceptionHandling.Dto.UserRequestDto;
import com.example.SpringExceptionHandling.Entity.EntityUser;
import com.example.SpringExceptionHandling.Exception.UserNotFoundException;
import com.example.SpringExceptionHandling.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    save post call
    @PostMapping("/signup")
    public ResponseEntity<EntityUser> saveUser(@RequestBody @Valid UserRequestDto userRequestDto)
    {
return new ResponseEntity<>(userService.saveUsers(userRequestDto), HttpStatus.CREATED);
    }


// Get all Users

    @GetMapping("/fetchAll")
    public ResponseEntity<List<EntityUser>> getAllUser()
    {
        return ResponseEntity.ok(userService.fetchAllUser());

    }
//get Single User
//    using throws UserNotFoundException bcoz when user will hit this API it will throw en ERROR when no user found
    @GetMapping("/{id}")
    public ResponseEntity<EntityUser> getSingleUser(@PathVariable int id) throws UserNotFoundException
    {
        return ResponseEntity.ok(userService.getUser(id));

    }

}
