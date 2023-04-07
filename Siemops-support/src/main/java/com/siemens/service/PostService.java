package com.siemens.service;

import java.util.List;

import com.siemens.dto.PostDto;

public interface PostService {

	
	List<PostDto> findAllPost();
	
	void createPost(PostDto postDto);
}
