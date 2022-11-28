package com.example.vuebackboard.web.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto implements Serializable {
    private Long idx;
    private Long board_idx;
    private Long user_idx;
    private String comment_data;
    private String created_at;
    private int removed;
}
