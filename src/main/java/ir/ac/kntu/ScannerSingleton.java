package ir.ac.kntu;

import java.util.Scanner;

/**
 * @author who?
 * @since when?
 * @version what?
 */
public class ScannerSingleton {
    private static final ScannerSingleton INSTANCE = new ScannerSingleton();
    private static Scanner scanner;

    private ScannerSingleton() {
        scanner = new Scanner(System.in);
    }

    /**
     * @return what?
     */
    public ScannerSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * @return what?
     */
    public String nextLine() {
        return scanner.nextLine();
    }

    /**
     * @return what?
     */
    public Integer nextInt() {
        String input = scanner.nextLine();
        input = input.trim();
        return Integer.parseInt(input);
    }

    /**
     * @return what?
     */
    public Double nextDouble(){
        return scanner.nextDouble();
    }

    /**
     * what does it do?
     */
    public void close() {
        scanner.close();
    }
}
