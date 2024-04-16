package com.snp.feedservice.configuration.properties;

import com.snp.feedservice.configuration.factory.YamlPropertySourceFactory;
import com.snp.feedservice.configuration.properties.base.BaseUserService;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:config/properties/base-properties.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties("base")
@Data
@Getter
@Primary
public class BaseProperties {

    private BaseUserService userService;

}
