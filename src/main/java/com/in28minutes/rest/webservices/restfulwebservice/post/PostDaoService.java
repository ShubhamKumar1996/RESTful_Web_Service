package com.in28minutes.rest.webservices.restfulwebservice.post;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostDaoService {
    private static List<Post> posts = new ArrayList<>();

    static{
        posts.add(new Post(1, "Core Java", "Basics of Java", 2));
        posts.add(new Post(2, "Advanced Java", "Intermediate Java", 2));
        posts.add(new Post(3, "Spring Framework", "Java Framework", 1));
    }

    public List<Post> findAll(){
        return posts;
    }

    public List<Post> findAll(int userId){
        List<Post>postsForUser = new ArrayList<>();
        for(Post post: posts){
            if(post.getUserId() == userId){
                postsForUser.add(post);
            }
        }
        return postsForUser;
    }

    public Post findOne(int id, int user_id){
        Post requiredPost = null;
        for(Post post: posts){
            if((post.getPostId() == id) && (post.getUserId() == user_id)){
                requiredPost = post;
                break;
            }
        }
        return requiredPost;
    }

    public List<Post> save(Post post){
        List<Post>newPosts = posts;
        newPosts.add(post);
        posts = newPosts;
        return posts;
    }
}
