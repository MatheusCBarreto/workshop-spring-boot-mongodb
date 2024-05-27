package com.matheusbarreto.workshopmongodb.services;

import com.matheusbarreto.workshopmongodb.domain.User;
import com.matheusbarreto.workshopmongodb.dto.UserDTO;
import com.matheusbarreto.workshopmongodb.repository.UserRepository;
import com.matheusbarreto.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return repository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }


    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
