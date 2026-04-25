package com.ks.spring.micro.Dao;

import com.ks.spring.micro.domain.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueDao extends JpaRepository<Issue, String> {
}
