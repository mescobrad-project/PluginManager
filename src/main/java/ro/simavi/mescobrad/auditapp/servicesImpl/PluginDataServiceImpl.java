package ro.simavi.mescobrad.auditapp.servicesImpl;

import org.springframework.stereotype.Service;
import ro.simavi.mescobrad.auditapp.entities.AuditData;
import ro.simavi.mescobrad.auditapp.entities.PluginData;
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
    /**
     * Dumy method for data audit
     * @return List of two dummy entries
     */
    @Override
    public List<PluginData> pluginData(){
        List<PluginData> dummyList = new ArrayList<>();
        PluginData d1 = new PluginData();
        d1.setId( 1l );
        d1.setOwner( "iacobc" );
        d1.setRegisteredDate( new Date() );
        d1.setPluginDescription( "First plugin used to anonymize data" );
        d1.setPluginPrerequisites( "Java 11 required" );
        d1.setVersion( "1.0.2" );

        dummyList.add( d1 );
        PluginData d2 = new PluginData();
        d2.setId( 2l );
        d2.setOwner( "andrei" );
        d2.setRegisteredDate( new Date() );
        d2.setPluginDescription( "Second plugin used to anonymize data" );
        d2.setPluginPrerequisites( "Spring 5 and Java 11 required" );
        d2.setVersion( "1.0.7" );
        dummyList.add( d2 );

        PluginData d3 = new PluginData();
        d3.setId( 3l );
        d3.setOwner( "iacobc" );
        d3.setRegisteredDate( new Date() );
        d3.setPluginDescription( "First plugin used to anonymize data" );
        d3.setPluginPrerequisites( "Java 11 required" );
        d3.setVersion( "1.1.2" );

        dummyList.add( d3 );
        PluginData d4 = new PluginData();
        d4.setId( 4l );
        d4.setOwner( "andrei" );
        d4.setRegisteredDate( new Date() );
        d4.setPluginDescription( "Second plugin used to anonymize data" );
        d4.setPluginPrerequisites( "Spring 5 and Java 11 required" );
        d4.setVersion( "1.1.7" );
        dummyList.add( d4 );

        return dummyList;
    }

}
