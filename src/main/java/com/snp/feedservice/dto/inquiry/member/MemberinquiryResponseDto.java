package com.snp.feedservice.dto.inquiry.member;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberinquiryResponseDto {

    private String memberId;

    private String memberName;

}
