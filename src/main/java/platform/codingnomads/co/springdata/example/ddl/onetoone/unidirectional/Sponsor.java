package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sponsor")
@NoArgsConstructor
@Getter
@Setter
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String brandName;

    @OneToOne
    private Driver driver;
}