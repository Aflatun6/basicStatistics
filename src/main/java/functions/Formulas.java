package functions;

import java.util.List;

public class Formulas {


    public static double getMean(List<Double> numbers) {
        return numbers.stream().mapToDouble(d -> (double) d).average().getAsDouble();
    }

    public static double getStandardDeviation(List<Double> numbers){
        throw new RuntimeException("should be implemented");
    }

    public static double getVariance(List<Double> numbers){
        throw new RuntimeException("should be implemented");
    }

    public static double getZScore(List<Double> numbers){
        throw new RuntimeException("should be implemented");
    }

    public static double getR(List<Double> numbers){
        throw new RuntimeException("should be implemented");
    }

    public static double getRSquare(List<Double> numbers){
        throw new RuntimeException("should be implemented");
    }

    public static double getEquation(List<Double> numbers){
        throw new RuntimeException("should be implemented");
    }


}
