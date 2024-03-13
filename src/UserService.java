import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserService { private List<User> users;

// Constructor to initialize the user list
public UserService() {
    this.users = new ArrayList<>();
}

// Method to read user data from the file and populate the user list
public void readUserDataFromFile(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] userData = line.split(",");
            if (userData.length == 3) {
                users.add(new User(userData[0], userData[1], userData[2]));
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

// Method to validate user credentials
public String validateUser(String inputUsername, String inputPassword) {
    for (User user : users) {
        if (user.getUsername().equalsIgnoreCase(inputUsername)
                && user.getPassword().equals(inputPassword)) {
            return user.getName();
        }
    }
    return null;
}

}
