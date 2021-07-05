package learn.field_agent.models;

public class Alias {
    int alias_id;
    int agent_id;
    String name;
    String persona;

    public int getAlias_id() {
        return alias_id;
    }

    public void setAlias_id(int alias_id) {
        this.alias_id = alias_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }
}
