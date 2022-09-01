package com.ll.exam.qsl.base;

import com.ll.exam.qsl.interestKeyword.entity.InterestKeyword;
import com.ll.exam.qsl.interestKeyword.repository.InterestRepository;
import com.ll.exam.qsl.user.entity.SiteUser;
import com.ll.exam.qsl.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test") // 이 클래스 정의된 Bean 들은 test 모드에서만 활성화 된다.
public class TestInitData {
    // CommandLineRunner : 주로 앱 실행 직후 초기데이터 세팅 및 초기화에 사용
    @Bean
    CommandLineRunner init(UserRepository userRepository, InterestRepository interestRepository) {
        return args -> {
            SiteUser u1 = SiteUser.builder()
                    .username("user1")
                    .password("{noop}1234")
                    .email("user1@test.com")
                    .build();


            SiteUser u2 = SiteUser.builder()
                    .username("user2")
                    .password("{noop}1234")
                    .email("user2@test.com")
                    .build();
            userRepository.saveAll(Arrays.asList(u1, u2));

            InterestKeyword interestKeyword=new InterestKeyword("축구",u1);
            InterestKeyword interestKeyword2=new InterestKeyword("농구",u1);

            InterestKeyword interestKeyword3=new InterestKeyword("농구",u2);
            InterestKeyword interestKeyword4=new InterestKeyword("클라이밍",u2);
            InterestKeyword interestKeyword5=new InterestKeyword("마라톤",u2);


            interestRepository.saveAll(Arrays.asList(interestKeyword, interestKeyword2,interestKeyword3
                    ,interestKeyword4,interestKeyword5));
        };
    }
}
