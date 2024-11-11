package dev.ecommerce.productservice.inheritanceexamples.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name = "msc_ta")
public class TA extends User{
    private String startTime;
    private String endTime;
}
