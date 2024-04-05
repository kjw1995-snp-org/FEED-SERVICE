package com.snp.feedservice.controller.register;

import com.snp.feedservice.dto.api.response.ApiResponseDto;
import com.snp.feedservice.dto.register.RegisterRequestDto;
import com.snp.feedservice.global.GlobalUrl;
import com.snp.feedservice.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(GlobalUrl.REGISTER)
    @ResponseBody
    public ApiResponseDto<Object> register(@RequestBody RegisterRequestDto requestDto) { return registerService.register(requestDto); }

}
