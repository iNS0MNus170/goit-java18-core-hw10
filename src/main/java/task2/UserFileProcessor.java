package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserFileProcessor {

    private static List<User> readUsersFromFile(File usersFile) {
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(usersFile))) {
            String head = reader.readLine();
            String str;
            while ((str = reader.readLine()) != null) {
                String[] user = str.split(" ");
                String userName = user[0];
                int userAge = Integer.parseInt(user[1]);
                userList.add(new User(userName, userAge));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static void createAndWriteJsonFile(File usersFile) {
        List<User> userList = readUsersFromFile(usersFile);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File jsonFile = new File("src/main/resources/users.json");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile))) {
            String json = gson.toJson(userList);
            writer.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

