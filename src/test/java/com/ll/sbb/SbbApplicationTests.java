package com.ll.sbb;


import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.ll.sbb.Answer.Answer;
import com.ll.sbb.Answer.AnswerRepository;
import com.ll.sbb.Question.Question;
import com.ll.sbb.Question.QuestionRepository;
import com.ll.sbb.Question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SbbApplicationTests {
@Autowired
	private QuestionService questionService;
@Test
	void testJpa(){
	for (int i =1; i<=300; i++){
		String subject = String.format("테스트 데이터입니다 : [%03d]",i);
		String content = "내용무";
		this.questionService.create(subject,content);
	}
}


}