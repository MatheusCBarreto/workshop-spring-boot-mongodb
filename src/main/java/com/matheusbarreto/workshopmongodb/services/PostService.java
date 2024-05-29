package com.matheusbarreto.workshopmongodb.services;

import com.matheusbarreto.workshopmongodb.domain.Post;
import com.matheusbarreto.workshopmongodb.domain.User;
import com.matheusbarreto.workshopmongodb.repository.PostRepository;
import com.matheusbarreto.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<Post> findByTitle(String title) {
        return repository.searchTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
