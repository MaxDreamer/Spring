package note_9.aop_introduce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIntroduce {
	public static void main(String[] args) {
		testBeforeAdviceByCode();
	}
	
	private static void testBeforeAdviceByCode() {
		String configPath = "conf/conf-advice-introduce.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService)ctx.getBean("forumService");
        forumService.removeForum(10);
        forumService.removeTopic(1022);
        Monitorable moniterable = (Monitorable)forumService;
        moniterable.setMonitorActive(true);
        forumService.removeForum(10);
        forumService.removeTopic(1022); 
	}
	
}
