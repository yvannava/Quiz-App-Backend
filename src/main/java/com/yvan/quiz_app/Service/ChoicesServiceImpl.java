package com.yvan.quiz_app.Service;

import com.yvan.quiz_app.Entity.Choices;
import com.yvan.quiz_app.Repository.ChoicesRepository;
import org.springframework.stereotype.Service;

@Service
public class ChoicesServiceImpl implements ChoicesService{
    private ChoicesRepository choicesRepository;

    public ChoicesServiceImpl(ChoicesRepository choicesRepository){
        this.choicesRepository = choicesRepository;
    }


    @Override
    public Choices saveChoice(Choices choices) {
        return choicesRepository.save(choices);
    }

    @Override
    public Choices getChoice(Long id) {
        return null;
    }
}
