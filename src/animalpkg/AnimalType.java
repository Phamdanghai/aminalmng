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
public class AnimalType {

    public static final int ZLA = 1, BFLA = 2; // animal type constants
    public static final int BFA = 3, FLA = 4; // animal type constants
    int typeCode;       //type ID
    String desc;        //description
    int numLegs;        //number of swings
    int numSwings;      //number of swings
    String movingMethod;//method for moving
    boolean canFly;     //whether they can fly?
    boolean conSing;    //whether they can sing?
    boolean canGrowl;   //whether they can growl?
    String food;        //what do they eat
    double maxWeight;   //maximum weight

    public AnimalType() {
    }

    public AnimalType(int typeCode, String desc, int numLegs, int numSwings, String movingMethod, boolean canFly, boolean conSing, boolean canGrowl, String food, double maxWeight) {
        this.typeCode = typeCode;
        this.desc = desc;
        this.numLegs = numLegs;
        this.numSwings = numSwings;
        this.movingMethod = movingMethod;
        this.canFly = canFly;
        this.conSing = conSing;
        this.canGrowl = canGrowl;
        this.food = food;
        this.maxWeight = maxWeight;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public int getNumSwings() {
        return numSwings;
    }

    public void setNumSwings(int numSwings) {
        this.numSwings = numSwings;
    }

    public String getMovingMethod() {
        return movingMethod;
    }

    public void setMovingMethod(String movingMethod) {
        this.movingMethod = movingMethod;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public boolean isConSing() {
        return conSing;
    }

    public void setConSing(boolean conSing) {
        this.conSing = conSing;
    }

    public boolean isCanGrowl() {
        return canGrowl;
    }

    public void setCanGrowl(boolean canGrowl) {
        this.canGrowl = canGrowl;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "AnimalType{" + "desc=" + desc + ", numLegs=" + numLegs + ", numSwings=" + numSwings + ", movingMethod=" + movingMethod + ", canFly=" + canFly + ", conSing=" + conSing + ", canGrowl=" + canGrowl + ", food=" + food + ", maxWeight=" + maxWeight + '}';
    }
    
}
