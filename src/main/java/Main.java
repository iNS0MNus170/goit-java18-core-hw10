import task1.PhoneNumberValidator;
import task2.UserFileProcessor;
import task3.WordFrequencyCounter;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //task1
        String phoneNumbersPath = "src/main/resources/phoneNumbers.txt";
        File phoneNumbersFile = new File(phoneNumbersPath);
        PhoneNumberValidator.printValidNumbersFromFile(phoneNumbersFile);
        System.out.println("=".repeat(100));
        //task3
        String wordsPath = "src/main/resources/words.txt";
        File wordsFile = new File(wordsPath);
        WordFrequencyCounter.displayWordFrequenciesSorted(wordsFile);
        System.out.println("=".repeat(100));
        //task2
        String usersPath = "src/main/resources/users.txt";
        File usersFile = new File(usersPath);
        UserFileProcessor.createAndWriteJsonFile(usersFile);
    }
}
