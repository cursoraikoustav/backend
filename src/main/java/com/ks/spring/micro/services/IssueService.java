package com.ks.spring.micro.services;

import com.ks.spring.micro.Dto.base.IssueDto;
import com.ks.spring.micro.domain.Issue;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IssueService {
    IssueDto createIssue(IssueDto issueDto);
    List<IssueDto> getAll();
    IssueDto getIssue(String id);
    Boolean deleteById(String id);
}
