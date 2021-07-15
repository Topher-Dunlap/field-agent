package learn.field_agent.models;

import java.util.Objects;

public class SecurityClearance {

    private int securityClearanceId;
    private String security_clearance_name;

    public int getSecurityClearanceId() {
        return securityClearanceId;
    }

    public void setSecurityClearanceId(int securityClearanceId) {
        this.securityClearanceId = securityClearanceId;
    }

    public String getName() {
        return security_clearance_name;
    }

    public void setName(String security_clearance_name) {
        this.security_clearance_name = security_clearance_name;
    }

    public SecurityClearance() {
    }

    public SecurityClearance(int securityClearanceId, String security_clearance_name) {
        this.securityClearanceId = securityClearanceId;
        this.security_clearance_name = security_clearance_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityClearance that = (SecurityClearance) o;
        return securityClearanceId == that.securityClearanceId &&
                Objects.equals(security_clearance_name, that.security_clearance_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(securityClearanceId, security_clearance_name);
    }
}
