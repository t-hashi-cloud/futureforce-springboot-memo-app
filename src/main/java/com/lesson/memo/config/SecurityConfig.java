package com.lesson.memo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
    // パスワードをハッシュ化するためのエンコーダーをBean登録
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
//        	.csrf(csrf -> csrf.disable())   // 
            // URLごとのアクセス制御指示
            .authorizeHttpRequests(auth -> auth
                // 静的リソース（CSS, JS, 画像）は認証なしで許可
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                // このURLはログインなしで誰でも見れる！
                .requestMatchers("/admin/signup", "/admin/signin").permitAll()
                //それ以外のURLはログインが必要！
                .anyRequest().authenticated()
            )
            // ログイン設定での遷移先の指示
            .formLogin(form -> form
	            .loginPage("/admin/signin")           // ログイン画面のURL
	            .loginProcessingUrl("/admin/signin") // ログイン処理を受け付けるURL
                .defaultSuccessUrl("/memo", true)    // ログイン成功後の遷移先
                .permitAll()
            );

        return http.build();
    }
}


