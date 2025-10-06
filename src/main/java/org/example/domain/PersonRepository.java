package org.example.domain;



import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    private static List<Person> persons = null;

    public static List<Person> getPersons() {
        if (persons == null) {
            persons = createPersons();
        }
        return persons;
    }

    public static Person getPerson(int id) {
        if (persons == null) {
            persons = createPersons();
        }
        return persons.stream().filter(person->person.getId()==id).findFirst().orElse(null);
    }

    private static List<Person> createPersons() {
        List<Person> persons = new ArrayList<>();

        Person person1 = new Person(1);
        person1.setFirstName("John");
        person1.setLastName("Doe");
        person1.setEmail("johndoe@example.com");
        person1.setImgUrl("https://i.pravatar.cc/150?img=1");

        Person person2 = new Person(2);
        person2.setFirstName("Jane");
        person2.setLastName("Smith");
        person2.setEmail("janesmith@example.com");
        person2.setImgUrl("https://i.pravatar.cc/150?img=2");

        Person person3 = new Person(3);
        person3.setFirstName("Emily");
        person3.setLastName("Johnson");
        person3.setEmail("emilyjohnson@example.com");
        person3.setImgUrl("https://i.pravatar.cc/150?img=3");

        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        return persons;
    }
}