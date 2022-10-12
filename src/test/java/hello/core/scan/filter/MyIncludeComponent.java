package hello.core.scan.filter;

import java.lang.annotation.*;

/**
 * @desc: 어노테이션 만들기
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}
