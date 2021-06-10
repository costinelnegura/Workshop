package com.costinel.Workshop;

import com.costinel.Workshop.dao.ClaimDao;
import com.costinel.Workshop.domain.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;


// This class is to test the DB functionality of the webapp.

@Component
public class ClaimJdbcApp {

    @Autowired
    private ClaimDao dao;

    public void actionMethod(){
        //create a claim
//        Claim newClaim = new Claim("Mr", "Costinel", "Negura", "22 Albers Street",
//                "SE4 7UU", 78503, "costinel@costinel.com", "Mercedes",
//                "CLS", "AL70EXA", "TBA");
//        dao.create(newClaim);

        // print all the claims
        List<Claim> claims = dao.getAllClaims();
        for (Claim claim : claims){
            System.out.println(claim);
        }

        // print an organisation by looking for an id
        System.out.println(dao.getClaim(1));

        // updating notes for a claim by looking for it by id
        Claim claimToUpdate = dao.getClaim(1);
        claimToUpdate.setNotes("note change");
        dao.update(claimToUpdate);
        System.out.println(dao.getClaim(1));

        // delete an organisation
//        dao.delete(dao.getClaim(1));
    }


    public static void main(String[] args) {

        // creating the application context
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
        ClaimJdbcApp mainApp = ctx.getBean(ClaimJdbcApp.class);
        mainApp.actionMethod();

        // close the application context
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
