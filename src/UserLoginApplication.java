import java.util.Scanner;

public class UserLoginApplication {

    public static void main(String[] args) 
	{
        UserService userService = new UserService();

        // Read user data from the file
        userService.readUserDataFromFile("data.txt");

        Scanner scanner = new Scanner(System.in);
        int loginAttempts = 0;

        while (loginAttempts < 5) {
            System.out.println("Enter your email:");
            String inputUsername = scanner.nextLine();

            System.out.println("Enter your password:");
            String inputPassword = scanner.nextLine();

            String userName = userService.validateUser(inputUsername, inputPassword);

            if (userName != null) {
                System.out.println("Welcome: " + userName);
                break;
            } else {
                loginAttempts++;
                System.out.println("Invalid login, please try again");
            }
        }

        if (loginAttempts == 5) {
            System.out.println("Too many failed login attempts, you are now locked out.");
        }

        scanner.close();
    }
}

