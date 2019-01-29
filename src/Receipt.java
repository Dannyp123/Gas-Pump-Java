import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt implements Serializable {
    private Double totalGallons;
    private Double total;
    private String fuelType;
    private String paymentType;
    DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY hh:mm");
    Date date = new Date();


    public Receipt(String paymentType, Double totalGallons, Double total, String fuelType) {
        this.paymentType = paymentType;
        this.totalGallons = totalGallons;
        this.total = total;
        this.fuelType = fuelType;
    }

    public void printingReceipt(){
        System.out.println("----Danny's Gas Mart----");
        System.out.println("1245 Ash Lane");
        System.out.println("Water Valley, MS ");
        System.out.println("38965\n");
        System.out.println("Type of Gas: " + fuelType);
        System.out.println("------------------------------");
        System.out.println("Date: " + dateFormat.format(date));
        System.out.println("------------------------------");
        System.out.println(String.format("Total gallons: %.0f", totalGallons));
        System.out.println("------------------------------");
        System.out.println("Type of payment: " + paymentType);
        System.out.println("------------------------------");
        System.out.println("Total cost: " + total + "\n");
        System.out.println("Thank you and have a blessed day!");
        System.exit(0);

    }
}