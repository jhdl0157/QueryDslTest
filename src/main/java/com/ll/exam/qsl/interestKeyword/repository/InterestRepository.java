package com.ll.exam.qsl.interestKeyword.repository;

import com.ll.exam.qsl.interestKeyword.entity.InterestKeyword;
import com.ll.exam.qsl.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterestRepository  extends JpaRepository<InterestKeyword,String>, InterestRepositoryCustom {
}
