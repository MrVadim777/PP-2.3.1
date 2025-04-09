package org.example.model;

import org.example.validation.group.EmailGroup;
import org.example.validation.group.NotBlankGroup;
import org.example.validation.group.SizeGroup;

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
    @NotBlank(message = "Email не может быть пустым", groups = NotBlankGroup.class)
    @Size(min = 2, max = 50, message = "Email должен быть от 2 до 50 символов", groups = SizeGroup.class)
    @Email(message = "Поле не соответствует структуре email", groups = EmailGroup.class)
    private String email;

    @Column(name = "name")
    @NotBlank(message = "Имя не может быть пустым", groups = NotBlankGroup.class)
    @Size(min = 2, max = 64, message = "Имя должно быть от 2 до 64 символов", groups = SizeGroup.class)
    private String name;

    @Column(name = "last_name")
    @NotBlank(message = "Фамилия не может быть пустой", groups = NotBlankGroup.class)
    @Size(min = 2, max = 64, message = "Фамилия должна быть от 2 до 64 символов", groups = SizeGroup.class)
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
