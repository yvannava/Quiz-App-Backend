package com.yvan.quiz_app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "answer")
    private String answer;

    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Choices> choices;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Question(String text,String answer,List<Choices> choices, Topic topic) {
        this.text = text;
        this.answer = answer;
        this.choices = choices;
        this.topic = topic;

    }

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Choices> getChoices() {
        return choices;
    }

    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
       this.topic = topic;
    }
}
