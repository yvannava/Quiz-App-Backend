package com.yvan.quiz_app.Service;

import com.yvan.quiz_app.Entity.Question;
import com.yvan.quiz_app.Entity.Topic;

import java.util.List;

public interface QuestionService {
    Question saveQuestion(Question question,Long topicId);
    List<Question> getAll();

    Question getQuestion(Long id);

    void deleteQuestion(Long id);

    void updateQuestion(Long id,Topic topic);
}
