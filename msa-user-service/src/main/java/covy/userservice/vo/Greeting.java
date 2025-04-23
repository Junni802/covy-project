package covy.userservice.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <클래스 설명>
 *
 * @author : junni802
 * @date : 2025-02-17
 */

@Component
@Data
public class Greeting {

    @Value("${greeting.message}")
    private String message;

}
