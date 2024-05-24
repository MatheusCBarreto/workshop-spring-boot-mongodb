package com.matheusbarreto.workshopmongodb.resources;

import com.matheusbarreto.workshopmongodb.domain.User;
import com.matheusbarreto.workshopmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> userList = service.findAll();
        return ResponseEntity.ok().body(userList);
    }
}
