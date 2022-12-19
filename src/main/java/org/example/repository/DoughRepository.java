package org.example.repository;

import org.example.entityes.Dough;

import java.util.ArrayList;

public class DoughRepository {
    private ArrayList<Dough> doughs = new ArrayList<>();

    public Dough getDoughByName(String name) {
        for (Dough dough : doughs) {
            if (dough.getName().equals(name)) {
                doughs.remove(dough);
                return dough;
            }
        }
        return null;
    }

    public boolean addDough(Dough dough) {
        for(Dough d : doughs) {
            if(d.getName().equals(dough.getName())) return false;
        }
        doughs.add(dough);
        return true;
    }
}
