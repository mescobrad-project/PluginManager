package ro.simavi.mescobrad.auditapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.simavi.mescobrad.auditapp.entities.PluginData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CatalogController {

    @GetMapping("/catalog")
    public List<PluginData> catalog(@RequestParam(value = "name", defaultValue = "edge") String name,
            @RequestParam(value = "version", defaultValue = "1.0.1") String version) {
        List<PluginData> lpd = new ArrayList<>();
        lpd.add(  new PluginData( name));
        return lpd;
    }
}
