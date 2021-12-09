package com.kodilla.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.atmosphere.config.service.Get;

import javax.persistence.*;
import java.util.List;

@Entity(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String address;

    private String email;

    private String contactNumber;

    @OneToMany
    private List<Rent> rents;
}
