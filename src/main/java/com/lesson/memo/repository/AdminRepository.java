package com.lesson.memo.repository;//パッケージ宣言

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;//	Spring Bootが用意している、DB操作の基本機能一式

import com.lesson.memo.model.Admin;//modelパッケージのAdminをimport

public interface AdminRepository extends JpaRepository <Admin, Long>{
	
	//メールアドレスを検索
	Optional<Admin> findByEmail(String email);

}
