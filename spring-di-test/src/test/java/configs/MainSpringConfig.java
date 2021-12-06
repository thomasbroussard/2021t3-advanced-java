package configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DBSpringConfig.class)
public class MainSpringConfig {

}
