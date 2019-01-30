public class Program {
    public static void main(String[] args) {
        GasPump pump = new GasPump();
        pump.startPumping();
        Receipt r =  ReceiptSaving.receivingGasReceipts("gasReciepts.ser");
        r.printingReceipt();
    }
}
