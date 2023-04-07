package com.siemens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.siemens.dto.PostDto;
import com.siemens.service.PostService;
import com.siemens.service.impl.PostServiceImpl;

import jakarta.validation.Valid;

@Controller
public class PostController {

	 private PostService postService;

	    public PostController(PostService postService) {
	        this.postService = postService;
	    }

	    // create handler method, GET request and return model and view
	    @GetMapping("/admin/posts")
	    public String posts(Model model){
	        List<PostDto> posts = postService.findAllPost();
	        model.addAttribute("posts", posts);
	        return "/admin/posts";
	    }

	    // handler method to handle new post request
	    @GetMapping("admin/posts/newpost")
	    public String newPostForm(Model model){
	        PostDto postDto = new PostDto();
	        model.addAttribute("post", postDto);
	        return "admin/create_post";
	    }

	    // handler method to handle form submit request
	    @PostMapping("/admin/posts")
	    public String createPost(@Valid @ModelAttribute("post") PostDto postDto,
	                             BindingResult result,
	                             Model model){
	        if(result.hasErrors()){
	            model.addAttribute("post", postDto);
	            return "admin/create_post";
	        }
	        postDto.setUrl(getUrl(postDto.getTitle()));
	        postService.createPost(postDto);
	        return "redirect:/admin/posts";
	    }

	    private static String getUrl(String postTitle){
	        // OOPS Concepts Explained in Java
	        // oops-concepts-explained-in-java
	        String title = postTitle.trim().toLowerCase();
	        String url = title.replaceAll("\\s+", "-");
	        url = url.replaceAll("[^A-Za-z0-9]", "-");
	        return url;
	    }


}
