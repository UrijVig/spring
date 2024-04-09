package org.example;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Petr", "Ivanov", 45);
        System.out.println(person);
        String jsonPerson = person.serialization();
        System.out.println(jsonPerson);
        Person newPerson = Person.deserialization(jsonPerson);
        System.out.println(newPerson);
    }
}