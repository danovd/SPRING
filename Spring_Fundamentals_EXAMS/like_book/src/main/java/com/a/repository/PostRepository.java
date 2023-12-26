package com.a.repository;

import com.a.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {



    @Query("SELECT p FROM Post p WHERE p.user.id = :id")
    List<Post> findMyPosts(String id);
    @Query("SELECT p FROM Post p WHERE p.user.id <> :id")
    List<Post> findOtherPosts(String id);
}
