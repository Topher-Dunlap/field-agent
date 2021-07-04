package learn.field_agent.domain;

import learn.field_agent.data.AgencyAgentJdbcTemplateRepository;
import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.AgencyAgent;
import learn.field_agent.models.SecurityClearance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityClearanceService {

    private final SecurityClearanceRepository repository;
    private final AgencyAgentJdbcTemplateRepository agencyAgentRepository;

    public SecurityClearanceService(SecurityClearanceRepository repository, AgencyAgentJdbcTemplateRepository agencyAgentRepository) { this.repository = repository;
        this.agencyAgentRepository = agencyAgentRepository;
    }

    public List<SecurityClearance> findAll() {
        return repository.findAll();
    }

    public SecurityClearance findById(int securityClearanceId) {
        return repository.findById(securityClearanceId);
    }

    public Result<SecurityClearance> add(SecurityClearance securityClearance) {
        Result<SecurityClearance> result = validate(securityClearance);
        if (!result.isSuccess()) {
            return result;
        }

        if (securityClearance.getSecurityClearanceId() != 0) {
            result.addMessage("securityClearanceId cannot be set for `add` operation", ResultType.INVALID);
            return result;
        }

        securityClearance = repository.add(securityClearance);
        result.setPayload(securityClearance);
        return result;
    }

    public Result<SecurityClearance> update(SecurityClearance securityClearance) {
        Result<SecurityClearance> result = validate(securityClearance);
        if (!result.isSuccess()) {
            return result;
        }

        if (securityClearance.getSecurityClearanceId() <= 0) {
            result.addMessage("SecurityClearanceId must be set for `update` operation", ResultType.INVALID);
            return result;
        }

        if (!repository.update(securityClearance)) {
            String msg = String.format("SecurityClearanceId: %s, not found", securityClearance.getSecurityClearanceId());
            result.addMessage(msg, ResultType.NOT_FOUND);
        }

        return result;
    }

    public Result<Boolean> deleteById(int securityClearanceId) {
        Result<Boolean> result = new Result<>();

        //check that clearance with ID exists
        SecurityClearance clearanceToDelete = findById(securityClearanceId);
        if(clearanceToDelete == null){
            String msg = String.format("Security Clearance Id: %s, not found", securityClearanceId);
            result.addMessage(msg, ResultType.NOT_FOUND);
            return result;
        }

        //make sure clearance does not have relationship to Agency Agent bridge table
        List<AgencyAgent> agencyAgents = agencyAgentRepository.findAll();
        for(AgencyAgent agencyAgent : agencyAgents){
            if (agencyAgent.getSecurityClearance().getSecurityClearanceId() == securityClearanceId) {
                result.addMessage("Cannot delete Security Clearance with Agency Agent relationship", ResultType.INVALID);
                return result;
            }
        }

        repository.deleteById(securityClearanceId);
        return result;
    }

    private Result<SecurityClearance> validate(SecurityClearance securityClearance) {
        Result<SecurityClearance> result = new Result<>();
        if (securityClearance == null) {
            result.addMessage("Security Clearance cannot be null", ResultType.INVALID);
            return result;
        }

        if (Validations.isNullOrBlank(securityClearance.getName())) {
            result.addMessage("Name is required", ResultType.INVALID);
            return result;
        }

        List<SecurityClearance> securityClearances = findAll();
        for(SecurityClearance existingClearance : securityClearances){
            if (Validations.isDuplicateString(securityClearance.getName(), existingClearance.getName())) {
                result.addMessage("Cannot be a duplicate name", ResultType.INVALID);
            }
        }

        return result;
    }
}
