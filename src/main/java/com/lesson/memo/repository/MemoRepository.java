package com.lesson.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.lesson.memo.model.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    
	// DBへタイトルにキーワードを含むメモを検索メソッド（部分一致）
    List<Memo> findByTitleContaining(String keyword);
   
}