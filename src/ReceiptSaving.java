import java.io.*;

public class ReceiptSaving {
    public static void loggingGasReceipts(Receipt receipt) {
        try {
            FileOutputStream rs = new FileOutputStream("gasReceipts.txt");
            ObjectOutputStream ro = new ObjectOutputStream(rs);
            ro.writeObject(receipt);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
