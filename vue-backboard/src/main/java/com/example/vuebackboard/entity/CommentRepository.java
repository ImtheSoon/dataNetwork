package com.example.vuebackboard.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
        List<CommentEntity> findAllByArticle(Long user_idx);
        }
