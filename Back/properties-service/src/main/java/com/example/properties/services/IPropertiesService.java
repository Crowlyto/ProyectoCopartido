/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.properties.services;

import com.example.properties.entity.Properties;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author crowl
 */
public interface IPropertiesService {
    // este comentario lo realizo damian

    public Properties save(Properties properties);

    public List<Properties> findAll();

    public Optional<Properties> findById(Integer id);

    public void deleteById(Integer id);
}
