package ro.simavi.mescobrad.auditapp.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.simavi.mescobrad.auditapp.entities.Variable;
import ro.simavi.mescobrad.auditapp.repositories.VariableRepository;
import ro.simavi.mescobrad.auditapp.services.VariableService;

import java.util.Objects;
import java.util.Optional;

@Service
public class VariableServiceImpl implements VariableService {

    @Autowired
    private VariableRepository variableRepository;

    @Override
    public Variable saveVariableToDB( Variable variableSelected) {

        if( Objects.nonNull( variableSelected.getVariableId() ) ){
            Optional<Variable> variableOptional = this.variableRepository.findById( variableSelected.getVariableId());
            if (variableOptional.isPresent()) {
                variableOptional.get().setVariableName( variableSelected.getVariableName() );
                variableOptional.get().setCategoryRef( variableSelected.getCategoryRef() );
                variableOptional.get().setConceptRef( variableSelected.getConceptRef());
                variableOptional.get().setFormula( variableSelected.getFormula());
                variableOptional.get().setDirectlyMeasured( variableSelected.getDirectlyMeasured());
                variableOptional.get().setLevelOfMeasurement( variableSelected.getLevelOfMeasurement());
                variableOptional.get().setMeasurementUnit( variableSelected.getMeasurementUnit());
                variableOptional.get().setSqlDataType( variableSelected.getSqlDataType());
                variableOptional.get().setNoOfPossibleAnswers( variableSelected.getNoOfPossibleAnswers());
                variableOptional.get().setDescription( variableSelected.getDescription());
                this.variableRepository.save(variableOptional.get());
                return variableOptional.get();
            }
        }

        Variable variable = new Variable();
        variable.setVariableName( variableSelected.getVariableName() );
        variable.setCategoryRef( variableSelected.getCategoryRef() );
        variable.setConceptRef( variableSelected.getConceptRef());
        variable.setFormula( variableSelected.getFormula());
        variable.setDirectlyMeasured( variableSelected.getDirectlyMeasured());
        variable.setLevelOfMeasurement( variableSelected.getLevelOfMeasurement());
        variable.setMeasurementUnit( variableSelected.getMeasurementUnit());
        variable.setSqlDataType( variableSelected.getSqlDataType());
        variable.setNoOfPossibleAnswers( variableSelected.getNoOfPossibleAnswers());
        variable.setDescription( variableSelected.getDescription());
        this.variableRepository.save( variable );
        return variable;
    }
}
