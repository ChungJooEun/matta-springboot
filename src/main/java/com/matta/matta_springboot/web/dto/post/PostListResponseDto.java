package com.matta.matta_springboot.web.dto.post;

import com.matta.matta_springboot.domain.post.Post;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostListResponseDto {

    private Long id;
    private String comment;
    private String content;
    private LocalDate visitedDate;

    public PostListResponseDto(Post entity) {
        this.id = entity.getId();
        this.comment = entity.getComment();
        this.content = entity.getContent();
        this.visitedDate = entity.getVisitedDate();
    }
}
