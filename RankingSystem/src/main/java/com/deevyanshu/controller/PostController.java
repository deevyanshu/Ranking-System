package com.deevyanshu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deevyanshu.entity.Post;
import com.deevyanshu.service.PostService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/post")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping("/all")
	public List<Post> getAll()
	{
		return service.getAll();
	}
	
	@PostMapping("/add")
	public Post add(@RequestBody Post post)
	{
		return service.add(post);
	}
	
	@PutMapping("/points/{id}")
	public Post addPoints(@RequestBody Post post,@PathVariable("id") int id)
	{
		return service.addPoints(post, id);
	}

}
