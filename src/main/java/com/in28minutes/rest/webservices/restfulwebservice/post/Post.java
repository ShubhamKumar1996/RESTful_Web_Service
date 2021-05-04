package com.in28minutes.rest.webservices.restfulwebservice.post;

public class Post {

    private int postId;

    private String topic;

    private String description;

    private int userId;

    public Post(int postId, String topic, String description, int userId) {
        this.postId = postId;
        this.topic = topic;
        this.description = description;
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }
}
