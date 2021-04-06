package com.example.dao;

import com.example.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PostDao {
    public List<Post> findPosts(Map<String,Object> map);

    public Integer getCount(Map<String,Object> map);

    public Integer addPost(Post post);

    public Integer updatePost(Post post);

    public Integer deletePost(Integer id);

    public Post getPostById(Integer id);
}
