package com.costinel.Workshop.daoimpl;

import com.costinel.Workshop.dao.ClaimDao;
import com.costinel.Workshop.domain.Claim;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ClaimDaoImpl implements ClaimDao {

    private JdbcTemplate jdbcTemplate;

    // wrapping the data source into an instance of jdbcTemplate
    // the data source will be injected from an xml configuration file with its own bean declaration.
    // the data source its a factory for data source connections
    @Override
    public void setDataSource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public boolean create(Claim claim) {
        return false;
    }

    @Override
    public Claim getClaim(Integer id) {
        return null;
    }

    // this method will return a list of all claims from the claim table
    @Override
    public List<Claim> getAllClaims() {
        String sqlQuery = "SELECT * FROM claim";
        // the query method from the jdbcTemplate takes 2 arguments and returns a list of Claim objects
        List<Claim> claimList = jdbcTemplate.query(sqlQuery, new ClaimRowMapper());
        return claimList;
    }

    @Override
    public boolean delete(Claim claim) {
        return false;
    }

    @Override
    public boolean update(Claim claim) {
        return false;
    }

    @Override
    public void cleanup() {

    }
}
