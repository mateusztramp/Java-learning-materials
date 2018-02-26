import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
	private java.util.logging.Logger logger = Logger.getLogger(getClass().getName());
	public void logExecution() {
		logger.info("Method executing"));
	}

	public void warnIfNull(Object returnedValue) {
		if(returnedValue == null) {
			logger.warning("Returned value is null");
		}
	}
	public void serveException(RuntimeException e) {
		logger.error("Exception:"+ e.getMessage());
	}
	public void methodExecuted(JoinPoint joinPoint) {
		
	
		logger.info("Method "+joinPoint.getSignature().getName()+" has already been executed.");
	}
}
