package com.a.service;

import com.a.model.entity.Post;
import com.a.model.service.PostServiceModel;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface PostService {
    void add(PostServiceModel postServiceModel);

    List<Post> findMyPosts(String id);

    void removePostById(String id);

    List<Post> findOtherPosts(String userId);

    void likePost(String id, String userId);
}
