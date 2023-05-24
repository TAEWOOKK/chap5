package com.ezen.persistence;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.domain.Board;

@SpringBootTest
public class QueryMethodTest {
	
	@Autowired
	private BoardRepository boardRepository;
	
	//@BeforeEach		//각 테스트 케이스 실행 전에 반드시 수행
	public void dataPrepare() {
		
		for (int i = 1; i <= 200; i++) {
			
			Board board = new Board();
			
			board.setTitle("게시글 제목"+i);
			board.setWriter("작성자");
			board.setContent("게시글 내용입니다..."+i);
			board.setCreateDate(new Date());
			board.setCnt(0);
			
			boardRepository.save(board);
		}
	}
	
	@Test
	@Disabled
	public void testFindByTitle() {
		List<Board> boardList = boardRepository.findByTitle("게시글 제목159");
		
		System.out.println(">>>조회 결과");
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
	
	@Test
	@Disabled
	public void testFindByContentContaining() {
		List<Board> boardList = boardRepository.findByContentContaining("게시글 내용입니다...1");
		
		System.out.println(">>>조회 결과");
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
	
	@Test
	public void findByTitleContainingOrContentContaining() {
		List<Board> boardList = boardRepository.findByTitleContainingOrContentContaining("2","3");
		
		System.out.println(">>>조회 결과");
		for(Board board : boardList) {
			System.out.println(board.toString());
		}
	}
}
