package dev.ecommerce.productservice.inheritanceexamples.mappedsuperclass;


import jakarta.persistence.Entity;

@Entity(name = "msc_student")
public class Student extends User{
    private double psp;
    private String batchName;
}
