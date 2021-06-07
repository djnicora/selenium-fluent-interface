package com.pluralsight.pages.utils;

public enum FieldEntries {

    ABC("ABC"),
    FOO("FOO"), 
    BAR("BAR");

    private String value; 
    
    
    
    FieldEntries(String value) {
        this.value = value;
    }
    
    
    public String toString() {
        return value;
        
    }
    
}
