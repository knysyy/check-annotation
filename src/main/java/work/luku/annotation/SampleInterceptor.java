package work.luku.annotation;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

public class SampleInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            SampleAnnotation methodAnnotation = method.getAnnotation(SampleAnnotation.class);
            if (Objects.nonNull(methodAnnotation)) {
                System.out.printf("with annotation. method : %s%n", method.getName());
            } else {
                System.out.printf("without annotation. method : %s%n", method.getName());
            }
        }
        return true;
    }
}
