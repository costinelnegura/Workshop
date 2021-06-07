package com.costinel.Workshop;

import com.costinel.Workshop.dao.ClaimDao;
import com.costinel.Workshop.domain.Claim;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ClaimJdbcApp {
    public static void main(String[] args) {
        // creating the application context
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

        // create the bean
        ClaimDao dao = (ClaimDao) ctx.getBean("claimDao");
        List<Claim> claims = dao.getAllClaims();
        for (Claim claim : claims){
            System.out.println(claim);
        }

        // close the application context
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
