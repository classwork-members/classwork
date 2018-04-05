package com.soft.classwork.service;

import com.soft.classwork.model.Exam;
import com.soft.classwork.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Yuukiiii
 * on 2018/3/22 08:42
 */

@Transactional
@Service
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
                           String alternativeD,
                           String correctAnswer,
                           Integer illnessid) {
        Exam exam = new Exam();
        exam.setAlternativea(alternativeA);
        exam.setAlternativeb(alternativeB);
        exam.setAlternativec(alternativeC);
        exam.setAlternatived(alternativeD);
        exam.setQuestion(question);
        exam.setCorrectAnswer(correctAnswer);
        exam.setExamid(examid);
        exam.setIllnessid(illnessid);
        return examRepository.save(exam);
    }

//    public Exam updateExam(Exam exam){
//
//    }

    public List<Exam> findExamByIllnessid(Integer illnessid){return examRepository.findAllByIllnessid(illnessid);}
}

