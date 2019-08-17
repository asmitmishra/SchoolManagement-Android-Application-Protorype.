package com.example.mishr.scope_vit.Model;

public class ProgramDetails {

    private String ProgramName;
    private String Duration;

    public ProgramDetails(String name, String duration){

        setDuration(duration);
        setProgramName(name);

    }

    public String getProgramName() {
        return ProgramName;
    }

    public void setProgramName(String programName) {
        ProgramName = programName;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }
}
