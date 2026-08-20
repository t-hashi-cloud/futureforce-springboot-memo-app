package com.lesson.memo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lesson.memo.model.Memo;
public interface MemoRepository extends JpaRepository<Memo, Long> {
	
	// DBへタイトルにキーワードを含むメモを検索メソッド（部分一致）
    List<Memo> findByTitleContainingOrContentContaining(String title, String content);
   
}