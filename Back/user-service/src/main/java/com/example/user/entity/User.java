/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.user.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author crowl
 */
@Data
@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @Column(unique = true, length = 12)
    private String userName;
    private String password;
    @Column(unique = true)
    private String email;
    private String image;
    private Date alta;
    private Boolean active;
    private String rol;
    private String telefono;
    
    @PrePersist
    public void altaActive(){
        this.alta=new Date();
        this.active=Boolean.TRUE;
    }
    
}
