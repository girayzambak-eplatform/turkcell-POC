package com.turkcell.poc.log;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.turkcell.poc.enums.RequestTypeEnum;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class LoggingMongo {
    @Autowired(required = false)
    private HttpServletRequest request;

    @Autowired
    private LogRepository repository;

    /**
     * Restservisler çağırılmadan önce bu aspect yapı ile yakalanır.
     * Gelen request LogCollection'a kaydedilir.
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("@within(org.springframework.stereotype.Controller) && @annotation(com.turkcell.poc.log.LoggerMongo) && execution(public * *.*(..))")
    public void mongoLogger(JoinPoint joinPoint) throws Throwable {
        LogCollection log = new LogCollection()
                .setRequestTime(new Date())
                .setRequestParams(getRequestParam(joinPoint))
                .setRequestTypeEnum(getRequestType(joinPoint))
                .setRequestClass(getRequestClass(joinPoint))
                .setRequestMethodName(getRequestRequestMethodName(joinPoint))
                .setRequestUrl(getRequestUrl())
                .setRequestMethodPath(getRequestPath());

        repository.save(log);
    }

    /**
     * Rest serviste RequestBody içerisinde gönderilen parametrelieri döner
     *
     * @param joinPoint
     * @return String
     */
    private String getRequestParam(JoinPoint joinPoint) {

        try {
            Object[] params = joinPoint.getArgs();

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

            return ow.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Rest serviste LoggerMongo anotasyonundaki requestType değerini döner.
     *
     * @param joinPoint
     * @return String
     */
    private RequestTypeEnum getRequestType(JoinPoint joinPoint) {
        MethodSignature methodSignature = ((MethodSignature) joinPoint.getSignature());
        Annotation annotation = Arrays.stream(methodSignature.getMethod().getDeclaredAnnotations())
                .filter(row -> row.annotationType().equals(LoggerMongo.class))
                .findAny()
                .orElse(null);

        if(annotation == null)
            return RequestTypeEnum.NOT_SET;

        return ((LoggerMongo) annotation).requestType();
    }

    /**
     * Rest servis'in bulunduğu sınıfı döner
     *
     * @param joinPoint
     * @return String
     */
    private String getRequestClass(JoinPoint joinPoint){
        return joinPoint.getSignature().getDeclaringTypeName();
    }

    /**
     * Rest servisin method adı döner
     *
     * @param joinPoint
     * @return String
     */
    private String getRequestRequestMethodName(JoinPoint joinPoint){
        return joinPoint.getSignature().getName();
    }

    /**
     * Request url'i döner
     *
     * @return String
     */
    private String getRequestUrl(){
        return request.getRequestURL().toString();
    }

    /**
     * Rest servisin path'ini döner
     *
     * @return String
     */
    private String getRequestPath(){
        return request.getRequestURI();
    }
}
