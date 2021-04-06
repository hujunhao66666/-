package com.example.service.Impl;

import com.example.dao.PostDao;
import com.example.domain.Post;
import com.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("postService")
public class PostServiceImpl implements PostService{
    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> findPosts(Map<String, Object> map) {
        return postDao.findPosts(map);
    }

    @Override
    public Integer getCount(Map<String, Object> map) {
        return postDao.getCount(map);
    }

    @Override
    public Integer addPost(Post post) {
        return postDao.addPost(post);
    }

    @Override
    public Integer updatePost(Post post) {
        return postDao.updatePost(post);
    }

    @Override
    public Integer deletePost(Integer id) {
        return postDao.deletePost(id);
    }

    @Override
    public Post getPostById(Integer id) {
        return postDao.getPostById(id);
    }
}
