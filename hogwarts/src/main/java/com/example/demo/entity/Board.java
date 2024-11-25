package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String username;  // 작성자 (사용자)

    @Column(nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime modifyDate = LocalDateTime.now();

    @Column(nullable = false)
    private int hit = 0;

    @Column(nullable = false)
    private int likeCount = 0;


    private String filePath;

    private String fileName;

    @ElementCollection // 좋아요를 누른 사용자들의 이름을 저장하는 컬렉션
    @CollectionTable(name = "board_likes", joinColumns = @JoinColumn(name = "id")) // 'board_likes'라는 이름의 테이블을 사용하고, 'id' 컬럼을 기준으로 연결
    @Column(name = "username") // 컬렉션의 각 항목은 'username'이라는 이름의 컬럼에 저장됨
    private Set<String> likedUsernames = new HashSet<>(); // 좋아요를 누른 사용자들의 이름을 저장하는 Set 컬렉션, 중복을 허용하지 않음

    private String role;




}
