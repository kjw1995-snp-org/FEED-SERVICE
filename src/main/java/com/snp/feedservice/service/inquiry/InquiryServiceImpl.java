package com.snp.feedservice.service.inquiry;

import com.snp.feedservice.common.url.UserServiceUrl;
import com.snp.feedservice.configuration.properties.BaseProperties;
import com.snp.feedservice.dto.api.response.ApiResponseDto;
import com.snp.feedservice.dto.inquiry.InquiryResponseDto;
import com.snp.feedservice.dto.inquiry.member.MemberinquiryResponseDto;
import com.snp.feedservice.jpa.entity.Feed;
import com.snp.feedservice.jpa.repository.FeedRepository;
import com.snp.feedservice.util.SenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InquiryServiceImpl implements InquiryService {

    @Autowired
    private FeedRepository feedRepository;

    @Autowired
    private SenderUtils senderUtils;

    @Autowired
    private BaseProperties baseProperties;

    @Override
    public ApiResponseDto<List<InquiryResponseDto>> feeds() {
        List<InquiryResponseDto> result = new ArrayList<InquiryResponseDto>();
        List<Integer> memberIdxList = new ArrayList<Integer>();
        List<Feed> feeds = feedRepository.findAll();

        for(Feed feed : feeds){

            InquiryResponseDto inquiryResponseDto = new InquiryResponseDto();
            inquiryResponseDto.setId(feed.getId());
            inquiryResponseDto.setMemberIdx(feed.getMemberIdx());
            inquiryResponseDto.setContent(feed.getContent());
            inquiryResponseDto.setRegistDate(feed.getRegistDate());
            result.add(inquiryResponseDto);

            Integer memberIdx = feed.getMemberIdx();
            memberIdxList.add(memberIdx);

        }

        ApiResponseDto<List<MemberinquiryResponseDto>> apiResponseDto = senderUtils.send(
                baseProperties.getUserService().getHost(),
                UserServiceUrl.INQUIRY_MEMBERS,
                HttpMethod.POST,
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_JSON,
                memberIdxList,
                new ParameterizedTypeReference<ApiResponseDto<List<MemberinquiryResponseDto>>>() {}
        );

        List<MemberinquiryResponseDto> memberInquiryResponseDto = apiResponseDto.getData();
        Map<Integer, MemberinquiryResponseDto> memberMap = new HashMap<Integer, MemberinquiryResponseDto>();
        for(MemberinquiryResponseDto responseDto : memberInquiryResponseDto){
            memberMap.put(responseDto.getMemberIdx(), responseDto);
        }

        for(InquiryResponseDto dto : result) {

            if(memberMap.containsKey(dto.getMemberIdx())){
                dto.setMemberId(memberMap.get(dto.getMemberIdx()).getMemberId());
                dto.setMemberName(memberMap.get(dto.getMemberIdx()).getMemberName());
            }

        }

        ApiResponseDto<List<InquiryResponseDto>> response = ApiResponseDto.<List<InquiryResponseDto>>builder()
                .status(ApiResponseDto.ApiResponseStatus.SUC)
                .message("피드 리스트 조회 성공")
                .data(result)
                .build();

        return response;
    }

}
