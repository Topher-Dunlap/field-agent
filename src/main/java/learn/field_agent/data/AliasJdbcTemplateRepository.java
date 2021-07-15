package learn.field_agent.data;

import learn.field_agent.data.mappers.AliasMapper;
import learn.field_agent.models.Alias;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class AliasJdbcTemplateRepository implements AliasRepository{

    private final JdbcTemplate jdbcTemplate;

    public AliasJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Alias> findAll() {
        final String sql = "select * from alias;";
        return jdbcTemplate.query(sql, new AliasMapper());
    }

    @Override
    public Alias findById(int alias_id) {
        final String sql = "select alias_id, name name, persona, agent_id "
                + "from alias "
                + "where alias_id = ?;";
        return jdbcTemplate.query(sql, new AliasMapper(), alias_id)
                .stream()
                .findFirst().orElse(null);
    }


    @Override
    public Alias add(Alias alias) {
        final String sql = "insert into alias (name, persona, agent_id) " + " values (?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alias.getName());
            ps.setString(2, alias.getPersona());
            ps.setInt(3, alias.getAgent_id());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        alias.setAlias_id(keyHolder.getKey().intValue());
        return alias;
    }

    @Override
    public boolean update(Alias alias) {
        final String sql = "update alias set "
                + "name = ?, "
                + "persona = ?, "
                + "agent_id = ? "
                + " where alias_id = ?; ";

        return jdbcTemplate.update(sql, alias.getName(), alias.getPersona(), alias.getAgent_id(), alias.getAlias_id()) > 0;
    }

    @Override
    public boolean deleteById(int alias_id) {
        return jdbcTemplate.update("delete from alias where alias_id = ?;", alias_id) > 0;
    }
}
