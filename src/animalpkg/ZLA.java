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
public class ZLA extends Animal {

    boolean poisonous;

    public ZLA(String ID, String name, AnimalType type, String color, double weight, boolean poisonous) {
        super(ID, name, type, color, weight);
        this.poisonous = poisonous;
    }

    @Override
    public String toString() {
        return "ZLA{" + super.toString() + "\n poisonous=" + poisonous + "}\n";
    }

    @Override
    public String strToFile() {
        return super.strToFile() + ";" + poisonous;
    }

}
