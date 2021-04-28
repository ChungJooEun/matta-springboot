package com.matta.matta_springboot.web.controller.api.post;

import com.matta.matta_springboot.service.post.PostService;
import com.matta.matta_springboot.web.dto.post.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto request){

        return postService.save(request);
    }
}
