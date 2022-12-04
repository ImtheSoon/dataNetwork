package com.example.vuebackboard.web;

import com.example.vuebackboard.entity.CommentEntity;
import com.example.vuebackboard.services.CommentService;
import com.example.vuebackboard.web.dtos.CommentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comment/{id}")
    public List<CommentDto> commentList(@PathVariable Long id)
    {return commentService.getCommentList(id);}

    @PostMapping("/comment/write/{id}")
    public CommentEntity add_comment(@RequestBody CommentDto commentDto)
    {return commentService.add_comment(commentDto);}
}
