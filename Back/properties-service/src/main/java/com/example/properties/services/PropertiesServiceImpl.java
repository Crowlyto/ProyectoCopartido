/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.properties.services;

import com.example.properties.entity.Properties;
import com.example.properties.repository.IPropertiesrepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crowl
 */
@Service
public class PropertiesServiceImpl implements IPropertiesService {

    @Autowired
    private IPropertiesrepository propRepository;

    @Override
    public Properties save(Properties properties) {

        return propRepository.save(properties);
    }

    @Override
    public List<Properties> findAll() {

        return propRepository.findAll();
    }

    @Override
    public Optional<Properties> findById(Integer id) {
        return propRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        propRepository.deleteById(id);
    }

}
