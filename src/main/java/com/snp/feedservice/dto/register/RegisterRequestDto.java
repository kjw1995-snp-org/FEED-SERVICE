package com.snp.feedservice.dto.register;

import lombok.Data;

@Data
public class RegisterRequestDto {

    private Integer memberIdx;

    private String title;

    private String content;

}
