package entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Employee {

    private long id;
    private String firstName;
    private String lastName;

}
