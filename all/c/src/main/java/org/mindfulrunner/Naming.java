package org.mindfulrunner;

/*
//group 'org.mindfulrunner'
//version '1.0'
public abstract class Naming {
    public String getName(String name) {
        return "Naming:v1, abstract class, name: " + name;
    }
}
*/

//group 'org.mindfulrunner'
//version '2.0'
public interface Naming {
    default String getName(String name) {
        return "Naming:v2, interface, name: " + name;
    }
}
