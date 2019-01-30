import java.io.*;

public class ReceiptSaving {
    public static void loggingGasReceipts(Receipt receipt) {
        try {
            FileOutputStream rs = new FileOutputStream("gasReceipts.ser");
            ObjectOutputStream ro = new ObjectOutputStream(rs);
            ro.writeObject(receipt);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static Receipt receivingGasReceipts(String fileName) {
        try {
            FileInputStream fileStream = new FileInputStream("gasReceipts.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            Object one = os.readObject();

            Receipt r = (Receipt) one;
            return r;
        }

        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


    }


}
