package com.example.vuebackboard.services;

import com.example.vuebackboard.entity.CommentEntity;
import com.example.vuebackboard.entity.CommentRepository;
import com.example.vuebackboard.web.dtos.CommentDto;

import java.util.ArrayList;
import java.util.List;


public class CommentService {
    private CommentRepository commentRepository;

    public List<CommentDto> getCommentList(Long user_idx){
        List<CommentDto> dtos = new ArrayList<>();

        CommentEntity commentEntities =  commentRepository.findAllByArticle(user_idx);

    }
}




