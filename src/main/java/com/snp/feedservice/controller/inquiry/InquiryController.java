package com.snp.feedservice.controller.inquiry;

import com.snp.feedservice.dto.api.response.ApiResponseDto;
import com.snp.feedservice.dto.inquiry.InquiryResponseDto;
import com.snp.feedservice.global.GlobalUrl;
import com.snp.feedservice.service.inquiry.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @PostMapping(GlobalUrl.INQUIRY)
    @ResponseBody
    public ApiResponseDto<List<InquiryResponseDto>> feeds() { return inquiryService.feeds(); }

}
