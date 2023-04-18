/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.repository.IUserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crowl
 */
@Service
public class UserServiceImpl implements IUserService{
    
    @Autowired
    private IUserRepository userRepo;

    @Override
    public User save(User user) {
        
        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }
    
}
