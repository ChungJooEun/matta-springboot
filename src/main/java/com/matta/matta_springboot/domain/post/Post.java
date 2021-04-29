package com.matta.matta_springboot.domain.post;

import com.matta.matta_springboot.domain.BaseTimeEntity;
import com.matta.matta_springboot.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private String comment;

    @Column(nullable = false)
    private LocalDate visitedDate;

    @Enumerated(EnumType.STRING)
//    @Column(nullable = false, columnDefinition = "default 'STATUS_POST'")
    @Column(nullable = false)
    private PostsStatus postsStatus = PostsStatus.POST;

//    @ManyToOne
//    @JoinColumn(name = "USER_ID")
//    private User user;

//    @ManyToOne
//    @JoinColumn(name = "RESTAURANT_ID")
//    private Restaurant restaurant;
//
//    @OneToOne
//    @JoinColumn(name = "STARRATING_ID", nullable = false)
//    private StarRating starRating;

//    @ManyToOne
//    private Folder folder;

    @Builder
    public Post(String content, String comment, LocalDate visitedDate){
        this.content = content;
        this.comment = comment;
        this.visitedDate = visitedDate;
    }

    public String getPostsStatusKey(){
        return this.postsStatus.getKey();
    }

    // post update method 추가
    public void update(String comment, String content, LocalDate visitedDate){
        this.comment = comment;
        this.content = content;
        this.visitedDate = visitedDate;
    }

}
