package com.costinel.Workshop.jdbc.daoimpl;

import com.costinel.Workshop.jdbc.domain.Claim;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClaimRowMapper implements RowMapper {
    @Override
    public Claim mapRow(ResultSet rs, int rownum) throws SQLException {
        Claim claim = new Claim();
        claim.setId(rs.getInt("id"));
        claim.setSalutation(rs.getString("salutation"));
        claim.setFirst_name(rs.getString("first_name"));
        claim.setLast_name(rs.getString("last_name"));
        claim.setAddress(rs.getString("address"));
        claim.setPostcode(rs.getString("postcode"));
        claim.setMobile_number(rs.getInt("mobile_number"));
        claim.setEmail(rs.getString("email"));
        claim.setVehicle_make(rs.getString("vehicle_make"));
        claim.setVehicle_model(rs.getString("vehicle_model"));
        claim.setVehicle_registration(rs.getString("vehicle_registration"));
        claim.setNotes(rs.getString("notes"));
        return claim;
    }
}
