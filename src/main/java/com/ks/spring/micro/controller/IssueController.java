package com.ks.spring.micro.controller;

import com.ks.spring.micro.Dto.base.IssueDto;
import com.ks.spring.micro.Dto.request.CreateIssueRequestDto;
import com.ks.spring.micro.Utill.Converter;
import com.ks.spring.micro.services.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/issue")
public class IssueController {

    private final IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }


    @GetMapping("/list")
    public List<IssueDto> listIssues() {
        return issueService.getAll();
    }

    @PostMapping("/create")
    public IssueDto createIssue(@RequestBody CreateIssueRequestDto createIssueRequestDto) {
        return issueService.createIssue(createIssueRequestDto.issueDto);
    }

    @GetMapping("/get/{id}")
    public IssueDto getIssue(@PathVariable String id) {
        return issueService.getIssue(id);
    }

    @PostMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id) {
        return issueService.deleteById(id);
    }

}
