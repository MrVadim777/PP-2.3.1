package org.example.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    @Size(min = 2, message = "Минимальная длинна email 2 символов")
    @Size(max = 50, message = "Максимальная длинна email 50 символов")
    @Email(message = "Поле не соответствует структуре email")
    @NotBlank(message = "Поле email не может быть пустым")
    private String email;

    @Column(name = "name")
    @Size(min = 2, message = "Минимальная длинна имени 2 символа")
    @Size(max = 64, message = "Максимальная длинна имени 64 символов")
    @NotBlank(message = "Поле имени не может быть пустым")
    private String name;

    @Column(name = "last_name")
    @Size(min = 2, message = "Минимальная длинна фамилии 2 символа")
    @Size(max = 64, message = "Максимальная длинна фамилии 64 символов")
    @NotBlank(message = "Поле фамилии не может быть пустым")
    private String lastName;

    public User() {
    }

    public User(String email, String name, String lastName) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
