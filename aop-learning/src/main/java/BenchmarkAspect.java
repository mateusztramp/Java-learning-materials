import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;

public class BenchmarkAspect {
	private Logger logger = Logger.getLogger(getClass());
	public void measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) {
		long startTime = System.nanoTime();
		try {
			Customer customer = (Customer) proceedingJoinPoint.getArgs()[0];
			if(customer.getName() == null) {
				Object[] args = new Object[] {new Customer("Anonim")};
				proceedingJoinPoint.proceed(args);
			}
		    else {
		    	proceedingJoinPoint.proceed();
		    }
		}
		catch(Throwable e) {}
		
		long endTime = System.nanoTime();
		logger.info("Execution time = " + (endTime - startTime) + "ns");
	}
}
