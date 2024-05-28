package com.matheusbarreto.workshopmongodb.config;

import com.matheusbarreto.workshopmongodb.domain.Post;
import com.matheusbarreto.workshopmongodb.domain.User;
import com.matheusbarreto.workshopmongodb.repository.PostRepository;
import com.matheusbarreto.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);

        postRepository.save(post1);
    }
}
