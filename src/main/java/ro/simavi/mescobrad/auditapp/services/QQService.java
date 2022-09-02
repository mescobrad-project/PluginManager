package ro.simavi.mescobrad.auditapp.services;

import ro.simavi.mescobrad.auditapp.entities.QuestionnaireQuestions;

public interface QQService {
    QuestionnaireQuestions saveQQToDB( QuestionnaireQuestions selectedQQ );
}
