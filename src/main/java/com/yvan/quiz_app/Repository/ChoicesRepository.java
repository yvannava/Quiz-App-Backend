package com.yvan.quiz_app.Repository;

import com.yvan.quiz_app.Entity.Choices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoicesRepository extends JpaRepository<Choices,Long>{
}
