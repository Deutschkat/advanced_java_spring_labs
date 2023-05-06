package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "insurance")
@Getter
@Setter
@NoArgsConstructor
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String policyNum;

    @OneToOne
    private Car car;

    public Insurance(String policyNum){
        this.policyNum = policyNum;
    }

}
