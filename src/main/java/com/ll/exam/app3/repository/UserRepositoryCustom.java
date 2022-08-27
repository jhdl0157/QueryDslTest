package com.ll.exam.app3.repository;

import com.ll.exam.app3.entity.SiteUser;

import java.util.List;

public interface UserRepositoryCustom {

    SiteUser customFindById(Long id);

    List<SiteUser> customFindAll();

    SiteUser customfildByname(String name);
}
