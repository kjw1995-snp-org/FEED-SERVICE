package com.snp.feedservice.dto.inquiry;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class InquiryResponseDto {

    private Integer id;

    private Integer memberIdx;

    private String content;

    private String memberId;

    private String memberName;

    private LocalDateTime registDate;

}
