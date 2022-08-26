package com.ll.exam.app3;

import com.ll.exam.app3.entity.QSiteUser;
import com.ll.exam.app3.entity.SiteUser;
import com.ll.exam.app3.repository.UserRepository;
import com.ll.exam.app3.service.UserService;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QueryDslTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    QSiteUser quser=QSiteUser.siteUser;
    @Test
    void QueryDsl을_사용하여_사용자조회(){
        SiteUser user=jpaQueryFactory.selectFrom(quser)
                .where(quser.id.eq(1L))
                .fetchOne();
        assertThat(user.getId()).isEqualTo(1L);
        assertThat(user.getUsername()).isEqualTo("jaeho");
        assertThat(user.getEmail()).isEqualTo("jhdl0157");
    }


    @Test
    void 사용자_전체_조회(){
        List<SiteUser> userList=userRepository.customFindAll();
        assertThat(2).isEqualTo(userList.size());
    }


}
