package com.example.demo;

import com.example.ioc.AbcService;
import com.example.ioc.Autowide;
import com.example.ioc.ControllerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

        AbcService abcService = new AbcService();
        ControllerTest controllerTest = new ControllerTest();
        Class<? extends ControllerTest> clazz = controllerTest.getClass();
        Stream.of(clazz.getDeclaredFields()).forEach(field -> {
            String name = field.getName();
            Autowide annotation = field.getAnnotation(Autowide.class);
            if(annotation!=null){
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    Object o = type.newInstance();
                    field.set(controllerTest,o);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }


        });
    }

}
