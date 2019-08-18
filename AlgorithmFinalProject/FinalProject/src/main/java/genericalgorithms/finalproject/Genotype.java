/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericalgorithms.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vinya
 */
public class Genotype implements Comparable<Genotype>{

    private String[] representation;
    private TraversalPath phenotype;


    public Genotype(int memberId) {
        this.phenotype = new TraversalPath(memberId);
    }
    public Genotype(int genotypeLength, int memberId) {
        this.representation = new String[genotypeLength];
        this.phenotype = new TraversalPath(memberId);
    }

    public TraversalPath getPhenotype() {
        return phenotype;
    }

    public void setPhenotype(TraversalPath phenotype) {
        this.phenotype = phenotype;
    }

    public String[] getRepresentation() {
        return representation;
    }

    public void setRepresentation(String[] representation) {
        this.representation = representation;
    }

    public void generatePhenotype(Genotype gt, List<City> baseOrder) {

        List<City>newOrder= new ArrayList<City>();
//        representation=gt.getRepresentation();
          for(String s:gt.getRepresentation()){
              
             City e= baseOrder.get(Integer.parseInt(s,2));
//             System.out.println(e.getName());
              newOrder.add(e);
                  
              }

           gt.getPhenotype().setTraversalPath(newOrder);
           gt.getPhenotype().computeFitnessScore();
          }


    
    //compare Genotype
    public int compareTo(Genotype gt) {
        
        if(gt.getPhenotype().getFitnessScore() < this.phenotype.getFitnessScore())return 1;
        else if(gt.getPhenotype().getFitnessScore() == this.phenotype.getFitnessScore())return 0;
        else return -1;
    }
    
}
