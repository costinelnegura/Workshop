package com.costinel.Workshop.daoimpl;

import com.costinel.Workshop.dao.ClaimDao;
import com.costinel.Workshop.domain.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

// @Repository is a JDBC specific annotation instead of @Component
// This annotation is for the persistence layer
public class ClaimDaoImpl implements ClaimDao {

    private JdbcTemplate jdbcTemplate;

    // wrapping the data source into an instance of jdbcTemplate
    // the data source will be injected from an xml configuration file with its own bean declaration.
    // or simply by annotating it with @Autowired
    // the data source its a factory for database connections

    @Override
    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public boolean create(Claim claim) {
        String sqlQuery = "INSERT INTO claim (salutation, first_name, last_name, address, postcode," +
                " mobile_number, email, vehicle_make, vehicle_model, vehicle_registration, notes) " +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] args = new Object[] {claim.getSalutation(), claim.getFirst_name(), claim.getLast_name(),
                                claim.getAddress(), claim.getPostcode(), claim.getMobile_number(),
                                claim.getEmail(), claim.getVehicle_make(), claim.getVehicle_model(),
                                claim.getVehicle_registration(), claim.getNotes()};
        // == 1 in the return because i am creating only one live in the database
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    @Override
    public Claim getClaim(Integer id) {
        String sqlQuery = "SELECT ID, salutation, first_name, last_name, address, postcode, " +
                "mobile_number, email, vehicle_make, vehicle_model, vehicle_registration, notes " +
                "FROM claim WHERE id = ?";
        Object[] args = new Object[] {id};
        Claim claim = (Claim) jdbcTemplate.queryForObject(sqlQuery, args, new ClaimRowMapper());
        return claim;
    }

    // this method will return a list of all claim beans from the claim table
    @Override
    public List<Claim> getAllClaims() {
        String sqlQuery = "SELECT * FROM claim";
        // the query method from the jdbcTemplate takes 2 arguments and returns a list of Claim objects
        List<Claim> claimList = jdbcTemplate.query(sqlQuery, new ClaimRowMapper());
        return claimList;
    }

    @Override
    public boolean delete(Claim claim) {
        String sqlQuery = "DELETE FROM claim WHERE id = ?";
        Object[] args = new Object[] {claim.getId()};
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    @Override
    public boolean update(Claim claim) {
        String aqlQuery = "UPDATE claim SET notes = ? WHERE id = ?";
        Object[] args = new Object[] {claim.getNotes(), claim.getId()};
        return jdbcTemplate.update(aqlQuery, args) == 1;
    }

    @Override
    public void cleanup() {
        String sqlQuery = "TRUNCATE TABLE claim";
        jdbcTemplate.execute(sqlQuery);
    }
}
