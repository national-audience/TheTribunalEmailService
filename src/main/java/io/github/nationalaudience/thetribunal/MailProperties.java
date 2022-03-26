package io.github.nationalaudience.thetribunal;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("file:mail.properties")
public record MailProperties(Environment env) {

    public String getConfigValue(String configKey) {
        return env.getProperty(configKey);
    }
}
