package com.siemens.mapper;

import java.beans.Beans;

import org.springframework.beans.BeanUtils;

import com.siemens.dto.PostDto;
import com.siemens.entity.Post;

public class PostMapper {

	// map Post entity to Post Dto
	public static PostDto mapToPostDto(Post post)
	{
		PostDto postDto=new PostDto();
		BeanUtils.copyProperties(post, postDto);
		return postDto;
	}
	
	// map to PostDto to Post
	public static Post mapToPost(PostDto postDto)
	{
		Post post=new Post();
		BeanUtils.copyProperties(postDto, post);
		return post;
	}
}
