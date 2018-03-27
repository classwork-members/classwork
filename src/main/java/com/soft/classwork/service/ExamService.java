package com.soft.classwork.service;

import com.soft.classwork.model.Exam;
import com.soft.classwork.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Yuukiiii
 * on 2018/3/22 08:42
 */


public class ExamService {

    @Autowired
    ExamRepository examRepository;

    public Exam addExam(Exam exam) {
        return examRepository.save(exam);
    }

    public void deleteExam(Integer id) {
        examRepository.deleteById(id);
    }

    public Exam findOneExam(Integer id) {
        return examRepository.getOne(id);
    }

    public List<Exam> findAllExam() {
        return examRepository.findAll();
    }

    public Exam updateExam(Integer examid,
                           String question,
                           String alternativeA,
                           String alternativeB,
                           String alternativeC,
                           Character correctAnswer) {
        Exam exam = new Exam();
        exam.setAlternativeA(alternativeA);
        exam.setAlternativeB(alternativeB);
        exam.setAlternativeC(alternativeC);
        exam.setQuestion(question);
        exam.setCorrectAnswer(correctAnswer);
        exam.setExamid(examid);
        return examRepository.save(exam);
    }
}

