package ro.simavi.mescobrad.auditapp.services;

import ro.simavi.mescobrad.auditapp.entities.Variable;

public interface VariableService {
    Variable saveVariableToDB( Variable variableSelected);
}
