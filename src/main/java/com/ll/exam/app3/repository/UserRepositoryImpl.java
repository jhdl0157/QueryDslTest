package com.ll.exam.app3.repository;

import com.ll.exam.app3.entity.QSiteUser;
import com.ll.exam.app3.entity.SiteUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    QSiteUser quser=QSiteUser.siteUser;

    @Override
    public SiteUser customFindById(Long id) {
        SiteUser user=queryFactory.selectFrom(quser)
                .where(quser.id.eq(id))
                .fetchOne();
        return user;
    }

    @Override
    public List<SiteUser> customFindAll() {
        List<SiteUser> siteUsers= queryFactory.selectFrom(quser)
                .fetch();
        return siteUsers;
    }
}
