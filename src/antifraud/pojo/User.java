package antifraud.pojo;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JsonPropertyOrder(
        value = "id"
)
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
    private String password;

    @Column
    private String role;

    public User( String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = "USER";

    }


    public User() {
        this.role = "USER";

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
}
