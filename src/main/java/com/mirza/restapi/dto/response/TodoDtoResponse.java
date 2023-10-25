package com.mirza.restapi.dto.response;

import com.mirza.restapi.enums.StatusEnum;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TodoDtoResponse {
    private Long id;
    private String todo;
    private StatusEnum status;
}
