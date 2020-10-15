package registrar;

import java.time.LocalDateTime;

public class Person {
    private String email;
    private String name;
    private LocalDateTime created_date = LocalDateTime.now();

    public Person(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
