package com.yvan.quiz_app.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.quiz_app.Entity.Choices;
import com.yvan.quiz_app.Entity.Question;
import com.yvan.quiz_app.Entity.Topic;
import com.yvan.quiz_app.Repository.ChoicesRepository;
import com.yvan.quiz_app.Repository.QuestionRepository;
import com.yvan.quiz_app.Repository.TopicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepository questionRepository;
    private TopicRepository topicRepository;
    private ChoicesRepository choicesRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository,TopicRepository topicRepository,ChoicesRepository choicesRepository){
        this.topicRepository = topicRepository;
        this.questionRepository = questionRepository;
        this.choicesRepository = choicesRepository;
    }

    @Transactional
    @Override
    public Question saveQuestion(Question question) {
        //Grabs the list
        List<Choices> incomingChoiceList = question.getChoices();

        //Updates the Question field in the Choices object
        incomingChoiceList
                .forEach((choice) -> choice.setQuestion(question));
        Topic topicFromDB = topicRepository.findById(question.getTopic().getId()).get();
        topicFromDB.getQuestions().add(question);
        topicRepository.save(topicFromDB);
//        System.out.println(topicFromFrontEnd);
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        List<Question> allQuestions = questionRepository.findAll();
        return allQuestions;
    }

    @Override
    public Question getQuestion(Long id) {
        Question getQuestion = questionRepository.findById(id).get();
        return getQuestion;
    }

    @Override
    public void deleteQuestion(Long id) {

    }


    @Override
    public void updateQuestion(Long id,Topic topic) {

    }

}
