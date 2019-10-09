package no.zendera.FreightApplication.Config;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@ConfigurationProperties("application")
@Accessors(chain=true)
@Component
public class ApplicationConfig {
    private String test;
}