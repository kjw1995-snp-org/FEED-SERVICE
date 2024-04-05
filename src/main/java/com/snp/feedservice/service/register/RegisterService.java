package com.snp.feedservice.service.register;

import com.snp.feedservice.dto.api.response.ApiResponseDto;
import com.snp.feedservice.dto.register.RegisterRequestDto;

public interface RegisterService {

    ApiResponseDto<Object> register(RegisterRequestDto requestDto);

}
