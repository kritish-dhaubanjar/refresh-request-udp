import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String send;

        new Receiver().start();
        new Receiver().start();
        new Receiver().start();

        do{
            System.out.println("Send Refresh Request?");
            send = scanner.nextLine();
            new Sender().start();
        }while (!send.equals("exit"));

    }
}
