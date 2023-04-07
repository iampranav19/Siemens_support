package com.siemens.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.siemens.dto.PostDto;
import com.siemens.entity.Post;
import com.siemens.mapper.PostMapper;
import com.siemens.repository.PostRepository;
import com.siemens.service.PostService;

import jakarta.persistence.PostRemove;

@Service
public class PostServiceImpl implements PostService {

	
	@Autowired
	PostRepository postRepository;
	
	public List<PostDto> findAllPost() {
		// TODO Auto-generated method stub
		List<Post> posts = postRepository.findAll();
		return posts.stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());
	}

	@Override
	public void createPost(PostDto postDto) {
		// TODO Auto-generated method stub
		Post post = PostMapper.mapToPost(postDto);
		postRepository.save(post);
	}

}
