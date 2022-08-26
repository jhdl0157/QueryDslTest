package com.ll.exam.app3.service;

import com.ll.exam.app3.entity.SiteUser;
import com.ll.exam.app3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public SiteUser save(String username, String email) {
        SiteUser user=new SiteUser(username,email);
        return userRepository.save(user);
    }

    public SiteUser findId(Long id) {
        SiteUser user=userRepository.customFindById(id);
        return user;
    }
}
