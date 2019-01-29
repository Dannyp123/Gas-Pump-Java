import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class GasPump {

    private Scanner user = new Scanner(System.in);
    private String fuelType;
    private Double price;
    private Double totalGallons;
    private String paymentType;
    private Integer chances = 3;
    private Double total;
    private List<Gas> gasChoices = new ArrayList<>();


    public void startPumping() {
        System.out.println("\n----Welcome to Danny's Gas Mart----\n");
        gettingGasPrices();
        whatTypeGas();
        gettingTotalGallons();

    }

    public void gettingGasPrices() {
        int count = 0;

        gasChoices.add(new Gas("Regular", 1.87));
        gasChoices.add(new Gas("Premium", 1.98));
        gasChoices.add(new Gas("Non-Ethanol", 2.13));



        for(var gas  : gasChoices) {
            count ++;
            System.out.println(String.format("[%s]" + gas.name + " : " + gas.price, count) + "\n");
        }
    }

    public Double getGasPrice(String gasName) {
        Double gasChoicePrice = null;
        for (var gasChoice : gasChoices) {
            if (gasChoice.name == gasName) {
                gasChoicePrice = gasChoice.price;
            }
        }
        return gasChoicePrice;
    }

    public void pauseTime() {
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }


    public void getZipCode() {
        System.out.print("Please enter the zipcode for card. ");

        while(chances != 0) {
            Integer zCode = user.nextInt();

            if (Pattern.matches("^[0-9]{5}(?:-[0-9]{4})?$", zCode.toString())) {
                System.out.println("\nProcessing...\n");
                pauseTime();
                System.out.println("Thank you for your payment.\n");
                receiptChoice();

            }
            else {
                while (chances != 0) {
                    chances--;
                    if (chances == 0) {
                        System.out.println("\nPlease wait....\n");
                        pauseTime();
                        System.out.println("Sorry transaction canceled.\n");
                        System.exit(0);
                    }else{
                        System.out.println("\nPlease insert a valid zip code!\n");
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
            pauseTime();
            Receipt reciept = new Receipt(paymentType, totalGallons, total, fuelType);
            ReceiptSaving.loggingGasReceipts(reciept);
            reciept.printingReceipt();


        }
        else {
            System.out.println("\n----Danny's Gas Mart----\n");
            System.out.println("1245 Ash Lane");
            System.out.println("Water Valley, MS ");
            System.out.println("38965\n");
            System.out.println("Thank you have a blessed day!!");
            System.exit(0);
        }
    }


    public void howAreYouPaying() {
        boolean statementPay = true;
        while (statementPay){
            System.out.print("Are you [1]paying with a card or [2]paying inside? ");
            int payment = user.nextInt();

            if (payment == 1) {
                System.out.println("\nPlease insert your card.\n");
                paymentType = "Paid by card";
                getZipCode();
            }
            else if (payment == 2){
                System.out.println("\nGo see the person at the register inside.\n");
                paymentType = "Paid inside";
                receiptChoice();
            }
            else {
                System.out.println("\nI AM CALLING THE POLICE..LEAVE\n");
                pauseTime();
                System.exit(0);
            }
        }

    }



    public void whatTypeGas() {
        boolean statement = true;
        while (statement) {
            System.out.print("What type of gas would you like ");
            int gasType = user.nextInt();
            if (gasType == 1) {
                fuelType = "Regular";
                price = getGasPrice("Regular");
                statement = false;
            }
            else if (gasType == 2) {
                fuelType = "Premium";
                price = getGasPrice("Premium");
                statement = false;

            }
            else if (gasType == 3){
                fuelType = "Non-Ethanol";
                price = getGasPrice("Non-Ethanol");
                statement = false;

            }
            else {
                System.out.println("\nSorry not a gas type!\n");
            }
        }

    }

    public void gettingTotalGallons() {
        System.out.print("How much you paying for? $ ");
        double gasAmount = user.nextDouble();

            total = gasAmount;
            totalGallons = total / price;

        System.out.println(String.format("\nYou can get %.0f gallons for $ %s\n", totalGallons , total ));
        howAreYouPaying();

    }


}
