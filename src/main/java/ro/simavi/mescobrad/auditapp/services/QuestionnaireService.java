package ro.simavi.mescobrad.auditapp.services;

import ro.simavi.mescobrad.auditapp.entities.Questionnaire;

public interface QuestionnaireService {
    Questionnaire saveQuestionnaireToDB( Questionnaire questionnaireSelected);
}
