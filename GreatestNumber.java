import java.util.Scanner;

/**
 * nth largest number
 * @author Suyash Patel
 */
public class GreatestNumber {

    /**
     * finds nth largest
     * @param arr array
     * @param n nth 
     * @return nth largest term in an array
     * @throws IllegalArgumentException invalid value of n
     */
    public static int findLargest(int[] arr, int n) {
        if (n <= 0 || n > arr.length) {
            throw new IllegalArgumentException("Invalid value of n");
        }
        for (int i = 0; i < n; i++) {
            int greatest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[greatest]) {
                    greatest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[greatest];
            arr[greatest] = temp;
        }
        return arr[n - 1];
    }

    /**
     * main method
     * @param args arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a list of numbers separated by spaces: ");
        String input = scanner.nextLine();
        String[] numbersAsString = input.split("\\s+");
        int[] numbers = new int[numbersAsString.length];
        for (int i = 0; i < numbersAsString.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);
        }
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        int largest = findLargest(numbers, n);

        System.out.println(n + "th largest number is: " + largest);
        scanner.close();
    }
    
}
