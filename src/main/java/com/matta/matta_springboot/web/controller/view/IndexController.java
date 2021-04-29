package com.matta.matta_springboot.web.controller.view;

import com.matta.matta_springboot.config.auth.LoginUser;
import com.matta.matta_springboot.config.auth.dto.SessionUser;
import com.matta.matta_springboot.service.post.PostService;
import com.matta.matta_springboot.web.dto.post.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;
    private final PostService postService;

    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user){

        model.addAttribute("post", postService.findAllDesc());

        if(user != null){
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/post/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/post/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){

        PostResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);

        return "post-update";
    }
}
