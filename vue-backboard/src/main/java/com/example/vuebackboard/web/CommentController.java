package com.example.vuebackboard.web;

import com.example.vuebackboard.entity.CommentEntity;
import com.example.vuebackboard.model.Header;
import com.example.vuebackboard.model.SearchCondition;
import com.example.vuebackboard.services.CommentService;
import com.example.vuebackboard.web.dtos.BoardDto;
import com.example.vuebackboard.web.dtos.CommentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/board/{id}")
    public List<CommentDto> commentList(@PathVariable Long id)
            {return commentService.getCommentList(id);}
}
