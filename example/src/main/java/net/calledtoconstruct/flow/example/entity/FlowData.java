package net.calledtoconstruct.flow.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "FLOW_DATA")
public class FlowData {
    @Id public int id;
    @Column public String name;
    @Column public String description;
}
