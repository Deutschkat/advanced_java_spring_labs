package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "animal_diets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Diet {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String dietClassification;

    @Column(nullable = false, unique = true)
    private String dietDescription;

    @Column(nullable = false)
    private boolean isVegetarian;
}
