package platform.codingnomads.co.springdata.example.ddl.joincolumn;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "example_tags",
            joinColumns = @JoinColumn(name = "example_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )


    // Had to google this part... it may be wrong...?
    private Set<Example> examples = new HashSet<>();
}
