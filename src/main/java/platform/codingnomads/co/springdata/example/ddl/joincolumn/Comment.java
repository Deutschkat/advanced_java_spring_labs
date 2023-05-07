package platform.codingnomads.co.springdata.example.ddl.joincolumn;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")

public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "example_id", referencedColumnName = "id")
    private Example example;



}
