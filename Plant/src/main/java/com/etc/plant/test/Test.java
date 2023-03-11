package com.etc.plant.test;

import com.etc.plant.entity.Plants;
import com.etc.plant.service.BackService;
import com.etc.plant.service.impl.BackServiceImpl;
import com.etc.plant.service.impl.PlantServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        PlantServiceImpl service = (PlantServiceImpl) context.getBean("plantServiceImpl");

        BackServiceImpl service = (BackServiceImpl) context.getBean("backServiceImpl");
        List<Plants> plantsList = service.sortPlant("price");
        System.out.println(plantsList);


    }
}
