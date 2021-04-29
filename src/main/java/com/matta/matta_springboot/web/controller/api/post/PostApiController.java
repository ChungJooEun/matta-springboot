package com.matta.matta_springboot.web.controller.api.post;

import com.matta.matta_springboot.service.post.PostService;
import com.matta.matta_springboot.web.dto.post.PostSaveRequestDto;
import com.matta.matta_springboot.web.dto.post.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto request){

        return postService.save(request);
    }

    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @PutMapping("/api/v1/post/delete/{id}")
    public Long delete(@PathVariable Long id) {
        return postService.delete(id);
    }
}
