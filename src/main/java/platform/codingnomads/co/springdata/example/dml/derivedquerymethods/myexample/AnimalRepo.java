package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepo extends JpaRepository<Animal, Long> {

    List<Animal> findByAnimalDietIsVegetarian(boolean isVegetarian);

    List<Animal> findByGenus(String genus);

    List<Animal> findByAnimalDietClassification(String dietClassification);

    List<Animal> findByAnimalDietClassificationAndGenus(String dietClassification, String genus);

    List<Animal> findByAnimalDietId(Long dietId);

    List<Animal> findByAnimalName(String animalName);

    List<Animal> findByAnimalDietIsVegetarianTrue();

    List<Animal> findByAnimalDietIsVegetarianFalse();

    List<Animal> findByAnimalDietDietClassificationNot(String dietClassification);

    List<Animal> findByAnimalDietIsVegetarianAndGenus(boolean isVegetarian, String genus);

}
