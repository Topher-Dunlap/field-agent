package learn.field_agent.data.mappers;

import learn.field_agent.models.AgencyAgent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AgencyAgentMapper implements RowMapper<AgencyAgent> {

    @Override
    public AgencyAgent mapRow(ResultSet resultSet, int i) throws SQLException {

        AgencyAgent agencyAgent = new AgencyAgent();
        agencyAgent.setAgencyId(resultSet.getInt("agency_id"));
        agencyAgent.setIdentifier(resultSet.getString("identifier"));
        agencyAgent.setActivationDate(resultSet.getDate("activation_date").toLocalDate());
        agencyAgent.setActive(resultSet.getBoolean("is_active"));

        SecurityClearanceIdMapper securityClearanceIdMapper = new SecurityClearanceIdMapper();
        agencyAgent.setSecurityClearance(securityClearanceIdMapper.mapRow(resultSet, i));

        AgentIdMapper agentIdMapper = new AgentIdMapper();
        agencyAgent.setAgent(agentIdMapper.mapRow(resultSet, i));

        return agencyAgent;
    }
}
