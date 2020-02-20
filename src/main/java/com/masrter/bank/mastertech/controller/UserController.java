package com.masrter.bank.mastertech.controller;

import com.masrter.bank.mastertech.models.User;
import com.masrter.bank.mastertech.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> users(){
        List<User> users = userService.pegarUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/users")
    public ResponseEntity<?> salvarUser(@RequestBody User user){
        User obj = userService.salvarUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable int id){
       Optional<User> user1 = userService.updateUser(id, user);
       if (!user1.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<?> EncontrarUser(@PathVariable("id") int id){
        Optional<User> obj = userService.findById(id);
        if (!obj.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

}
