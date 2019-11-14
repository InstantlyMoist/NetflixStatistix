package me.kyllian.netflixstatistix.exceptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InputInvalidException extends Exception{

    private ArrayList<InvalidFieldType> foundTypes;

    public InputInvalidException() {
        this.foundTypes = new ArrayList<InvalidFieldType>();
    }

    public void addType(InvalidFieldType invalidFieldType) {
        if (!foundTypes.contains(invalidFieldType)) foundTypes.add(invalidFieldType);
    }

    public List<InvalidFieldType> getFoundTypes() {
        return foundTypes;
    }
}
