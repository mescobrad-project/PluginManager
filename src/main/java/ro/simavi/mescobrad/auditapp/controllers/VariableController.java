package ro.simavi.mescobrad.auditapp.controllers;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Collection;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.simavi.mescobrad.auditapp.entities.QuestionsVariables;
import ro.simavi.mescobrad.auditapp.entities.Variable;
import ro.simavi.mescobrad.auditapp.repositories.QuestionsVariablesRepository;
import ro.simavi.mescobrad.auditapp.repositories.VariableRepository;
import ro.simavi.mescobrad.auditapp.services.VariableService;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@Component
public class VariableController {
    @Autowired
    private VariableRepository variableRepository;

    @Autowired
    private VariableService variableService;

    @Autowired
    private QuestionsVariablesRepository repositoryQV;

    private List<Variable> variableList;
    private List<QuestionsVariables> listQV;

    private Variable variableSelected;
    private QuestionsVariables selectedQV;

    @PostConstruct
    public void init(){
        variableList = variableRepository.findAll();
        listQV = repositoryQV.findAll();
    }

    public void saveVariable() {
        variableService.saveVariableToDB( this.variableSelected );
        variableList = variableRepository.findAll();
        variableList.sort( Comparator.comparing( Variable::getVariableId ) );
        PrimeFaces.current().executeScript("PF('manageVariables').hide()");
        PrimeFaces.current().ajax().update("variablesForm:variablesData");
    }

    public void deleteVariable() {
        this.variableRepository.deleteById( this.variableSelected.getVariableId() );
        this.variableList.remove( this.variableSelected );
        this.variableSelected = null;

        PrimeFaces.current().ajax().update( "variablesForm:variablesData");
    }

    public void openNewVariable() {
        this.variableSelected = new Variable();
    }

    public void saveQV() {
        if (this.selectedQV.getIdQV() == null) {
            this.selectedQV.setIdQV( (long)Math.floor(Math.random()*(100-1+1)+1) );
            this.listQV.add(this.selectedQV);
        }

        PrimeFaces.current().executeScript("PF('manageQV').hide()");
        PrimeFaces.current().ajax().update("formQV:dataQV");
    }

    public void deleteQV() {
        this.listQV.remove( this.selectedQV );
        this.selectedQV = null;

        PrimeFaces.current().ajax().update( "formQV:dataQV");
    }

    public void openNewQV() {
        this.selectedQV = new QuestionsVariables();
    }

}
