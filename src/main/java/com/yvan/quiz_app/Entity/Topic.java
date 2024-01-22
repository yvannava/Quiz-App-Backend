package com.yvan.quiz_app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;
import java.util.List;


@ToString
@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "topic")
    private String topic;

    @OneToMany(mappedBy = "topic",cascade = CascadeType.ALL)
    private List<Question> questions;

    public Topic(String topic, List<Question> questions){
        this.topic = topic;
        this.questions = questions;
    }
    public Topic(String Topic){
        this.topic = topic.toString();
    }
    public Topic(){};

    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

//    public void setTopic(String topic) {
//        this.topic = topic;
//    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}