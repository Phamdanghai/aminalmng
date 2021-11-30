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
public class Animal implements Comparable<Animal> {

    String ID;
    String name;
    AnimalType type;
    String color;
    double weight;

    public Animal(String ID, String name, AnimalType type, String color, double weight) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public int compareTo(Animal o) {
        int d = this.type.typeCode - o.type.typeCode;
        return d < 0 ? -1 : d == 0 ? 0 : 1;
    }

    @Override
    public String toString() {
        return "Animal{" + "ID=" + ID + ", name=" + name + ", type=" + type + ", color=" + color + ", weight=" + weight + '}';
    }

    public String strToFile() {
        return ID + ";" + name + ";" + type.typeCode + ";" + color + ";" + weight;
    }

}
