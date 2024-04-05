package com.snp.feedservice.service.inquiry;

import com.snp.feedservice.dto.api.response.ApiResponseDto;
import com.snp.feedservice.jpa.entity.Feed;

import java.util.List;

public interface InquiryService {

    ApiResponseDto<List<Feed>> feeds();

}
