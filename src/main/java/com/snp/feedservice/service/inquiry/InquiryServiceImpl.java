package com.snp.feedservice.service.inquiry;

import com.snp.feedservice.dto.api.response.ApiResponseDto;
import com.snp.feedservice.jpa.entity.Feed;
import com.snp.feedservice.jpa.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryServiceImpl implements InquiryService {

    @Autowired
    FeedRepository feedRepository;

    @Override
    public ApiResponseDto<List<Feed>> feeds() {

        List<Feed> feeds = feedRepository.findAll();

        return ApiResponseDto.<List<Feed>>builder()
                             .message("피드 조회 성공!!")
                             .status(ApiResponseDto.ApiResponseStatus.SUC)
                             .data(feeds)
                             .build();
    }
}
