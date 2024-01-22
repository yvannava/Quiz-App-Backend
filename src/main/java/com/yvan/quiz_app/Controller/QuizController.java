package com.yvan.quiz_app.Controller;

import com.yvan.quiz_app.Entity.Question;
import com.yvan.quiz_app.Entity.Topic;
import com.yvan.quiz_app.Repository.QuestionRepository;
import com.yvan.quiz_app.Service.QuestionServiceImpl;
import com.yvan.quiz_app.Service.TopicServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/App/v1/Quiz")
public class QuizController {

    private TopicServiceImpl topicServiceImpl;
    private QuestionServiceImpl questionServiceImpl;

    public QuizController(TopicServiceImpl topicServiceImpl,QuestionServiceImpl questionServiceImpl){
        this.topicServiceImpl = topicServiceImpl;
        this.questionServiceImpl = questionServiceImpl;
    }


    @PostMapping("/Topic")
    public ResponseEntity<Topic> saveTopic(@RequestBody Topic topic){
        if(topic.getTopic().isBlank()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            System.out.println("posted: " + topic);
            Topic topicDB = topicServiceImpl.save(topic);
            return new ResponseEntity<>(topicDB, HttpStatus.CREATED);
        }
    }

    @GetMapping("/Topic/{id}")
    public ResponseEntity<Topic> getTopic(@PathVariable Long id){
        Topic topic = topicServiceImpl.getTopic(id);
        return new ResponseEntity<Topic>(topic,HttpStatus.OK);
    }

    @GetMapping("/Topics")
    public ResponseEntity<List<Topic>> getAllTopics(){
        try {
            List<Topic> topicsFromDB = topicServiceImpl.getAllTopics();
            return new ResponseEntity<>(topicsFromDB,HttpStatus.OK);
        }catch(Exception e){
            System.out.println("Your request gave the following cause for the error:" + e.getCause());
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/Topic/{id}")
    public ResponseEntity<HttpStatus> deleteTopic(@PathVariable Long id){
        topicServiceImpl.deleteTopic(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/Topic/Question")
    public ResponseEntity<Question> saveQuestion(@RequestBody Question question){

        Question saveQuestionToDB = questionServiceImpl.saveQuestion(question);
        return new ResponseEntity<Question>(saveQuestionToDB,HttpStatus.CREATED);
    }

    @GetMapping("/Topic/Questions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questionFromDB = questionServiceImpl.getAll();
        return new ResponseEntity<>(questionFromDB,HttpStatus.ACCEPTED);
    }

}
