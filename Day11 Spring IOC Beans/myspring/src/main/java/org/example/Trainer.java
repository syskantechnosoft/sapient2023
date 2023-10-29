package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("t1")
public class Trainer {
    private int id;
    private String name;

    public Trainer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Trainer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
