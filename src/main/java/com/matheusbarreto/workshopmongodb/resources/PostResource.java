package com.matheusbarreto.workshopmongodb.resources;

import com.matheusbarreto.workshopmongodb.domain.Post;

import com.matheusbarreto.workshopmongodb.resources.util.URL;
import com.matheusbarreto.workshopmongodb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodedParams(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
