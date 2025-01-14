package br.com.apicontructor.infrastructure.entity.location;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "state")
public class StateEntity {

    @Id
    @Column(name = "st_id")
    private Long id;

    @Column(name = "st_name")
    private String name;

//    @Column(name = "st_abbreviation")
//    private String abbreviation;

}