package configs;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:application.conf")
public interface PageConfig extends Config {
    @Key("base_url")
    String baseUrl();
}
