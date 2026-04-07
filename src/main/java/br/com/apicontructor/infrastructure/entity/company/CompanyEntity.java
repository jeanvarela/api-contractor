package br.com.apicontructor.infrastructure.entity.company;

import br.com.apicontructor.infrastructure.entity.location.CityEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "company")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompanyEntity {

    @Id
    @Column(name = "cp_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="companySequence")
    @SequenceGenerator(name="companySequence", sequenceName="company_sequence",  allocationSize = 1)
    private Long id;

    @Column(name = "cp_name")
    private String name;

    @Column(name = "cp_identifier")
    private String identifier;

    @Column(name = "cp_email")
    private String email;

    @Column(name = "cp_address_street")
    private String addressStreet;

    @Column(name = "cp_address_number")
    private Long addressNumber;

    @Column(name = "cp_address_neighborhood")
    private String addressNeighborhood;

    @ManyToOne
    @JoinColumn(name="cp_ct_id", nullable=false)
    private CityEntity city;
}
