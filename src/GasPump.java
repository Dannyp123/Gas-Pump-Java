import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class GasPump {
    public Double regularPrice = 1.87;
    public Double premiumPrice = 1.98;
    public Double nonEthanolPrice = 2.13;



    private Scanner user = new Scanner(System.in);
    private String fuelType;
    private Double price;
    private Double totalGallons;
    private String paymentType;
    private Integer chances = 3;
    private Double total;


    public void startPumping() {
        System.out.println("\n----Welcome to Danny's Gas Mart----\n");
        System.out.println("Our gas prices are" + " [1]Regular: " + regularPrice + " [2]Premium: " + premiumPrice
        + " [3]Non-Ethanol: " + nonEthanolPrice + "\n");
        whatTypeGas();
        gettingTotalGallons();

    }


    public void getZipCode() {
        System.out.print("Please enter the zipcode for card. ");

        while(chances != 0) {
            Integer zCode = user.nextInt();

            if (Pattern.matches("^[0-9]{5}(?:-[0-9]{4})?$", zCode.toString())) {
                System.out.println("\nProcessing...\n");
                try{
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("Thank you for your payment.\n");
                    receiptChoice();
                    System.exit(0);
                }catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
            }
            else {
                while (chances != 0) {
                    chances--;
                    if (chances == 0) {
                        System.out.println("Sorry transaction canceled.");
                    }else{
                        System.out.println("Please insert a valid zip code!");
                        break;
                    }
                }

            }

        }

    }

    public void receiptChoice() {
        System.out.print("Would you like a receipt [1]Yes or [2]No ");
        int numChoice = user.nextInt();
        if (numChoice == 1) {
            System.out.println("\nPrinting out your receipt...\n");
            Receipt reciept = new Receipt(paymentType, totalGallons, total, fuelType);
            reciept.printingReceipt();


        }
        else {
            System.out.println("\n----Danny's Gas Mart----\n");
            System.out.println("1245 Ash Lane");
            System.out.println("Water Valley, MS ");
            System.out.println("38965\n");
            System.out.println("Thank you have a blessed day!!");
        }
    }


    public void howYouPaying() {
        System.out.print("Are you [1]paying with a card or [2]paying inside? ");
        int payment = user.nextInt();

        if (payment == 1) {
            System.out.println("Please insert your card.\n");
            paymentType = "Paid by card";
            getZipCode();
        }
        else {
            System.out.println("\nGo see the person at the register inside.\n");
            paymentType = "Paid inside";
            receiptChoice();
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
        System.out.print("How much you paying for? $ ");
        double gasAmount = user.nextDouble();

            total = gasAmount;
            totalGallons = total / price;

        System.out.println(String.format("\nYou can get %.0f gallons for $ %s\n", totalGallons , total ));
        howYouPaying();





    }

}
