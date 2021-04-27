package com.matta.matta_springboot.domain.post;

import com.matta.matta_springboot.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 100, nullable = false)
    private String comment;

    @Column(nullable = false)
    private LocalDateTime occurDateTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PostsStatus postsStatus;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "RESTAURANT_ID")
//    private Restaurant restaurant;
//
//    @OneToOne
//    @JoinColumn(name = "STARRATING_ID", nullable = false)
//    private StarRating starRating;

//    @ManyToOne
//    private Folder folder;



}
