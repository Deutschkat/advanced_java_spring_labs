package platform.codingnomads.co.springdata.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Location;
import platform.codingnomads.co.springdata.lab.models.Route;
import platform.codingnomads.co.springdata.lab.repositories.AreaRepository;
import platform.codingnomads.co.springdata.lab.repositories.LocationRepository;
import platform.codingnomads.co.springdata.lab.repositories.RouteRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataLab implements CommandLineRunner {

    private final AreaRepository areaRepository;
    private final RouteRepository routeRepository;

    private final LocationRepository locationRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataLab.class);
    }

    @Override
    public void run(String... args) throws Exception {


        final List<Area> areas = areaRepository.saveAll(
                Arrays.asList(
                        Area.builder().code("G").build(),
                        Area.builder().code("H").build(),
                        Area.builder().code("Y").build(),
                        Area.builder().code("Z").build(),
                        Area.builder().code("K").build(),
                        Area.builder().code("A").build(),
                        Area.builder().code("T").build(),
                        Area.builder().code("E").build()
                )
        );

            if (routeRepository.count() == 0) {

                // get by code
                Area originArea = areaRepository.findByCode("Y");
                Area destinationArea = areaRepository.findByCode("Z");

                if (originArea != null && destinationArea != null) {
                    // create and persist
                    Route route = Route.builder()
                            .origin(originArea)
                            .destination(destinationArea)
                            .build();

                    route = routeRepository.save(route);

                    // Display the persisted route
                    System.out.println("Persisted Route: " + route);
                } else {System.out.println("Could not find areas with codes 'Y' and 'Z'.");
                }
            } else {System.out.println("Routes already exist in the database.");
            }

        if (locationRepository.count() == 0) {

            // Retrieve areas and routes
            Area area1 = areaRepository.findByCode("G");
            Area area2 = areaRepository.findByCode("H");
            Route route1 = routeRepository.findByCode("Y-Z");
            Route route2 = routeRepository.findByCode("G-H");

            if (area1 != null && area2 != null && route1 != null && route2 != null) {
                // Create and persist locations
                Location location1 = Location.builder()
                        .area(area1)
                        .route(route1)
                        .build();
                locationRepository.save(location1);

                Location location2 = Location.builder()
                        .area(area2)
                        .route(route2)
                        .build();
                locationRepository.save(location2);

                // Display the persisted locations
                System.out.println("Persisted Locations:");
                List<Location> allLocations = locationRepository.findAll();
                allLocations.forEach(location -> System.out.println(location));
            } else {
                System.out.println("One or more areas/routes not found.");
            }
        } else {
            System.out.println("Locations already exist in the database.");
        }

        // retrieve locations
        List<Location> allLocations = locationRepository.findAll();

        // show locations
        System.out.println("All Locations:");
        allLocations.forEach(location -> System.out.println(location));

            // retrieve all areas
            List<Area> allAreas = areaRepository.findAll();

            // display all areas
            System.out.println("All Areas:");
            allAreas.forEach(area -> System.out.println(area));

            // retrieve all routes
            List<Route> allRoutes = routeRepository.findAll();

            // display all routes
            System.out.println("All Routes:");
            allRoutes.forEach(route -> System.out.println(route));

            // retrieve
            Area originArea = areaRepository.findByCode("Y");
            List<Route> routesFromOrigin = routeRepository.findAllByOrigin(originArea);

            Area destinationArea = areaRepository.findByCode("Z");
            List<Route> routesToDestination = routeRepository.findAllByDestination(destinationArea);

            // display
            System.out.println("Routes from origin area:");
            routesFromOrigin.forEach(route -> System.out.println(route));
            System.out.println("Routes to destination area:");
            routesToDestination.forEach(route -> System.out.println(route));


            // retrieve
            String routeCode = "Y-Z";

            Route specificRoute = routeRepository.findByCode(routeCode);

            if (specificRoute != null) {
                System.out.println("Retrieved Route: " + specificRoute);
            } else {System.out.println("Route with code '" + routeCode + "' does not exist.");
            }
        }


    }
