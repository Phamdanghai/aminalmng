/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalpkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author SE140861
 */
public class AnimalList extends ArrayList<Animal> {

    AnimalTypeList typeList;

    public AnimalList(AnimalTypeList typeList) {
        this.typeList = typeList;
    }

    public int search(String ID) {
        ID = ID.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).ID.equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    public boolean loadFromFile(String fName) {
        FileReader fr = null;
        BufferedReader br = null;
        String line = null;
        StringTokenizer stk = null;
        try {
            fr = new FileReader(fName);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.length() > 0) {
                    stk = new StringTokenizer(line, ";");
                    String ID = stk.nextToken();
                    String name = stk.nextToken();
                    int type = Integer.parseInt(stk.nextToken());
                    AnimalType aType = this.typeList.get(typeList.search(type));
                    if (aType == null) {
                        System.out.println("This animal type is not supported!");
                        System.exit(0);
                    }
                    String color = stk.nextToken();
                    double weight = Double.parseDouble(stk.nextToken());
                    String s;
                    Animal animal;
                    switch (type) {
                        case 1:
                            s = stk.nextToken().trim().toUpperCase();
                            boolean poisonous = s.startsWith("T");
                            animal = new ZLA(ID, name, aType, color, weight, poisonous);
                            this.add(animal);
                            break;
                        case 2:
                            s = stk.nextToken().trim().toUpperCase();
                            boolean cute = s.startsWith("F");
                            animal = new BFLA(ID, name, aType, color, weight, cute);
                            this.add(animal);
                            break;
                        case 3:
                            s = stk.nextToken().trim().toUpperCase();
                            boolean heroic = s.startsWith("T");
                            animal = new BFA(ID, name, aType, color, weight, heroic);
                            this.add(animal);
                            break;
                        case 4:
                            s = stk.nextToken().trim().toUpperCase();
                            boolean canGrowl = s.startsWith("T");
                            s = stk.nextToken().trim().toUpperCase();
                            boolean danger = s.startsWith("T");
                            animal = new FLA(ID, name, aType, color, weight, canGrowl, danger);
                            this.add(animal);
                            break;
                    }
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean writeToFile(String fName) {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(fName);
            pw = new PrintWriter(fw);
            for (int i = 0; i < this.size(); i++) {
                pw.println(this.get(i).strToFile());
            }
            pw.flush();
            System.out.println("Writing file: DONE. ");
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public void add() {
        String ID;
        String name;
        AnimalType type;
        String color;
        double weight;
        boolean duplicated;
        do {
            ID = MyScanner.getNonBlankStr("Input it's ID");
            ID = ID.trim().toUpperCase();
            duplicated = (this.search(ID) >= 0);
            if (duplicated) {
                System.out.println("ID is duplicated!");
            }
        } while (duplicated);
        name = MyScanner.getNonBlankStr("Input name");
        type = this.typeList.chooseType();
        color = MyScanner.getNonBlankStr("Input color");
        weight = MyScanner.getDouble("Input weight", type.maxWeight);
        Animal newAnimal = null;
        int intType = type.typeCode;
        switch (intType) {
            case AnimalType.ZLA:
                boolean poison = MyScanner.getBoolean("Is it poisionous?");
                newAnimal = new ZLA(ID, name, type, color, weight, poison);
                break;
            case AnimalType.BFLA:
                boolean cute = MyScanner.getBoolean("Is it cute?");
                newAnimal = new BFLA(ID, name, type, color, weight, cute);
                break;
            case AnimalType.BFA:
                boolean heroic = MyScanner.getBoolean("Is it heroic?");
                newAnimal = new BFA(ID, name, type, color, weight, heroic);
                break;
            case AnimalType.FLA:
                boolean canGrowl = MyScanner.getBoolean("Is it canGrowl?");
                boolean danger = MyScanner.getBoolean("Is it danger");
                newAnimal = new FLA(ID, name, type, color, weight, canGrowl, danger);
                break;
            default:
                System.out.println("This animal type is not supported! ");
        }

        if (newAnimal != null) {
            this.add(newAnimal);
            System.out.println("Add operation is successful.");
        }
    }

    public void update() {
        String ID;
        ID = MyScanner.getNonBlankStr("Input ID ");
        int pos = this.search(ID);
        if (pos < 0) {
            System.out.println("Animal " + ID + " does not exist!");
        } else {
            remove(pos);
            System.out.println("Input new derails:");
            add();
        }

    }

    public void delete() {
        String ID;
        ID = MyScanner.getNonBlankStr("Input ID ");
        int pos = this.search(ID);
        if (pos < 0) {
            System.out.println("Animal " + ID + " does not exist!");
        } else {
            remove(pos);
            System.out.println("The animal" + ID + " has been delete.");
        }
    }

    public void printByName() {
        String chosenName;
        chosenName = MyScanner.getNonBlankStr("Input chosen Name");
        chosenName = chosenName.toUpperCase();
        System.out.println("Result:");
        int count = 0;
        for (Animal a : this) {
            if (a.name.equalsIgnoreCase(chosenName)) {
                System.out.println(a);
                count++;
            }
        }
//        for (Animal a : this) {
//            if (a.name.indexOf(chosenName) >= 0) {
//                System.out.println(a);
//                count++;
//            }
//        }
        if (count > 0) {
            System.out.println(count + " animals.");
        } else {
            System.out.println("No result is found.");
        }
    }

    public void printByType() {
        int chosenType;
        int maxType = this.typeList.size();
        chosenType = MyScanner.getInt("Input animal type:", 1, maxType);
        System.out.println("Result:");
        int count = 0;
        for (Animal a : this) {
            if (a.type.typeCode == chosenType) {
                System.out.println(a);
                count++;
            }
        }
        if (count > 0) {
            System.out.println(count + " animal.");
        } else {
            System.out.println("No result is found.");
        }
    }

    public void showAll() {
        if (this.isEmpty()) {
            System.out.println("The animal list is emty.");
        } else {
            for (Animal a : this) {
                System.out.println(a);
            }
        }
    }
}
