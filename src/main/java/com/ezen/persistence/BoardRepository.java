package com.ezen.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezen.domain.Board;
import java.lang.String;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
	// 제목을 조건으로 게시글 목록 조회
	List<Board> findByTitle(String keyword);
	
	List<Board> findByContentContaining(String keyword);
	
	List<Board> findByTitleContainingOrContentContaining(String title,String content);
}
