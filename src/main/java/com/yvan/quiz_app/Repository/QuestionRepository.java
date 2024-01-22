package com.yvan.quiz_app.Repository;

import com.yvan.quiz_app.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
