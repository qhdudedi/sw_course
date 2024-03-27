package sku.lesson.blog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails { // UserDetails 상속받아 인증 객체로 사용

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password")
    private String password;

    @Builder 
    public User(String email, String password, String auth){
        this.email = email;
        this.password = password;
    }

    @Override // 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername(){
        return password;
    }
    @Override
    public String getPassword(){
        return password;
    }
    @Override
    public boolean isAccountNonExpired(){
        return true; // 계정 만료 여부 확인 true = 만료되지 않음
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true; // pwd 만료 여부 확인 true = 만료되지 않음
    }
    @Override
    public boolean isEnabled(){
        return true;
    }


}
