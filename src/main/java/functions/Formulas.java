package functions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Formulas {


    public static double getMean(List<Double> numbers) {
        return numbers.stream().mapToDouble(d -> d).average().getAsDouble();
    }

    public static double getMedian(List<Double> numbers) {
        int size = numbers.size();
        List<Double> sorted = numbers.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        return size % 2 != 0
                ? sorted.get(size / 2)
                : (sorted.get(size / 2 - 1) + sorted.get(size / 2)) / 2;

    }

    public static double getMode(List<Double> numbers) {
        List<Double> sorted = numbers.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        double theMode = sorted.get(0);
        int count = 0;
        int max = count;
        double previous = sorted.get(0);
//        1, 2 , 3 , 3 , 4 , 4 , 6
        for (double d: sorted){
            if (d == previous) {
                count++;
            }
            else {
                count = 1;
                previous = d;
            }

            if(count > max){
                theMode = previous;
                max = count;
            }

        }

        return theMode;
    }

    public static double getVariance(List<Double> numbers) {

        double mean = getMean(numbers);
        double sum = 0d;

        for (double d : numbers) {
            sum += Math.pow(2, (d - mean));
        }

        return sum / numbers.size() - 1;

    }


    public static double getStandardDeviation(List<Double> numbers) {
        return Math.sqrt(getVariance(numbers));
    }

    public static List<Double> getZScore(List<Double> numbers) {
        double mean = getMean(numbers);
        double standardDeviation = getStandardDeviation(numbers);
        return numbers.stream().map(d -> (d - mean) / standardDeviation).collect(Collectors.toList());

    }

    public static double getR(List<Double> x, List<Double> y) {
        List<Double> xZ = getZScore(x);
        List<Double> yZ = getZScore(y);
        int size = x.size();

        double sum = 0d;

        for (int i = 0; i < size; i++) {
            sum += xZ.get(i) * yZ.get(i);
        }

        return sum / size - 1;

    }

    public static double getRSquare(List<Double> x, List<Double> y) {
        return Math.pow(2, getR(x, y));
    }

    public static String getEquation(List<Double> x, List<Double> y) {
        return getEquation(x, y, 2);
    }

    public static String getEquation(List<Double> x, List<Double> y, int precision) {

        double meanX = getMean(x);
        double meanY = getMean(y);
        double sdX = getStandardDeviation(x);
        double sdY = getStandardDeviation(y);
        double R = getR(x, y);

        double b = R * (sdY / sdX);
        double a = meanY - b * meanX;

        return constructExpressionString(a, b, precision);

    }

    public static String constructExpressionString(double a, double b, int precision) {
        String string = "y` = %." + precision + "f + %." + precision + "f * x";
        return String.format(string, a, b);
    }


}
