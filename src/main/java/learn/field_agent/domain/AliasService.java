package learn.field_agent.domain;

import learn.field_agent.data.AgentRepository;
import learn.field_agent.data.AliasRepository;
import learn.field_agent.models.Alias;
import learn.field_agent.models.AliasAndAgent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AliasService {
    private final AliasRepository aliasRepository;
    private final AgentRepository agentRepository;

    public AliasService(AliasRepository aliasRepository, AgentRepository agentRepository) {
        this.aliasRepository = aliasRepository;
        this.agentRepository = agentRepository;
    }

    public List<Alias> findAll() {
        return aliasRepository.findAll();
    }

    public Alias findById(int aliasId) {
        return aliasRepository.findById(aliasId);
    }

    public Result<Alias> add(Alias alias) {
        Result<Alias> result = validate(alias);
        if (!result.isSuccess()) {
            return result;
        }

        if (alias.getAlias_id() != 0) {
            result.addMessage("aliasId cannot be set for `add` operation", ResultType.INVALID);
            return result;
        }

        alias = aliasRepository.add(alias);
        result.setPayload(alias);
        return result;
    }

    public Result<Alias> update(Alias alias) {
        Result<Alias> result = validate(alias);
        if (!result.isSuccess()) {
            return result;
        }

        if (alias.getAlias_id() <= 0) {
            result.addMessage("aliasId must be set for `update` operation", ResultType.INVALID);
            return result;
        }

        if (!aliasRepository.update(alias)) {
            String msg = String.format("aliasId: %s, not found", alias.getAgent_id());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;
    }

    public boolean deleteById(int aliasId) {
        return aliasRepository.deleteById(aliasId);
    }

    private Result<Alias> validate(Alias newAlias) {
        Result<Alias> result = new Result<>();
        if (newAlias == null) {
            result.addMessage("Alias cannot be null", ResultType.INVALID);
            return result;
        }

        if (Validations.isNullOrBlank(newAlias.getName())) {
            result.addMessage("Name is required", ResultType.INVALID);
        }

        List<Alias> aliases = findAll();
        for(Alias existingAlias : aliases){
            if(newAlias.getName().equals(existingAlias.getName()) && newAlias.getPersona().equals(existingAlias.getPersona())){
                result.addMessage("Duplicate named aliases need to have a different Persona.", ResultType.INVALID);
            }
        }

        return result;
    }

}
