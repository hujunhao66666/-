package com.example.service;

import com.example.domain.Post;

import java.util.List;
import java.util.Map;

public interface PostService {
    public List<Post> findPosts(Map<String,Object> map);

    public Integer getCount(Map<String,Object> map);

    public Integer addPost(Post post);

    public Integer updatePost(Post post);

    public Integer deletePost(Integer id);

    public Post getPostById(Integer id);
}
