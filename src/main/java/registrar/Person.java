package registrar;

import org.springframework.data.annotation.Id;

public class Person {
    @Id
    private long id;
    private String email;
    private String name;

    public Person(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
