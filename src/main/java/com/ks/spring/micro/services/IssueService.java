package com.ks.spring.micro.services;

import com.ks.spring.micro.Dto.base.IssueDto;
import com.ks.spring.micro.domain.Issue;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IssueService {
    String create(IssueDto issueDto);

    @Transactional
    IssueDto createIssue(IssueDto issueDto);

    List<String> getAll();

    List<Issue> allIssues();

    String get(String id);

    Issue getIssue(String id);

    Boolean deleteById(String id);
}
