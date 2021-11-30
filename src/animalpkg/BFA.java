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
public class BFA extends Animal {

    boolean heroic;

    public BFA(String ID, String name, AnimalType type, String color, double weight, boolean heroic) {
        super(ID, name, type, color, weight);
        this.heroic = heroic;
    }

    @Override
    public String toString() {
        return "BFA{" + super.toString() + "\n heroic=" + heroic + "}\n";
    }

    @Override
    public String strToFile() {
        return super.strToFile() + ";" + heroic;
    }
}
