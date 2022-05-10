import java.util.Scanner;

class ManufacturingController {
    public static int countProduct;

    public static String requestProduct(String product) {

        return String.format(++countProduct + ". Requested %s", product);
    }

    public static int getNumberOfProducts() {
        return countProduct;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String product = scanner.nextLine();
            System.out.println(ManufacturingController.requestProduct(product));
            System.out.println(ManufacturingController.getNumberOfProducts());
        }
    }
}