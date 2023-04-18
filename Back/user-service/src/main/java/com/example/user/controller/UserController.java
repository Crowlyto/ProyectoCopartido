/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserServiceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author crowl
 */
@RestController
@RequestMapping("/usuario")
public class UserController {
    
    @Autowired
    private UserServiceImpl userService;
    
    @GetMapping
    public ResponseEntity<?> listarUsuarios(){
        List<User> usuarios=userService.findAll();
        if(usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        User user= userService.findById(id).get();
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/{userName}")
    public ResponseEntity<?> buscarPorUsername(@PathVariable String userName){
        User user= userService.findByUserName(userName).get();
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    
    @PostMapping
    public ResponseEntity<?> guardarUser(@RequestBody User user){
        User nuevoUser=userService.save(user);
        
        return ResponseEntity.ok(nuevoUser);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> modificarUser(@PathVariable Integer id, @RequestBody User user){
        Optional<User>users =userService.findById(id);
        if(users.isPresent()){
            User nuevoUser=users.get();
            nuevoUser.setNombre(user.getNombre());
            nuevoUser.setApellido(user.getApellido());
            nuevoUser.setEmail(user.getEmail());
            nuevoUser.setRol(user.getRol());
            userService.save(nuevoUser);
            return ResponseEntity.ok(nuevoUser);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id")
    public ResponseEntity<?> eliminarId(@PathVariable Integer id){
        Optional<User>users =userService.findById(id);
        if(users.isPresent()){
            
            userService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
               
    }
}
