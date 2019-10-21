package com.yang.learn.multisource1.aspect;

import com.yang.learn.multisource1.anotions.DataSource;
import com.yang.learn.multisource1.component.DataSourceRouteHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DataSourceAspect {
    @Pointcut("execution(* com.yang.learn.multisource1.service..*(..))")
    public void aspect() {}
    @Before("aspect()")
    public void doBefore(JoinPoint point) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if(method.getDeclaringClass().isInterface()) {
            method = point.getTarget().getClass().getMethod(method.getName(), method.getParameterTypes());
        }
       dataSource = method.getAnnotation(DataSource.class);
        if(null != dataSource) {
            DataSourceRouteHolder.setDataSourceKey(dataSource.name());
        }
    }
    @After("aspect()")
    public void doAfter() {
        DataSourceRouteHolder.clearDataSourceKey();
    }
}
