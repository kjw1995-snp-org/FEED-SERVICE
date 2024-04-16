package com.snp.feedservice.service.register;

import com.snp.feedservice.dto.api.response.ApiResponseDto;
import com.snp.feedservice.dto.register.RegisterRequestDto;
import com.snp.feedservice.jpa.entity.Feed;
import com.snp.feedservice.jpa.repository.FeedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private FeedRepository feedRepository;

    @Override
    public ApiResponseDto<Object> register(RegisterRequestDto requestDto) {

        Feed feed = null;

        try {

            feed = Feed.builder()
                       .memberIdx(requestDto.getMemberIdx())
                       .content(requestDto.getContent())
                       .registDate(LocalDateTime.now())
                       .build();

            feedRepository.save(feed);

        } catch(Exception e) {
            log.info("Feed Register Exception", e);
            return ApiResponseDto.<Object>builder()
                                 .status(ApiResponseDto.ApiResponseStatus.FAIL)
                                 .message("피드 등록 실패")
                                 .build();
        }

        return ApiResponseDto.<Object>builder()
                             .status(ApiResponseDto.ApiResponseStatus.SUC)
                             .message("피드 등록 성공")
                             .build();
    }

}
