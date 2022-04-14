package ro.simavi.mescobrad.auditapp.util;

import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.ocpsoft.rewrite.servlet.config.Redirect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.servlet.ServletContext;

@Component
@ApplicationScope
public class RedirectToIndexConfigurationProvider extends HttpConfigurationProvider {
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Override
    public Configuration getConfiguration(ServletContext t) {
        return ConfigurationBuilder.begin()
                .addRule()
                .when(Direction.isInbound().and(Path.matches("/")))
                .perform(Redirect.temporary(contextPath + "/index.xhtml"));
    }

    @Override
    public int priority() {
        return 10;
    }
}
