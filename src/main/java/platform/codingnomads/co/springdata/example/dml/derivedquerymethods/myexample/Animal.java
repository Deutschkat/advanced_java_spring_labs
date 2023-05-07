package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "animals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Animal {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String animalName;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private Diet animalDiet;

    private String genus;


}
