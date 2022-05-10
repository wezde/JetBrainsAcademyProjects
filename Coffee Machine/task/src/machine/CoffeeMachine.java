package machine;

import java.util.*;

public class CoffeeMachine {

    public static Scanner scanner = new Scanner(System.in);
    public static int amountOfWater = 400;
    public static int amountOfMilk = 540;
    public static int amountOfCoffeeBeans = 120;
    public static int disposableCups = 9;
    public static int amountOfMoney = 550;
    public static StateOfMachine stateOfMachine;

    public static void initialization() {
        System.out.printf("\nThe coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n", amountOfWater, amountOfMilk, amountOfCoffeeBeans, disposableCups, amountOfMoney);
    }

    public static void checkingTheSelectedAction(String action) {
        switch (action) {
            case "buy":
                stateOfMachine = StateOfMachine.CHOOSING_A_VARIANT_OF_COFFEE;
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String choiceOfDrink = scanner.next();
                makeACoffee(choiceOfDrink);
                Main.choosingAction();
                break;
            case "fill":
                stateOfMachine = StateOfMachine.FILLING_COFFEE_MACHINE;
                fill();
                Main.choosingAction();
                break;
            case "take":
                stateOfMachine = StateOfMachine.TAKING;
                take();
                Main.choosingAction();
                break;
            case "remaining":
                initialization();
                Main.choosingAction();
                break;
            case "exit":
                break;
        }
    }

    public static void makeACoffee(String choiceOfDrink) {
        switch (choiceOfDrink) {
            case "1":
                if (amountOfWater >= 250 && amountOfCoffeeBeans >= 16) {
                    amountOfWater -= 250;
                    amountOfCoffeeBeans -= 16;
                    amountOfMoney += 4;
                    disposableCups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (amountOfWater < 250 && amountOfCoffeeBeans >= 16) {
                    System.out.println("Sorry, not enough water!");
                } else if (amountOfWater >= 250 && amountOfCoffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                break;
            case "2":
                if (amountOfWater >= 350 && amountOfMilk >= 75 && amountOfCoffeeBeans >= 20) {
                    amountOfWater -= 350;
                    amountOfMilk -= 75;
                    amountOfCoffeeBeans -= 20;
                    amountOfMoney += 7;
                    disposableCups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (amountOfWater < 350 && amountOfMilk >= 75 && amountOfCoffeeBeans >= 20) {
                    System.out.println("Sorry, not enough water!");
                } else if (amountOfWater >= 350 && amountOfMilk < 75 && amountOfCoffeeBeans >= 20) {
                    System.out.println("Sorry, not enough milk!");
                } else if (amountOfWater >= 350 && amountOfMilk >= 75 && amountOfCoffeeBeans < 20)
                    System.out.println("Sorry, not enough coffee beans!");
                break;
            case "3":
                if (amountOfWater >= 200 && amountOfMilk >= 100 && amountOfCoffeeBeans >= 12) {
                    amountOfWater -= 200;
                    amountOfMilk -= 100;
                    amountOfCoffeeBeans -= 12;
                    amountOfMoney += 6;
                    disposableCups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if (amountOfWater < 200 && amountOfMilk >= 100 && amountOfCoffeeBeans >= 12) {
                    System.out.println("Sorry, not enough water!");
                } else if (amountOfWater >= 200 && amountOfMilk < 100 && amountOfCoffeeBeans >= 12) {
                    System.out.println("Sorry, not enough milk!");
                } else if (amountOfWater >= 200 && amountOfMilk >= 100 && amountOfCoffeeBeans < 12)
                    System.out.println("Sorry, not enough coffee beans!");
                break;
            case "back":
                return;
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        amountOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        amountOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        amountOfCoffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        disposableCups += scanner.nextInt();
    }

    public static void take() {
        System.out.printf("I gave you $%d\n", amountOfMoney);
        amountOfMoney -= amountOfMoney;
    }
}
