package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @desc: 컴포넌트 스캔, 의존관계 자동 주입
 */

@Configuration
@ComponentScan(
        // 스프링 빈을 자동으로 다 끌어올리는 어노테이션
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
