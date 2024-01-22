package com.yvan.quiz_app.Service;

import com.yvan.quiz_app.Entity.Choices;

public interface ChoicesService {
    Choices saveChoice(Choices choices);

    Choices getChoice(Long id);
}
