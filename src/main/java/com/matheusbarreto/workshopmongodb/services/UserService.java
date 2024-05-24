package com.matheusbarreto.workshopmongodb.services;

import com.matheusbarreto.workshopmongodb.domain.User;
import com.matheusbarreto.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
