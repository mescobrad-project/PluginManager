package ro.simavi.mescobrad.auditapp.controllers;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.simavi.mescobrad.auditapp.entities.Questionnaire;
import ro.simavi.mescobrad.auditapp.entities.Translation;
import ro.simavi.mescobrad.auditapp.repositories.TranslationRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Getter
@Setter
@Component
public class TranslationController {
    @Autowired
    private TranslationRepository translationRepository;

    private Translation translationSelected;

    private List<Translation> translationsList;

    @PostConstruct
    public void init(){
        translationsList = this.translationRepository.findAll();
    }

    public void saveTranslation() {
        if (this.translationSelected.getTranslationId() == null) {
            this.translationSelected.setTranslationId( (long)Math.floor(Math.random()*(100-1+1)+1) );
            this.translationsList.add(this.translationSelected);
        }

        PrimeFaces.current().executeScript("PF('manageTranslations').hide()");
        PrimeFaces.current().ajax().update("translationsForm:translationsData");
    }

    public void deleteTranslation() {
        this.translationsList.remove( this.translationSelected );
        this.translationSelected = null;

        PrimeFaces.current().ajax().update( "translationsForm:translationsData");
    }

    public void openNewTranslation() {
        this.translationSelected = new Translation();
    }

}
