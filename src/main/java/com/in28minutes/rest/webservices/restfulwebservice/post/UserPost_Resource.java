package com.in28minutes.rest.webservices.restfulwebservice.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserPost_Resource {

    @Autowired
    private PostDaoService service;

    @GetMapping("/users/{userId}/posts")
    public List<Post> retrieveAllPostForUser(@PathVariable int userId){
        return service.findAll(userId);
    }

    @PostMapping("/users/{id}/posts")
    public List<Post> createPost(@RequestBody Post post){
        return service.save(post);
    }




//    6. Create a post for a user         - POST
//7. Retrieve details of a post       - GET   /users/{id}/posts/{post_id}
//7. Delete a post for a user         - DELETE    /users/{id}/posts/{post_id}
}
