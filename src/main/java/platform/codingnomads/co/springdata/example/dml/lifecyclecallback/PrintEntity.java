package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @PrePersist
    public void beforePersist() {
        System.out.println("Before persisting: " + name);
    }

    @PostPersist
    public void onPersist() {
        System.out.println("Persisted: " + name);
    }

    @PreUpdate
    public void beforeUpdate() {
        System.out.println("Before updating: " + name);
    }

    @PostUpdate
    public void onUpdate() {
        System.out.println("Updated: " + name);
    }

    @PreRemove
    public void beforeRemove() {
        System.out.println("Before removing: " + name);
    }

    @PostRemove
    public void onRemove() {
        System.out.println("Removed: " + name);
    }

}
