/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.user.service;

import com.example.user.entity.User;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author crowl
 */
public interface IUserService {
    
    public User save(User user);
    public List<User> findAll();
    public Optional<User> findById(Integer id);
    public Optional<User> findByUserName(String userName);
    public void deleteById(Integer id);
    
}
