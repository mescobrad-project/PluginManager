package ro.simavi.mescobrad.auditapp.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.simavi.mescobrad.auditapp.entities.AuditData;
import ro.simavi.mescobrad.auditapp.entities.PluginData;
import ro.simavi.mescobrad.auditapp.repositories.PluginDataRepository;
import ro.simavi.mescobrad.auditapp.services.AuditDataService;
import ro.simavi.mescobrad.auditapp.services.PluginDataService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class used to retrieve data related to audit
 * Implementation of a public interface
 */
@Service
public class PluginDataServiceImpl implements PluginDataService
{
    @Autowired
    private PluginDataRepository pluginDataRepository;

    /**
     * Dumy method for data audit
     * @return List of two dummy entries
     */
    @Override
    public List<PluginData> pluginData(){
        List<PluginData> dummyList = new ArrayList<>();
        PluginData d1 = new PluginData();

        d1.setOwner( "iacobc" );
        d1.setRegisteredDate( new Date() );
        d1.setDescription( "First plugin used to anonymize data" );
        d1.setType( "privacy" );
        d1.setVersion( "1.0.2" );

        dummyList.add( d1 );
        PluginData d2 = new PluginData();

        d2.setOwner( "andrei" );
        d2.setRegisteredDate( new Date() );
        d2.setDescription( "Second plugin used to anonymize data" );
        d2.setType( "data preparation" );
        d2.setVersion( "1.0.7" );
        dummyList.add( d2 );

        PluginData d3 = new PluginData();

        d3.setOwner( "iacobc" );
        d3.setRegisteredDate( new Date() );
        d3.setDescription( "First plugin used to anonymize data" );
        d3.setType( "anonimization" );
        d3.setVersion( "1.1.2" );

        dummyList.add( d3 );
        PluginData d4 = new PluginData();

        d4.setOwner( "andrei" );
        d4.setRegisteredDate( new Date() );
        d4.setDescription( "Second plugin used to anonymize data" );
        d4.setType( "utility" );
        d4.setVersion( "1.1.7" );
        dummyList.add( d4 );

        return dummyList;
    }

    @Override
    public List<PluginData> findAll(){
        return pluginDataRepository.findAll();
    }

@Override
    public List<PluginData> findAllByName(String name){
        return pluginDataRepository.findAllByName( name );
    }

    @Override
    public List<PluginData> findAllByNameAndVersion(String name, String version){
        return pluginDataRepository.findAllByNameAndVersion( name, version );
    }

    @Override
    public List<PluginData> findAllByVersion(String version){
        return pluginDataRepository.findAllByVersion( version );
    }

    @Override
    public PluginData findFirstById(String id){
        return pluginDataRepository.findFirstById( id );
    }

}
