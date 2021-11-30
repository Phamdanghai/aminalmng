
import animalpkg.AnimalList;
import animalpkg.AnimalTypeList;
import animalpkg.Menu;
import animalpkg.MyScanner;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SE140861
 */
public class AnimalMng {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String fileTypes = "AnimalTypes.txt";
        String fileAnimals = "Animals.txt";
        Menu mainMenu = new Menu("\nManaging animals-Main menu");
        mainMenu.add("Add new animal");
        mainMenu.add("Update animal");
        mainMenu.add("Delete animal");
        mainMenu.add("Search animal");
        mainMenu.add("Show animal list");
        mainMenu.add("Store data to file");
        int mainchoice;
        Menu searchMenu = new Menu("Choose search option:");
        searchMenu.add("Search by name");
        searchMenu.add("Search by type");
        Menu showMenu = new Menu("Choose show option:");
        showMenu.add("Show by type");
        showMenu.add("Show all");
        int subchoice;
        AnimalTypeList typeList = new AnimalTypeList();
        typeList.loadFromFile(fileTypes);
        AnimalList aList = new AnimalList(typeList);
        aList.loadFromFile(fileAnimals);
        boolean changed = false;
        do {
            mainchoice = mainMenu.getUserChoice();
            switch (mainchoice) {
                case 1:
                    aList.add();
                    changed = true;
                    break;
                case 2:
                    aList.update();
                    changed = true;
                    break;
                case 3:
                    aList.delete();
                    changed = true;
                    break;
                case 4:
                    do {
                        subchoice = searchMenu.getUserChoice();
                        switch (subchoice) {
                            case 1:
                                aList.printByName();
                                break;
                            case 2:
                                aList.printByType();
                                break;
                        }
                    } while (subchoice > 0 && subchoice <= searchMenu.size());
                    break;
                case 5:
                    do {
                        subchoice = showMenu.getUserChoice();
                        switch (subchoice) {
                            case 1:
                                aList.printByType();
                                break;
                            case 2:
                                Collections.sort(aList);
                                aList.showAll();
                                break;
                        }
                    } while (subchoice > 0 && subchoice <= searchMenu.size());
                case 6:
                    aList.writeToFile(fileAnimals);
                    changed = false;
                    break;
                default:
                    if (changed) {
                        boolean response = MyScanner.getBoolean("Save changes to file?");
                        if (response == true) {
                            aList.writeToFile(fileAnimals);
                        }
                    }
            }
        } while (mainchoice > 0 && mainchoice <= mainMenu.size());

    }

}
