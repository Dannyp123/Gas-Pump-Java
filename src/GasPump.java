import java.util.Scanner;
import java.util.regex.Pattern;

public class GasPump {
    private Double regularPrice = 1.87;
    private Double premiumPrice = 1.98;
    private Double nonEthanolPrice = 2.13;


    private Scanner user = new Scanner(System.in);
    private String fuelType;
    private Double price;
    private Double totalGallons;
    private String paymentType;
    private Integer lives = 3;


    public void startPumping() {
        System.out.println("----Welcome to Danny's Gas Mart----");
        System.out.println("Our gas prices are" + " [1]Regular: " + regularPrice + " [2]Premium: " + premiumPrice
        + " [3]Non-Ethanol: " + nonEthanolPrice + "\n");
        whatTypeGas();
        gettingTotalGallons();

    }

    public void getZipCode() {
        System.out.print("Please enter the zipcode for card. ");

        while(lives != 0) {
            Integer zCode = user.nextInt();

            if (Pattern.matches("^[0-9]{5}(?:-[0-9]{4})?$", zCode.toString())) {
                System.out.println("Processing...");
                System.out.println("Thank you for your payment.");
                receiptChoice();
                System.exit(0);
            }
            else {
                System.out.println("Please insert a valid zip code!");
                lives--;
                if (lives.equals(0)) {
                    System.out.println("Sorry transaction canceled.");
                }
            }

        }

    }



    public void receiptChoice() {
        System.out.println("Would you like a receipt [1]Yes or [2]No");
        int receipt = user.nextInt();
        if (receipt == 1) {
            System.out.println("Printing out your receipt...");

        }
        else {
            System.out.println("Thank you have a blessed day!!");
        }
    }

    public void howYouPaying() {
        System.out.print("Are you [1]paying with a card or [2]paying inside? ");
        int payment = user.nextInt();

        if (payment == 1) {
            System.out.println("Please insert your card. ");
            paymentType = "Pay by card";
            getZipCode();
        }
        else {
            System.out.println("Go see the person at the register inside.");
            paymentType = "Pay inside";
        }
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
        howYouPaying();





    }

}
