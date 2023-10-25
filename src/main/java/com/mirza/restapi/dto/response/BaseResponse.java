package com.mirza.restapi.dto.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private Integer status;
    private String message;
    private T data;
}
