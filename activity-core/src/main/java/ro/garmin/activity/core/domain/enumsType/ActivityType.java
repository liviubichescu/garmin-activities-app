package ro.garmin.activity.core.domain.enumsType;

public enum ActivityType {

    RUNNING("RUNNING"),
    SWIMMING("SWIMMING");

    private String type;

    ActivityType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

}
