package com.matta.matta_springboot.service.post;

import com.matta.matta_springboot.domain.post.PostRepository;
import com.matta.matta_springboot.web.dto.post.PostListResponseDto;
import com.matta.matta_springboot.web.dto.post.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public List<PostListResponseDto> findAllDesc() {
        return postRepository.findAllDesc().stream()
                .map(post -> new PostListResponseDto(post))
                .collect(Collectors.toList());
    }
}