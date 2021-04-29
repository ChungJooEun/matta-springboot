package com.matta.matta_springboot.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p ORDER BY p.id DESC ")
    List<Post> findAllDesc();

    @Query("SELECT p FROM Post p WHERE p.postsStatus = 'POST' ORDER BY p.id DESC")
    List<Post> findAllPostStatusDesc();

    @Modifying
    @Query("UPDATE Post p SET p.postsStatus = 'DELETE' WHERE p.id = :id")
    void deletePost(@Param("id") Long id);

}
