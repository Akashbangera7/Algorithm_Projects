package genericalgorithms.finalproject;



import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 *
 * @author vinya
 */
public class Driver {

    public static void main(String[] args) {
        String[] bag = {"A", "B"};
        int phenoTypeLength = 4;
        int populationSize = 10;
        int genoTypeLength = 8;


        List<City> baseOrder = getBaseOrder(phenoTypeLength);
        Population population = new Population(0.1, baseOrder);
        population.initPopulation(populationSize,
                genoTypeLength,phenoTypeLength);
        population.sortPopulation();
        System.out.println("Generation 0"  + " fitness score :" + population.getGtList().get(0).getPhenotype().toString());
        
        IntStream.range(1,11)
                .forEach(generationNo -> {
                    population.regenerationAndCulling();
                    population.sortPopulation();
                    System.out.println("Generation " +generationNo  + " fitness score :" + population.getGtList().get(0).getPhenotype().toString());
                });







    }

    public static List<City> getBaseOrder(int phenoTypeLength) {
        Random r = new Random();
        double min = -100;
        double max = 100;
        return IntStream.range(0, phenoTypeLength)
                .mapToObj(index -> {
                    double x = ThreadLocalRandom.current().nextDouble(min, max + 1);
                    double y = ThreadLocalRandom.current().nextDouble(min, max + 1);

                    City city = new City(x, y, "City"+index , index);
                    return city;
                }).collect(Collectors.toList());

    }

}
