package org.example.tubesecurity.service;

import lombok.RequiredArgsConstructor;
import org.example.tubesecurity.dto.CustomUserDetails;
import org.example.tubesecurity.entity.User;
import org.example.tubesecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    // 데이터베이스에서 가져온 유저네임을 검증하는거
    // 그래서 디비랑 연결하는 작업이 메소드에 있어야함
    private final UserRepository userRepository;

    //필수 구현 메소드
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user != null) {
            return new CustomUserDetails(user);
        }

        return null;
    }
}
