package com.example.exam_sever.entities;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(nullable = false, unique = true)

    private String id;

    @Column(nullable = false)
    public String name;
    @Column(nullable = false, unique = true)

    private String phone;
    @Column(nullable = false)

    private Date birthday;
    @Column(nullable = false, unique = true)

    private String email;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
