package org.example.tubesecurity.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.example.tubesecurity.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

    private User user;

    public CustomUserDetails(User user) {

        this.user = user;
    }

    // 사용자의 특정한 권한을 리턴해주는 메소드, Role 값 확인
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        //new GrantedAuthority()를 추가하면 구현해야할 메소드가 생김
        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {
                System.out.println(user.getRole());
                return user.getRole(); //role 값 리턴
            }
        });

        return collection;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
}
