package machine;

public class Main {
    public static void main(String[] args) {
        StateOfMachine stateOfMachine = StateOfMachine.CHOOSING_AN_ACTION;
        choosingAction();
    }

    public static void choosingAction() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String action = CoffeeMachine.scanner.next();
        CoffeeMachine.checkingTheSelectedAction(action);
    }
}
