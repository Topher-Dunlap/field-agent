package learn.field_agent.data.mappers;

import learn.field_agent.models.SecurityClearance;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SecurityClearanceIdMapper implements RowMapper<SecurityClearance> {

    @Override
    public SecurityClearance mapRow(ResultSet resultSet, int i) throws SQLException {
        SecurityClearance securityClearance = new SecurityClearance();
        securityClearance.setSecurityClearanceId(resultSet.getInt("security_clearance_id"));
        return securityClearance;
    }
}
