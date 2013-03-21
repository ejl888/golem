package nl.finalist.golem.service.vocabulary;


public final class VdexSummary {

    private final String identifier;
    
    private final String name;

    public static class Builder {
        private String identifier;
        private String name;

        private Builder() {}

        public Builder withIdentifier(String anIdentifier) {
            this.identifier = anIdentifier;
            return this;
        }

        public Builder withName(String aName) {
            this.name = aName;
            return this;
        }
        
        public VdexSummary build() {
            return new VdexSummary(this);
        }
    }
    
    public static Builder aVdexSummary() {
        return new Builder();
    }
    
    private VdexSummary(Builder builder) {
        this.identifier = builder.identifier;
        this.name = builder.name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }
    
    

}
