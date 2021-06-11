package com.costinel.Workshop.jdbc.dao;

import com.costinel.Workshop.jdbc.domain.Claim;

import javax.sql.DataSource;
import java.util.List;

public interface ClaimDao {

    // set the data source that will be required to create a connection to the data source
    public void setDataSource(DataSource ds);

    // create a record in the claim table
    public boolean create(Claim claim);

    // retrieve a single claim
    public Claim getClaim(Integer id);

    // retrieve all claims from the table
    public List<Claim> getAllClaims();

    // delete a claim from the table
    public boolean delete(Claim claim);

    // update an existing claim
    public boolean update(Claim claim);

    public void cleanup();
}
