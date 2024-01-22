package com.yvan.quiz_app.Service;


import com.yvan.quiz_app.Entity.Choices;
import com.yvan.quiz_app.Entity.Question;
import com.yvan.quiz_app.Entity.Topic;
import com.yvan.quiz_app.Repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicServiceImpl implements TopicService {

    private TopicRepository topicRepository;
    private QuestionServiceImpl questionServiceImpl;
    private ChoicesServiceImpl choicesServiceImpl;

    public TopicServiceImpl(TopicRepository topicRepository,QuestionServiceImpl questionServiceImpl,ChoicesServiceImpl choicesServiceImpl){
        this.topicRepository = topicRepository;
        this.questionServiceImpl = questionServiceImpl;
        this.choicesServiceImpl = choicesServiceImpl;
    }


    @Override
    public Topic save(Topic topic) {
        Topic savedTopic = topicRepository.save(topic);
        return topicRepository.save(savedTopic);
    }

    @Override
    public Topic getTopic(Long id) {
        return topicRepository.findById(id).get();
    }

    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Override
    public void deleteTopic(Long id){
       Optional <Topic> topicFromDB = topicRepository.findById(id);
        if(topicFromDB.isPresent()){
            topicRepository.deleteById(id);
        }else{
        throw new ClassCastException("Could not find Entity with ID: " + id + ", Check ID and try again.");
        }
    }

    @Override
    public void updateTopic(Long id, Topic topic) {
        // Finds the existing topic
        Topic findTopicFromDB = topicRepository.findById(id).get();

        //Grabs the incoming question from client
        List<Question> newQuestions= topic.getQuestions();
        System.out.println("new Questions: " + Arrays.asList(newQuestions));

        if(newQuestions != null){

        }
    }
}
