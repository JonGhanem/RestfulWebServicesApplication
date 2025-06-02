package com.ghanem.RestfulWebServicesApplication.socialmedia.controller;

import com.ghanem.RestfulWebServicesApplication.socialmedia.bean.Post;
import com.ghanem.RestfulWebServicesApplication.socialmedia.bean.User;
import com.ghanem.RestfulWebServicesApplication.socialmedia.exception.UserNotFoundException;
import com.ghanem.RestfulWebServicesApplication.socialmedia.repo.PostRepository;
import com.ghanem.RestfulWebServicesApplication.socialmedia.repo.UserRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/jpa")
public class UserJPAResource {

    @Autowired
    private UserRepo userRepo;
    private PostRepository postRepository;

    public UserJPAResource(UserRepo userRepo, PostRepository postRepository) {
        this.userRepo = userRepo;
        this.postRepository = postRepository;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveUser(){
        return userRepo.findAll().reversed();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveOneUser(@PathVariable Long id) {
        Optional<User> user = userRepo.findById(id);

        if(user==null)
            throw new UserNotFoundException("id:"+id);

        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveUser());
        entityModel.add(link.withRel("get-all-users"));

        return entityModel;
    }


    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

        User savedUser = userRepo.save(user);
        // return in the header
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/user/{id}")
    public void DeleteOneUser(@PathVariable Long id){
        userRepo.deleteById(id);
    }

    @GetMapping("/users/{id}/posts") ///api/v1/jpa/users/{id}/posts
    public List<Post> retrievePostsForUser(@PathVariable Long id) {
        Optional<User> user = userRepo.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:"+id);

        return user.get().getPosts();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable Long id, @Valid @RequestBody Post post) {
        Optional<User> user = userRepo.findById(id);

        if(user.isEmpty())
            throw new UserNotFoundException("id:"+id);
        post.setUser(user.get());


        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


}
