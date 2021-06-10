package com.costinel.Workshop.daoimpl;

import com.costinel.Workshop.dao.ClaimDao;
import com.costinel.Workshop.domain.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

// @Repository is a JDBC specific annotation instead of @Component
// This annotation is for the persistence layer
@Repository
public class ClaimDaoImpl implements ClaimDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // wrapping the data source into an instance of jdbcTemplate
    // the data source will be injected from an xml configuration file with its own bean declaration.
    // or simply by annotating it with @Autowired
    // the data source its a factory for database connections

    @Override
    @Autowired
    public void setDataSource(DataSource ds) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public boolean create(Claim claim) {
        // If i have to pass a bean such as the claim to a dao object using the
        // NamedParameterJdbcTemplate, i have to use the BeanPropertySqlParameterSource
        SqlParameterSource beanParams = new BeanPropertySqlParameterSource(claim);
        String sqlQuery = "INSERT INTO claim (salutation, first_name, last_name, address, postcode," +
                " mobile_number, email, vehicle_make, vehicle_model, vehicle_registration, notes) " +
                " VALUES(:salutation, :first_name, :last_name, :address, :postcode," +
                " :mobile_number, :email, :vehicle_make, :vehicle_model, :vehicle_registration, :notes)";
        return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
    }

    @Override
    public Claim getClaim(Integer id) {
        // if i want to parse separate parameters that don't correspond to a specific bean
        // then i have to use the MapSqlParameterSource
        SqlParameterSource params = new MapSqlParameterSource("ID", id);
        String sqlQuery = "SELECT ID, salutation, first_name, last_name, address, postcode, " +
                "mobile_number, email, vehicle_make, vehicle_model, vehicle_registration, notes " +
                "FROM claim WHERE id = :ID";
        Claim claim = (Claim) namedParameterJdbcTemplate.queryForObject(sqlQuery, params, new ClaimRowMapper());
        return claim;
    }

    // this method will return a list of all claim beans from the claim table
    @Override
    public List<Claim> getAllClaims() {
        String sqlQuery = "SELECT * FROM claim";
        // the query method from the jdbcTemplate takes 2 arguments and returns a list of Claim objects
        List<Claim> claimList = namedParameterJdbcTemplate.query(sqlQuery, new ClaimRowMapper());
        return claimList;
    }

    @Override
    public boolean delete(Claim claim) {
        BeanPropertySqlParameterSource beanParams = new BeanPropertySqlParameterSource(claim);
        String sqlQuery = "DELETE FROM claim WHERE id = :id";
        return namedParameterJdbcTemplate.update(sqlQuery, beanParams) == 1;
    }

    @Override
    public boolean update(Claim claim) {
        BeanPropertySqlParameterSource beanParams = new BeanPropertySqlParameterSource(claim);
        String aqlQuery = "UPDATE claim SET notes = :notes WHERE id = :id";
        return namedParameterJdbcTemplate.update(aqlQuery, beanParams) == 1;
    }

    @Override
    public void cleanup() {
        String sqlQuery = "TRUNCATE TABLE claim";
        namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
    }
}
