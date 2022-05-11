package ro.simavi.mescobrad.auditapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ro.simavi.mescobrad.auditapp.entities.PluginData;
import ro.simavi.mescobrad.auditapp.repositories.PluginDataRepository;
import ro.simavi.mescobrad.auditapp.services.PluginDataService;
import ro.simavi.mescobrad.auditapp.util.GitRepository;
import ro.simavi.mescobrad.auditapp.util.ReadGitFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PluginsController {
    @Autowired
    PluginDataService pluginDataService;

    @Autowired
    private PluginDataRepository pluginDataRepository;

    @Operation(summary = "Get all plugins if no request parameters. Elsewhere filter by parameter using like operator and nocase comparison")
    @GetMapping(value="/plugins",  produces = {"application/json", "application/xml", "text/xml"})
    public List<PluginData> registry(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "version", required = false) String version,
            @RequestParam(value = "type", required = false) String type) {
        List<PluginData> lpd = new ArrayList<>();
        if((name==null || name.length()<1) && (version==null || version.length()<1) && (type==null || type.length()<1)){
            List<PluginData> lpd1= pluginDataService.findAll();
            lpd.addAll( lpd1);
        }
        else if((name!=null && name.length()>0) && (version==null || version.length()<1) && (type==null || type.length()<1)){
            List<PluginData> lpd1= pluginDataService.findLikeName( name );
            lpd.addAll( lpd1);
        }
        else if((name==null || name.length()<1) && (version!=null && version.length()>0) && (type==null || type.length()<1)){
            List<PluginData> lpd1= pluginDataService.findAllByVersion( version );
            lpd.addAll( lpd1);
        }
        else if((name==null || name.length()<1) && (version==null || version.length()<1) && (type!=null & type.length()>0)){
            List<PluginData> lpd1= pluginDataService.findAllByVersion( type );
            lpd.addAll( lpd1);
        }
        else{
            lpd.addAll(  pluginDataService.findLikeNameVersionType( name, version, type ));
        }

        return lpd;
    }

    @Operation(summary = "Get a plugin  by its id")
    @GetMapping(value="/plugins/{id}", produces = {"application/json", "application/xml", "text/xml"})
    public PluginData listRegistered(@PathVariable String id) {
        return  pluginDataService.findFirstById(id);
     
    }

    @Operation(summary = "Get a git file. Testst only")
    @GetMapping(value="/test", produces = {"application/json", "application/xml", "text/xml"})
    public String  test() {
//        ReadGitFile rgf = new ReadGitFile();
//        rgf.getFileFromGit();
        GitRepository.getFile("ic");
        return "OK";

    }

    @Operation(summary = "Post a plugin by its content from body")
    @RequestMapping(
            method = {RequestMethod.POST},
            produces = {"application/json", "application/xml", "text/xml"},
            consumes = {"application/json", "application/xml", "text/xml"},
            value = {"/plugins"}
    )
    public String postPlugin(@RequestBody PluginData pluginData) {
        try
        {
            PluginData pd = pluginDataRepository.save( pluginData );
            if ( pd != null )
            {
                return pd.getId();
            }
            else
            {
                return "Error saving plugin";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }

    @Operation(summary = "Change a plugin by its id and content in Body")
    @RequestMapping(
            method = {RequestMethod.PUT},
            produces = {"application/json", "application/xml", "text/xml"},
            consumes = {"application/json", "application/xml", "text/xml"},
            value = {"/plugins/{id}"}
    )
    public String putPlugin(@PathVariable String id, @RequestBody PluginData pluginData) {
        try
        {
            PluginData pd = pluginDataRepository.findFirstById( id );
            if ( pd != null )
            {
                pd.setType( pluginData.getType() );
                pd.setVersion( pluginData.getVersion() );
                pd.setDescription( pluginData.getDescription() );
                pd.setOwner( pluginData.getOwner() );
                pd.setRegisteredDate( pluginData.getRegisteredDate() );
                pd.setName( pluginData.getName() );
                pd.setRepo( pluginData.getRepo() );
                pluginDataRepository.save( pd );
            return pd.getId();
            }
            else
            {
                return "Error changing plugin";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }

    @Operation(summary = "Delete a plugin by its id")
    @RequestMapping(
            method = {RequestMethod.DELETE},
            value = {"/plugins/{id}"}
    )
    public String deletePlugin(@PathVariable String id) {
        try
        {
            PluginData pd = pluginDataRepository.findFirstById( id );
            if ( pd != null )
            {

                pluginDataRepository.delete( pd );
                return pd.getId();
            }
            else
            {
                return "Error changing plugin";
            }
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
}
