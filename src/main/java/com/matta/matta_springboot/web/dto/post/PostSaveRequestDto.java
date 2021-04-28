package com.matta.matta_springboot.web.dto.post;

import com.matta.matta_springboot.domain.post.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {

    private String content;
    private String comment;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitedDate;

    @Builder
    public PostSaveRequestDto(String content, String comment, LocalDate visitedDate){
        this.content = content;
        this.comment = comment;
        this.visitedDate = visitedDate;
    }

    public Post toEntity(){
        return Post.builder()
                .content(content)
                .comment(comment)
                .visitedDate(visitedDate)
                .build();
    }

}
