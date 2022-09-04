package com.ll.exam.qsl.interestKeyword.repository;

import com.ll.exam.qsl.interestKeyword.entity.InterestKeyword;
import com.ll.exam.qsl.user.entity.SiteUser;

import java.util.List;

public interface InterestRepositoryCustom {
    List<InterestKeyword> getFollowInterest(SiteUser u1);
}
