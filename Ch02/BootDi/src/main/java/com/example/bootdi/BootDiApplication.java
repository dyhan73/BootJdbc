package com.example.bootdi;

import com.example.bootdi.app.Argument;
import com.example.bootdi.app.ArgumentResolver;
import com.example.bootdi.app.Calculator;
import com.example.bootdi.app.Frontend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

@SpringBootApplication
//@Import(AppConfig.class)
//@ComponentScan
public class BootDiApplication implements CommandLineRunner {

    @Autowired
    ArgumentResolver argumentResolver;
    @Autowired
    Calculator calculator;

    @Override
    public void run(String... args) throws Exception {
        System.out.print("Enter 2 numbers like 'a b' : ");
        Argument argument = argumentResolver.resolve(System.in);
        int result = calculator.calc(argument.getA(), argument.getB());
        System.out.println("Result = " + result);
    }

    public static void main(String[] args) {
//        try (ConfigurableApplicationContext context = SpringApplication.run(BootDiApplication.class, args)) {
////            System.out.print("Enter 2 numbers like 'a b' : ");
//////            Scanner scanner = new Scanner(System.in);
//////            int a = scanner.nextInt();
//////            int b = scanner.nextInt();
//////            scanner.close();
////
////            ArgumentResolver argumentResolver = context.getBean(ArgumentResolver.class);
////            Argument argument = argumentResolver.resolve(System.in);
////
////            Calculator calculator = context.getBean(Calculator.class);
////            int result = calculator.calc(argument.getA(), argument.getB());
////            System.out.println("Result = " + result);
//
//            Frontend frontend = context.getBean(Frontend.class);
//            frontend.run();
//        }
        SpringApplication.run(BootDiApplication.class, args);
    }

}
