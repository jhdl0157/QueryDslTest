package com.ll.exam.qsl.interestKeyword.repository;

import com.ll.exam.qsl.interestKeyword.entity.InterestKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterestRepository extends JpaRepository<InterestKeyword,String> {
}
