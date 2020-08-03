import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hug.
 */
public class Experiments {

    public static void experiment1() {
        BST bst = new BST();
        Random rand = new Random();

        List<Integer> numberOfItems = new ArrayList<>();
        List<Double> myAverageDepth = new ArrayList<>();
        List<Double> optimalAverageDepth = new ArrayList<>();

        for (int i = 1; i <= 5000; i += 1) {
            bst.add(RandomGenerator.getRandomInt(10000));
            numberOfItems.add(i);
            myAverageDepth.add(bst.averageDepth());
            optimalAverageDepth.add(ExperimentHelper.optimalAverageDepth(i));
        }

        XYChart chart = new XYChartBuilder().width(800).height(600).
                xAxisTitle("Number of items").yAxisTitle("Average depth").build();
        chart.addSeries("My BST", numberOfItems, myAverageDepth);
        chart.addSeries("Optimal BST", numberOfItems, optimalAverageDepth);

        new SwingWrapper<>(chart).displayChart();
    }

    public static void experiment2() {
        BST bst = new BST();

        List<Integer> numberOfOperations = new ArrayList<>();
        List<Double> myAverageDepth = new ArrayList<>();

        for (int i = 1; i <= 5000; i += 1) {
            bst.add(RandomGenerator.getRandomInt(10000));
        }

        for (int i = 1; i <= 50000; i += 1) {
            numberOfOperations.add(i);
            bst.deleteTakingSuccessor(bst.getRandomKey());
            ExperimentHelper.addInt(bst);
            myAverageDepth.add(bst.averageDepth());
        }

        XYChart chart = new XYChartBuilder().width(1200).height(600).
                xAxisTitle("Number of operations").yAxisTitle("Average depth").build();
        chart.addSeries("My BST", numberOfOperations, myAverageDepth);

        new SwingWrapper<>(chart).displayChart();
    }

    public static void experiment3() {
        BST bst = new BST();

        List<Integer> numberOfOperations = new ArrayList<>();
        List<Double> myAverageDepth = new ArrayList<>();

        for (int i = 1; i <= 5000; i += 1) {
            bst.add(RandomGenerator.getRandomInt(10000));
        }

        for (int i = 1; i <= 50000; i += 1) {
            numberOfOperations.add(i);
            bst.deleteTakingRandom(bst.getRandomKey());
            ExperimentHelper.addInt(bst);
            myAverageDepth.add(bst.averageDepth());
        }

        XYChart chart = new XYChartBuilder().width(1200).height(600).
                xAxisTitle("Number of operations").yAxisTitle("Average depth").build();
        chart.addSeries("My BST", numberOfOperations, myAverageDepth);

        new SwingWrapper<>(chart).displayChart();
    }

    public static void main(String[] args) {
        // experiment1();
         experiment2();
        // experiment3();
    }
}
