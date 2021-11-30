/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalpkg;

/**
 *
 * @author SE140861
 */
public class FLA extends Animal {

    boolean canGrowl;
    boolean danger;

    public FLA(String ID, String name,AnimalType type, String color, double weight,  boolean canGrowl, boolean danger) {
        super(ID, name, type, color, weight);
        this.canGrowl = canGrowl;
        this.danger = danger;
    }

    @Override
    public String toString() {
        return "FLA{" + super.toString() + "\n canGrowl=" + canGrowl + "\n danger=" + danger + "}\n";
    }

    @Override
    public String strToFile() {
        return super.strToFile() + ";" + canGrowl + ";" + danger;
    }
}
