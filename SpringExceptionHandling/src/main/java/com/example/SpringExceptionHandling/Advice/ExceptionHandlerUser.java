package com.example.SpringExceptionHandling.Advice;

import com.example.SpringExceptionHandling.Exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerUser {

//    Here, the handleMethodArgumentNotValid() method is decorated with two annotations:

//@ResponseStatus : Specifies that a 400 Bad Request status will be returned in the response.
//@ExceptionHandler : Marks this method as a handler for all MethodArgumentNotValidExceptions. in the controller.

//In Line 6, you get the BindingResult for the class by calling getBindingResult() on MethodArgumentNotValidException.
// The BindingResult interface encapsulates information about errors that result from validating a class instance.
// You obtain a collection of FieldError instances from BindingResult by calling its getFieldErrors() method.

//Line 6 – 7 you iterate through the collection and retrieve the field name and error message for each field and put them in the errors Map.
//In Line 8 the Map is returned to the client in JSON format by default.



//    below BAD REQUEST (400) use below method to show exception
    @ResponseStatus(HttpStatus.BAD_REQUEST)
//MethodArgumentNotValidException.class came from controller
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return errors;
    }

//    500 error will receive use below method to show exception
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    UserNotFoundException.class coming from controller whenever this exception will be seen
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String , String> handleBusinessException(UserNotFoundException ex)

    {

        Map<String, String> errors = new HashMap<>();
//        "Error Message": "User not found with id 3"
        errors.put("Error Message", ex.getMessage());
        return errors;
    }
 }
