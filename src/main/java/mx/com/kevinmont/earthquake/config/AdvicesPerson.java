package mx.com.kevinmont.earthquake.config;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AdvicesPerson {
	
	private static final Logger logger = Logger.getLogger(AdvicesPerson.class);

	@Around("@annotation(ConfigAOP)")
	public Object aspec( ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		this.logger.info("Starting method: "+ proceedingJoinPoint.getSignature().getName());
		Object p=proceedingJoinPoint.proceed();
		this.logger.info("Ending method: "+ proceedingJoinPoint.getSignature().getName());
		return p;
	}
	
}
