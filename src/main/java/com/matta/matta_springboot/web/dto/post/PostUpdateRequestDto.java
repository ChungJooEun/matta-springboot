package com.matta.matta_springboot.web.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {

    private String comment;
    private String content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate visitedDate;

    @Builder
    public PostUpdateRequestDto(String comment, String content, LocalDate visitedDate) {
        this.comment = comment;
        this.content = content;
        this.visitedDate = visitedDate;
    }
}
