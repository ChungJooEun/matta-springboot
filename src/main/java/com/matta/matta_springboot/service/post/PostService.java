package com.matta.matta_springboot.service.post;

import com.matta.matta_springboot.domain.post.Post;
import com.matta.matta_springboot.domain.post.PostRepository;
import com.matta.matta_springboot.web.dto.post.PostListResponseDto;
import com.matta.matta_springboot.web.dto.post.PostResponseDto;
import com.matta.matta_springboot.web.dto.post.PostSaveRequestDto;
import com.matta.matta_springboot.web.dto.post.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PostUpdate;
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

        return postRepository.findAllPostStatusDesc().stream()
                .map(post -> new PostListResponseDto(post))
                .collect(Collectors.toList());
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        post.update(requestDto.getComment(), requestDto.getContent(), requestDto.getVisitedDate());

        return id;
    }

    @Transactional
    public Long delete(Long id){
        postRepository.deletePost(id);

        return id;
    }

    public PostResponseDto findById(Long id) {
        Post entity = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostResponseDto(entity);
    }


}