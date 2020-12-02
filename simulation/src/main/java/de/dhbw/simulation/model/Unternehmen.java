package de.dhbw.simulation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Unternehmen {

    private final UUID id;
    private final String name;
    private int budget;

    public Unternehmen(@JsonProperty("id") UUID id,
                       @JsonProperty("name") String name,
                        @JsonProperty("budget") int budget) {
        this.id = id;
        this.name = name;
        this.budget = budget;
    }

    public UUID getId() {
        return id;
    }

    public int getBudget() {return budget;}

    public String getName() {
        return name;
    }
}
