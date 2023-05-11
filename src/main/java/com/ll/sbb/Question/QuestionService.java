package com.ll.sbb.Question;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;

import lombok.RequiredArgsConstructor;
import java.util.Optional;
import com.ll.sbb.Question.DataNotFoundException;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject , String content){
        Question q = new Question();
        //질문(퀘스쳔) 타입의 객체 선언
        q.setSubject(subject);
        // 선언한 객체의 서브젝트에 매개변수로 받아온 서브젝트 사용선언
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        // 생성일에 현재시간 적용
        this.questionRepository.save(q);
        //위에 프라이빗으로 선언한 질문리포지터리에 저장.


    }

    public Page<Question> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable= PageRequest.of(page,10, Sort.by(sorts));
        //조회할페이지번호 , 한페이지에 10개 보여줌
        return this.questionRepository.findAll(pageable);
    }
}