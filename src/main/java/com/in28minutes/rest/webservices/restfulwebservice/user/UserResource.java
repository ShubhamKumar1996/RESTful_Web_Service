package com.in28minutes.rest.webservices.restfulwebservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        List<User>users = service.findAll();
        if(users.isEmpty()){
            throw new UserNotFoundException("No User Found");
        }
        return users;
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id-"+id);
        }

        //"all-users", "SERVER_PATH + "/users"
        //retrieveAllUsers
        EntityModel<User> resource = EntityModel.of(user);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    // input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        if(savedUser == null){
            throw new UserNotFoundException("No User Found");
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // My work

    // DELETE    /users/{id}
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User deletedUser = service.deleteById(id);
        if(deletedUser == null){
            throw new UserNotFoundException(String.format("User with id = %d, Not Found", id));
        }
    }

}
