package com.snp.feedservice.dto.inquiry.member;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberinquiryResponseDto {

    private Integer memberIdx;

    private String memberId;

    private String memberName;

}
