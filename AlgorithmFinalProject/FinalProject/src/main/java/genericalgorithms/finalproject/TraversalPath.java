/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericalgorithms.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 *
 * @author vinya
 */
public class TraversalPath {

    private int memberId;
    private List<City> traversalPath;
    private double distance;
    private double fitnessScore;

    public TraversalPath(int memberId) {
        this.memberId = memberId;
        this.traversalPath = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public TraversalPath(List<City> traversalOrder) {
        this.traversalPath = traversalOrder;
    }

    public List<City> getTraversalPath() {
        return traversalPath;
    }

    public void setTraversalPath(List<City> traversalPath) {
        this.traversalPath = traversalPath;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getFitnessScore() {
        return fitnessScore;
    }

    public void setFitnessScore(double fitnessScore) {
        this.fitnessScore = fitnessScore;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<Order " + this.memberId + " : ");

        for (int i = 0; i < this.traversalPath.size(); i++) {
            builder.append(this.traversalPath.get(i).toString());
            if (i != this.traversalPath.size() - 1) {
                builder.append("->");
            }
        }

        builder.append(">");
        builder.append("< distance : " + this.distance + ">");
        builder.append("< fitness score : " + this.fitnessScore + ">");

        return builder.toString();
    }

    public void computeFitnessScore() {

        double sum = 0.0;
        for (int i = 0; i <= traversalPath.size()-1 ; i++) {
            this.distance = computeDistance(i);
//            System.out.println("distance"+distance);
            sum += distance;
//            System.out.println("sum"+sum);
        }
        this.fitnessScore = 1 / sum;
//                this.distance = IntStream.range(0, this.traversalPath.size() - 1)
//                .mapToDouble(iter -> computeDistance(iter))
//                .sum();
//
//        this.fitnessScore = 1 / this.distance;
        //System.out.println("Genotype :" + this.memberId + " has fitness score :" + this.fitnessScore);

    }

    public double computeDistance(int i) {

        City first = this.traversalPath.get(i);
        
        City second = null;
        if (i != this.traversalPath.size() - 1) {

            second = this.traversalPath.get(i + 1);

        } else {
            second = this.traversalPath.get(0);
        }
//        System.out.println("city"+first);
//        System.out.println("city"+second);
        double distance = cityWiseDistance(first, second);
//        System.out.println(distance);
        return distance;
    }

    public double cityWiseDistance(City first, City second) {
        return Math.sqrt(Math.pow(first.getxCoordinate() - second.getxCoordinate(), 2) + Math.pow(first.getyCoordinate() - second.getyCoordinate(), 2));
    }

}
