package ro.simavi.mescobrad.auditapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ro.simavi.mescobrad.auditapp.entities.PluginData;
import ro.simavi.mescobrad.auditapp.services.PluginDataService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RepositoryController {
    @Autowired
    PluginDataService pluginDataService;

    @GetMapping("/repository")
    public List<PluginData> registry(@RequestParam(value = "name", defaultValue = "edge") String name,
            @RequestParam(value = "version", defaultValue = "1.0.1") String version) {
        List<PluginData> lpd = new ArrayList<>();
        lpd.addAll(  pluginDataService.findAll());
        return lpd;
    }

    @GetMapping("/repository/{id}")
    public PluginData listRegistered(@PathVariable String id) {
        return  pluginDataService.findFirstById(id);

    }

    @PostMapping("/repository/upload")
    public List<PluginData> upload(@RequestParam(value = "name", defaultValue = "edge") String name,
            @RequestParam(value = "version", defaultValue = "1.0.1") String version,
            @RequestParam("json") MultipartFile json, @RequestParam("xml") MultipartFile xml) {
        List<PluginData> lpd = new ArrayList<>();
        lpd.add(  new PluginData( name));
        return lpd;
    }

    @PostMapping("/repository/download")
    public MultipartFile download(@RequestParam(value = "name", defaultValue = "edge") String name,
            @RequestParam(value = "version", defaultValue = "1.0.1") String version) {

        MultipartFile mpf = null;
        return mpf;
    }

    @GetMapping("repository/check")
    public String check(@RequestParam(value = "name", defaultValue = "edge") String name,
            @RequestParam(value = "version", defaultValue = "1.0.1") String version, @RequestParam(value = "hash", defaultValue = "MD5") String hash) {
        try {

            return "OK";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
