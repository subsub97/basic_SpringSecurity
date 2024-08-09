package org.example.tubesecurity.service;

import lombok.RequiredArgsConstructor;
import org.example.tubesecurity.dto.JoinDTO;
import org.example.tubesecurity.entity.User;
import org.example.tubesecurity.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    //void가 아닌 처리 확인 로직으로 처리
    public void joinProcess(JoinDTO joinDTO) {

        //Todo : DB 아이디 중복검사 로직 만들기
        User joinedUser = joinDTO.toEntity();
        joinedUser.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        userRepository.save(joinedUser);
    }
}
