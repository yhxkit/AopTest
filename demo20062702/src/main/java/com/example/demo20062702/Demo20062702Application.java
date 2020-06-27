package com.example.demo20062702;

import com.example.demo20062702.aop.ArithmeticCalc;
import com.example.demo20062702.aop.UnitCalc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class Demo20062702Application implements CommandLineRunner {


    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(Demo20062702Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(CalcConf.class);

        for(String name : context.getBeanDefinitionNames()){
            System.out.println(name);

        }


        ArithmeticCalc arithmeticCalculator =
                context.getBean("arithmeticCalc", ArithmeticCalc.class);
        arithmeticCalculator.add(1, 2);
        arithmeticCalculator.sub(4, 3);
        arithmeticCalculator.mul(2, 3);
        arithmeticCalculator.div(4, 2);

        UnitCalc unitCalculator = context.getBean("unitCalc", UnitCalc.class);
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilometerToMile(5);

    }
}
