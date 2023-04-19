/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.properties.controller;

import com.example.properties.entity.Properties;
import com.example.properties.services.PropertiesServiceImpl;
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
@RequestMapping("/propiedad")
public class PropertiesController {

    @Autowired
    private PropertiesServiceImpl propServ;

    @GetMapping
    public ResponseEntity<?> listar() {
        List<Properties> props = propServ.findAll();
        if (props.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(props);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarId(@PathVariable Integer id) {
        Properties prop = propServ.findById(id).get();
        if (prop == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prop);

    }

    @PostMapping
    public ResponseEntity<?> savePropertie(@RequestBody Properties prop) {
        Properties newProp = propServ.save(prop);
        return ResponseEntity.ok(newProp);

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?>modificarProp(@PathVariable Integer id, @RequestBody Properties prop){
        Optional<Properties>props=propServ.findById(id);
        if(props.isPresent()){
            Properties newProp=props.get();
            newProp.setNombre(prop.getNombre());
            newProp.setDescripcion(prop.getDescripcion());
            newProp.setPrecioDia(prop.getPrecioDia());
            newProp.setActive(prop.getActive());
            newProp.setTipo(prop.getTipo());
            propServ.save(newProp);
            return ResponseEntity.ok(newProp);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        Optional<Properties>prop=propServ.findById(id);
        if(prop.isPresent()){
            propServ.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
        
    }


}
