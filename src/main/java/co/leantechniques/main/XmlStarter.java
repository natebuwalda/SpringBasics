package co.leantechniques.main;

import co.leantechniques.person.service.PersonService;
import com.google.common.base.Stopwatch;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class XmlStarter {

    public static void main(String[] args) {
        Stopwatch watch = Stopwatch.createUnstarted();

        watch.start();
        ApplicationContext xmlConfigCtx = new ClassPathXmlApplicationContext(new String[] {"application-config.xml"});
        PersonService bean = xmlConfigCtx.getBean("personService", PersonService.class);

        watch.stop();
        System.out.println(String.format("xml = %d ms", watch.elapsed(TimeUnit.MILLISECONDS)));
        watch.reset();
    }

}
