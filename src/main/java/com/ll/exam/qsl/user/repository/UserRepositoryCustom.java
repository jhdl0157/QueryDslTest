package com.ll.exam.qsl.user.repository;

import com.ll.exam.qsl.user.entity.SiteUser;

import java.util.List;

public interface UserRepositoryCustom {
    SiteUser getQslUser(Long id);

    Long getQslCount();

    SiteUser getQslUserOrderByIdAscOne();

    List<SiteUser> searchQsl(String user1);
}

