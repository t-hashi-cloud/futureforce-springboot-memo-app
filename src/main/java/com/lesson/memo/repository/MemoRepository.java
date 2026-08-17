package com.lesson.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lesson.memo.model.Memo;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    
}