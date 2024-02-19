package kr.dbinc.evon.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* *..*(..))")
    private void allMatch(){}

    @AfterThrowing(value = "allMatch()", throwing = "ex")
    public void doLogging(JoinPoint joinPoint, Exception ex) throws RuntimeException{
        Logger logger = LoggerFactory.getLogger(joinPoint.getSignature().getClass());
        logger.error(ex.getLocalizedMessage(), ex);
    }
}
