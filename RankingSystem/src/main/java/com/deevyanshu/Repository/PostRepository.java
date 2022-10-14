package com.deevyanshu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deevyanshu.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
