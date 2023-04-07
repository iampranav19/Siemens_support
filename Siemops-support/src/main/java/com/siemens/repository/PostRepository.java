package com.siemens.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siemens.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	Optional<Post> findByUrl(String url);
	
}
