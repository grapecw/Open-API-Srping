package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudyApp {

	public static void main(String[] args) {
		ApplicationContext factory =
				   new ClassPathXmlApplicationContext("exam2/bean1.xml");
		
		Student b1 = (Student)factory.getBean("st1");
		System.out.println(b1.getName()+"�� "+b1.getMyHomework().getHomeworkName()+"�� �н��մϴ�.");
		Student b2 = (Student)factory.getBean("st3");
		System.out.println(b2.getName()+"�� "+b1.getMyHomework().getHomeworkName()+"�� �н��մϴ�.");
		Student b3 = (Student)factory.getBean("st3");
		System.out.println(b3.getName()+"�� "+b1.getMyHomework().getHomeworkName()+"�� �н��մϴ�.");
		
		ApplicationContext factory2 =
				   new ClassPathXmlApplicationContext("exam2/bean1.xml");
		
		Student b1_2 = (Student)factory2.getBean("st1");
		System.out.println(b1_2.getName()+"�� "+b1_2.getMyHomework().getHomeworkName()+"�� �н��մϴ�.");
		Student b2_2 = (Student)factory2.getBean("st3");
		System.out.println(b2_2.getName()+"�� "+b1_2.getMyHomework().getHomeworkName()+"�� �н��մϴ�.");
		Student b3_2 = (Student)factory2.getBean("st3");
		System.out.println(b3_2.getName()+"�� "+b1_2.getMyHomework().getHomeworkName()+"�� �н��մϴ�.");

		((ClassPathXmlApplicationContext)factory).close();
	}
}
