package platform.codingnomads.co.springdata.lab.models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "locations")
@Builder
@ToString
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "area_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_locations_area_id")
    )
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "route_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_locations_route_id")
    )
    private Route route;
}
