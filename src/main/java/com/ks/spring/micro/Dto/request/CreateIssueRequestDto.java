package com.ks.spring.micro.Dto.request;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.ks.spring.micro.Dto.base.IssueDto;

public class CreateIssueRequestDto {
    @JsonUnwrapped
    public IssueDto issueDto;

}
