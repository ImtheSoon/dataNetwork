package com.example.vuebackboard.services;

import com.example.vuebackboard.entity.CommentEntity;
import com.example.vuebackboard.entity.CommentRepository;
import com.example.vuebackboard.web.dtos.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<CommentDto> getCommentList(Long id){
        List<CommentEntity> commentEntities = commentRepository.findAll();
        List<CommentDto> dtos = new ArrayList<>();

        for(CommentEntity entity: commentEntities){
            CommentDto dto = CommentDto.builder()
                    .idx(entity.getIdx())
                    .board_idx(entity.getBoard_idx())
                    .user_idx(entity.getUser_idx())
                    .comment_data(entity.getComment_data())
                    .build();

            dtos.add(dto);
        }
        return dtos;
    }

    public CommentEntity add_comment(CommentDto commentDto){
        CommentEntity entity = CommentEntity.builder()
                .board_idx(commentDto.getBoard_idx())
                .user_idx((commentDto.getUser_idx()))
                .comment_data((commentDto.getComment_data()))
                .build();
        return commentRepository.save(entity);
    }
}