package com.gmail.psyh2409;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Questionnaire {
    private List<String> assertions;

    public Questionnaire(List assertions){
        super();
        this.assertions = assertions;
    }

    public Questionnaire(){
        super();
        assertions = new ArrayList<>();
        assertions.add("Crimea is Ukraine.");
        assertions.add("Medvedchuk is traitor.");
        assertions.add("All will be Ukraine.");
    }

    public List<String> getAssertions() {
        return assertions;
    }

    public void setAssertions(List<String> assertions) {
        this.assertions = assertions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Questionnaire that = (Questionnaire) o;
        return Objects.equals(assertions, that.assertions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assertions);
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "assertion=" + assertions +
                '}';
    }
}
