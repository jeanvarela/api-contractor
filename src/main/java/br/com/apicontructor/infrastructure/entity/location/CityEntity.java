package br.com.apicontructor.infrastructure.entity.location;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "city")
public class CityEntity {

    @Id
    @Column(name = "ct_id")
    private Long id;

    @Column(name = "ct_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ct_st_id")
    private StateEntity state;
}