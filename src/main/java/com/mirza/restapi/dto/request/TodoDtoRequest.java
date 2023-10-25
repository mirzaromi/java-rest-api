package com.mirza.restapi.dto.request;

import com.mirza.restapi.enums.StatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TodoDtoRequest {
    @NotNull
    private String todo;
    @NotNull
    private StatusEnum status;
}
