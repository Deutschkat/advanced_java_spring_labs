package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AnimalApplication implements CommandLineRunner {

    @Autowired
    AnimalRepo animalRepo;

    public static void main(String[] args) {
        SpringApplication.run(AnimalApplication.class);
    }

    @Override
    public void run(String... args) throws Exception{
        Diet carnivore = Diet.builder().classification("carnivore").isVegetarian(false).dietDescription("meat and fish").build();
        Diet omnivore = Diet.builder().classification("omnivore").isVegetarian(false).dietDescription("vegetation, fruits, and meat").build();
        Diet herbivore = Diet.builder().classification("herbivore").isVegetarian(true).dietDescription("plants and/or vegetation").build();

        Animal lion = Animal.builder()
                .animalName("Lion")
                .animalDiet(carnivore)
                .genus("Panthera")
                .build();

        Animal leopardSeal = Animal.builder()
                .animalName("Leopard Seal")
                .animalDiet(carnivore)
                .genus("Hydrurga")
                .build();

        Animal rhino = Animal.builder()
                .animalName("White Rhinoceros")
                .animalDiet(herbivore)
                .genus("Ceratotherium")
                .build();

        Animal raccoon = Animal.builder()
                .animalName("Raccoon")
                .animalDiet(omnivore)
                .genus("Procyon")
                .build();

        animalRepo.save(lion);
        animalRepo.save(leopardSeal);
        animalRepo.save(rhino);
        animalRepo.save(raccoon);

        System.out.println("\n ******* findByIsVegetarian() ******* ");
        List<Animal> animals1 = animalRepo.findByAnimalDietIsVegetarian(false);
        animals1.forEach(System.out::println);

        System.out.println("\n ******* findByGenus *******");
        List<Animal> animals2 = animalRepo.findByGenus("Panthera");
        animals2.forEach(System.out::println);

        System.out.println("\n ******* findByAnimal_DietClassification *******");
        List<Animal> animals3 = animalRepo.findByAnimalDietClassification("omnivore");
        animals3.forEach(System.out::println);

        System.out.println("\n *******       *******");
        List<Animal> animals4 = animalRepo.findByName("White Rhinoceros");
        animals4.forEach(System.out::println);














    }

}
