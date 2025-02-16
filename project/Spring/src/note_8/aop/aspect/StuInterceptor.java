package note_8.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class StuInterceptor {


	@Pointcut("execution(* note_8.aop.aspect.Student.print(..))")
	public void printMethod() {
	}

	@Before("printMethod()")
	public void printBeforeAdvice() {
		System.out.println("printBeforeAdvice()!");
	}

	@AfterReturning(pointcut = "printMethod()", returning = "flag")
	public void printAfterAdvice(String flag) {
		System.out.println("printAfterAdvice()! " + flag);
	}

	@After("printMethod()")
	public void finallyAdvice() {
		System.out.println("finallyAdvice()!");
	}

	@Around("printMethod() && args(name)")
	public Object printAroundAdvice(ProceedingJoinPoint pjp, String name)
			throws Throwable {
		Object result = null;
		if (name.equals("mx"))
			pjp.proceed();
		else
			System.out.println("print() is intercepted ...");
		return result;
	}
}
