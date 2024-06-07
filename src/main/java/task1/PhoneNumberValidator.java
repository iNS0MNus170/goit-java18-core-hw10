package task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {

    public static void printValidNumbersFromFile(File file) {
        try (Scanner sc = new Scanner(new FileReader(file))) {
            if (file.length() == 0) {
                System.err.println("File is empty: " + file.getPath());
                return;
            }
            boolean isFileEmpty = true;
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    isFileEmpty = false;
                    if (isValidPhoneNumber(line)) {
                        System.out.println(line);
                    }
                }
            }
            if (isFileEmpty) {
                System.err.println("File contains only empty lines: " + file.getPath());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File not found: " + file.getPath());
        }
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^(\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();

    }
}