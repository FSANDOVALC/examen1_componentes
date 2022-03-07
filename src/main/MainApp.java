package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import beans.MySpringDecoderBeanWithDependency;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("file:META-INF/beans.xml");

        BeanFactory factory = context;

        MySpringDecoderBeanWithDependency test = (MySpringDecoderBeanWithDependency) factory.getBean("MySpringDecoderBeanWithDependency");

        test.run("TextoCodificado");

    }
}
