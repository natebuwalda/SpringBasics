package co.leantechniques.main;

import co.leantechniques.person.service.PersonService;
import com.google.common.base.Stopwatch;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

public class CodeStarter {

    public static void main(String[] args) {
        Stopwatch watch = Stopwatch.createUnstarted();

        watch.start();
        ApplicationContext codeConfigCtx = new AnnotationConfigApplicationContext(AppConfig.class);
        PersonService bean = codeConfigCtx.getBean("personService", PersonService.class);

        watch.stop();
        System.out.println(String.format("code = %d ms", watch.elapsed(TimeUnit.MILLISECONDS)));
        watch.reset();

    }

}
