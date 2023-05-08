package platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;

import java.util.List;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {

    //get all soil types with a pH greater than the given value
    @Query("SELECT st FROM SoilType st WHERE st.ph > ?1")
    List<SoilType> getSoilTypesWithPhGreaterThan(double ph);

    //get the number of soil types with a dry state equal to the given value
    @Query("SELECT COUNT(st) FROM SoilType st WHERE st.dry = ?1")
    Long countSoilTypesByDry(boolean dry);

    //get the soil type with the given name
    @Query("SELECT st FROM SoilType st WHERE st.name = :name")
    SoilType getSoilTypeByName(@Param("name") String name);

    //get the soil types that have plants associated with them
    @Query("SELECT DISTINCT p.favoriteSoilType FROM Plant p WHERE p.favoriteSoilType IS NOT NULL")
    List<SoilType> getSoilTypesWithPlants();

    //get the soil types with a given pH range
    @Query("SELECT st FROM SoilType st WHERE st.ph >= :minPh AND st.ph <= :maxPh")
    List<SoilType> getSoilTypesByPhRange(@Param("minPh") double minPh, @Param("maxPh") double maxPh);

}


