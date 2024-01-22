package com.yvan.quiz_app.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "choices")
public class Choices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "choice_text")
    private String choiceText;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Question question;

    public Choices(String choiceText){
        this.choiceText = choiceText;
    }

    public Choices(){}

    public Long getId() {
        return id;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
