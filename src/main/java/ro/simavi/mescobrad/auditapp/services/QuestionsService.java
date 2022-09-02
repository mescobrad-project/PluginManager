package ro.simavi.mescobrad.auditapp.services;

import ro.simavi.mescobrad.auditapp.entities.Questions;

public interface QuestionsService {
    Questions saveQuestionToDB( Questions questionSelected );
}
