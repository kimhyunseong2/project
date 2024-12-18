package com.example.demo.repository;

import com.example.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardId(Long boardId);

    @Query("SELECT c FROM Comment c " +
            "JOIN Member m ON c.username = m.username " +
            "WHERE m.role = 'USER'")
    List<Comment> findUserComments();
}
