public class Receipt {
    private Double totalGallons;
    private Double total;
    private String fuelType;
    private String paymentType;


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
        System.out.println(String.format("Total gallons: %.0f", totalGallons));
        System.out.println("------------------------------");
        System.out.println("Type of payment: " + paymentType);
        System.out.println("------------------------------");
        System.out.println("Total cost: " + total + "\n");
        System.out.println("Thank you and have a blessed day!");
    }
}