package com.yvan.quiz_app.Service;

import com.yvan.quiz_app.Entity.Topic;

import java.util.List;

public interface TopicService {
    Topic save(Topic topic);
    Topic getTopic(Long id);
    List<Topic> getAllTopics();

    void deleteTopic(Long id);
    void updateTopic(Long id,Topic topic);
}
