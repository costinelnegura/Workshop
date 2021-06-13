package com.costinel.Workshop.service;

import com.costinel.Workshop.jdbc.dao.ClaimDao;
import com.costinel.Workshop.jdbc.domain.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private ClaimDao claimDao;

    public List<Claim> getClaimList(){
        List<Claim> claimList = claimDao.getAllClaims();
        return claimList;
    }

    public List<Claim> getclaim(String registration){
        List<Claim> claimsbyRegistration = claimDao.getClaimByRegistration(registration);
        return claimsbyRegistration;
    }
}
