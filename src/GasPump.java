import java.util.Scanner;

public class GasPump {
    private Double regularPrice = 1.87;
    private Double premiumPrice = 1.98;
    private Double nonEthanolPrice = 2.13;


    private Scanner user = new Scanner(System.in);
    private String fuelType;
    private Double price;
    private Double totalGallons;
    private String paymentType;


    public void startPumping() {
        System.out.println("----Welcome to Danny's Gas Mart----");
        System.out.println("Our gas prices are" + " [1]Regular: " + regularPrice + " [2]Premium: " + premiumPrice
        + " [3]Non-Ethanol: " + nonEthanolPrice + "\n");
        whatTypeGas();
        gettingTotalGallons();

    }

    public void howYouPaying() {
        System.out.print("Are you [1]paying with a card or [2]paying inside? ");
        int payment = user.nextInt();
    }


    public void whatTypeGas() {

        System.out.print("What type of gas would you like ");
        int gasType = user.nextInt();
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

    public void gettingTotalGallons() {
        System.out.print("How much you paying for? ");
        double total = user.nextDouble();

        if (fuelType.equals("Regular")) {
            totalGallons = total / price;
        }
        else if (fuelType.equals("Premium")) {
            totalGallons = total / price;
        }
        else {
            totalGallons = total / price;
        }
        System.out.println(String.format("You can get %.2f gallons for $ %s", totalGallons , total ));





    }

}
