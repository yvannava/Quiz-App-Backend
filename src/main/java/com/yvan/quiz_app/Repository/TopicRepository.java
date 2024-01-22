package com.yvan.quiz_app.Repository;

import com.yvan.quiz_app.Entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {
}
