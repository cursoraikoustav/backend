package com.ks.spring.micro.services.Impl;

import com.ks.spring.micro.Dao.IssueDao;
import com.ks.spring.micro.Dto.base.IssueDto;
import com.ks.spring.micro.Utill.Converter;
import com.ks.spring.micro.domain.Issue;
import com.ks.spring.micro.services.IssueService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueDao issueDao;
    private final Converter converter;

    public IssueServiceImpl(IssueDao issueDao, Converter converter) {
        this.issueDao = issueDao;
        this.converter = converter;
    }

    @Transactional
    @Override
    public IssueDto createIssue(IssueDto issueDto) {
        // 1. Convert DTO to Entity
        Issue issue = converter.convert(issueDto, Issue.class);

        // 2. Save and flush to get the generated ID and database defaults
        Issue savedIssue = issueDao.save(issue);

        // 3. Map the saved entity back to DTO
        // This ensures fields like 'id', 'createdAt', or 'status' (set by DB) are included
        return converter.convert(savedIssue, IssueDto.class);
    }

    @Override
    public List<IssueDto> getAll() {
        return issueDao.findAll().stream().map(it->converter.convert(it, IssueDto.class))
                .toList();
    }

    @Override
    public IssueDto getIssue(String id) {
        return converter.convert(issueDao.findById(id).orElse(null),IssueDto.class);
    }

    @Override
    public Boolean deleteById(String id) {
        if(getIssue(id) != null) {
            issueDao.deleteById(id);
            return  true;
        }
        return false;
    }
}
