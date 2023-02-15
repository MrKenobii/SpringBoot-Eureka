package com.kenobi.userservice.controller;

import com.kenobi.userservice.entities.User;
import com.kenobi.userservice.services.UserService;
import com.kenobi.userservice.services.impl.UserServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @GetMapping("/{userId}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUser(userId));
    }

    //creating fallback method for circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId, Exception exception){
        logger.info("Fallback is executed because service is down: ", exception.getMessage());
        return new ResponseEntity<>(User
                .builder()
                .email("dummy@mail.com")
                .name("Dummy")
                .about("This user is created because some services is down")
                .userId("123123")
                .build(), HttpStatus.OK);
    }

}
