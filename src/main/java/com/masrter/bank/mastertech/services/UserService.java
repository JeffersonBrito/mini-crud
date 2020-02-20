package com.masrter.bank.mastertech.services;

import com.masrter.bank.mastertech.exceptions.UserNotFoundException;
import com.masrter.bank.mastertech.models.User;
import com.masrter.bank.mastertech.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired // Injeção de dependência
    private UserRepository userRepository;

    public User salvarUser(User user){
       User obj = userRepository.save(user);
        return obj;
    }

    public List<User> pegarUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(int id){
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent())  {
            userRepository.delete(optional.get());
        }else{
            throw new UserNotFoundException();
        }
    }

    public Optional<User> updateUser(int id, User user){
        Optional<User> user1 = userRepository.findById(id);
        user.setId(id);
        userRepository.save(user);
        return user1;
    }

    public Optional<User> findById(int id){
        Optional<User> user = userRepository.findById(id);
        return user;
    }

}
