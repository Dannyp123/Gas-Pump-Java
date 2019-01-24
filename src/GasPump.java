import java.util.Scanner;

public class GasPump {
    private Double regularPrice = 1.87;
    private Double premiumPrice = 1.98;
    private Double nonEthanolPrice = 2.13;

    private String fuelType;
    private Double price;
    private Double totalGallons;


    public void welcome() {
        System.out.println("----Welcome to Danny's Gas Mart----");
        System.out.println("Our gas prices are" + " [1]Regular: " + regularPrice + " [2]Premium: " + premiumPrice
        + " [3]Non-Ethanol: " + nonEthanolPrice );
        whatTypeGas();
        gettingTotalGallons();

    }
    public void whatTypeGas() {
        Scanner reader = new Scanner(System.in);
        System.out.print("What type of gas would you like");
        int gasType = reader.nextInt();
        if (gasType == 1) {
            fuelType = "Regular";
            price = regularPrice;
        }
        else if (gasType == 2) {
            fuelType = "Premium";
            price = premiumPrice;
        }
        else {
            fuelType = "Non-Ethanol";
            price = nonEthanolPrice;
        }
    }

//    public Double gasPricing(int gasType) {
//        if (gasType == 1) {
//            return 1.87;
//        }
//        else if (gasType == 2) {
//            return 1.98;
//        }
//        else {
//            return 2.13;
//        }
//
//    }
    public void gettingTotalGallons() {
        Scanner reader = new Scanner(System.in);
        System.out.println("How much you paying for? ");
        double total = reader.nextDouble();

        if (fuelType.equals("Regular")) {
            totalGallons = total / price;
        }
        else if (fuelType.equals("Premium")) {
            totalGallons = total / price;
        }
        else {
            totalGallons = total / price;
        }
        System.out.println(String.format("You can get %.8f gallons for $ %s", totalGallons , total ));





    }

}
