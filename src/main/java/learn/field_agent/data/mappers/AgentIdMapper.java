package learn.field_agent.data.mappers;

import learn.field_agent.models.Agent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentIdMapper implements RowMapper<Agent> {

    @Override
    public Agent mapRow(ResultSet resultSet, int i) throws SQLException {
        Agent agent = new Agent();
        agent.setAgentId(resultSet.getInt("agent_id"));
        return agent;
    }
}
