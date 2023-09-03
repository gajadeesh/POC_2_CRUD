package com.gajadeesh.poc_2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee")
@Getter
@Setter
public class Employee {
    @Id
    @JsonProperty(value="Id")
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonProperty(value="FirstName")
    @Column(name = "firstname")
    String firstname;

    @JsonProperty(value="LastName")
    @Column(name = "lastname")
    String lastname;

    @JsonProperty(value="ExtensionName")
    @Column(name = "extension_name")
    String extensionname;

    @JsonProperty(value="Birthday")
    @Column(name = "birthday")
    Date birthday;
}
