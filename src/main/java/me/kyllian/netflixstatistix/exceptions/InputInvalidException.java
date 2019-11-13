package me.kyllian.netflixstatistix.exceptions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InputInvalidException extends Exception{

    private ArrayList<InvalidFieldType> foundTypes;
    private List<InvalidFieldType> ignoredTypes;

    public InputInvalidException() {
        this.foundTypes = new ArrayList<InvalidFieldType>();
        this.ignoredTypes = new ArrayList<InvalidFieldType>();
    }

    public void addType(InvalidFieldType invalidFieldType) {
        if (!foundTypes.contains(invalidFieldType)) foundTypes.add(invalidFieldType);
    }

    public void addIgnoredType(InvalidFieldType invalidFieldType) {
        if (!ignoredTypes.contains(invalidFieldType)) ignoredTypes.add(invalidFieldType);
    }

    public List<InvalidFieldType> getFoundTypes() {
        List<InvalidFieldType> fieldTypes = (ArrayList<InvalidFieldType>) foundTypes.clone();
        fieldTypes.removeAll(ignoredTypes);
        return fieldTypes;
    }
}
