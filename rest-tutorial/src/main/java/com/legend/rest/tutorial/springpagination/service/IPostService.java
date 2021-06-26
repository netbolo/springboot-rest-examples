package com.legend.rest.tutorial.springpagination.service;

import java.util.List;

import com.legend.rest.tutorial.springpagination.model.Post;

public interface IPostService {

    List<Post> getPostsList(int page, int size, String sortDir, String sort);

    void updatePost(Post post);

    Post createPost(Post post);

    Post getPostById(Long id);

}
