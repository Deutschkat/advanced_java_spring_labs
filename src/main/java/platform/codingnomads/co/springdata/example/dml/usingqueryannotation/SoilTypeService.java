package platform.codingnomads.co.springdata.example.dml.usingqueryannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.models.SoilType;
import platform.codingnomads.co.springdata.example.dml.usingqueryannotation.repositories.SoilTypeRepo;

import java.util.List;

@Service
public class SoilTypeService {

    @Autowired
    private SoilTypeRepo soilTypeRepo;

    public void printSoilTypes() {
        System.out.println("All soil types with a pH greater than 7.0:");
        List<SoilType> soilTypes = soilTypeRepo.getSoilTypesWithPhGreaterThan(7.0);
        soilTypes.forEach(soilType -> System.out.println(soilType.getName()));

        System.out.println("Number of dry soil types: " + soilTypeRepo.countSoilTypesByDry(true));

        System.out.println("Soil type with name 'Nutrient Dense': " + soilTypeRepo.getSoilTypeByName("Nutrient Dense"));

        System.out.println("Soil types with associated plants:");
        soilTypeRepo.getSoilTypesWithPlants().forEach(soilType -> System.out.println(soilType.getName()));

        System.out.println("Soil types with a pH between 6.0 and 7.5:");
        soilTypeRepo.getSoilTypesByPhRange(6.0, 7.5).forEach(soilType -> System.out.println(soilType.getName()));
    }
}