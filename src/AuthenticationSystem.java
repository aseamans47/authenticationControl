
import java.util.Scanner;

public class AuthenticationSystem {

    public static void main(String[] args) {
        authenticator result = new authenticator();//Declares authenticator class.
        String userChoice = "";//This variable allows for the exit of the program or the return to login.

        while (userChoice.contains("q") == false) { // allows for exit if user enters q. Also allows for exit after 3 incorrect attempts.
            userChoice = result.userAuthenticator(); // Runs authenticator class and stores return value in userChoice.
        }
    }

    public static class authenticator { //this class contains most of the functions run for this program. It isnt in main to facilitate the while loop.

        public String userAuthenticator() {
            String userName = "";// Stores user name value.
            String passWord = ""; // Stores password value.
            String hashedPassword = ""; //Stores hashed password value
            String userChoice = ""; // stores users choice at end of class for return value.
            int attemptsRemaining = 3; // counter for attempts remaining loop
            Boolean authenticationStatus = false; // variable for authenticate user class
            Scanner scnr = new Scanner(System.in); // basic scanner for input
            GetHash hash = new GetHash(); // GetHash object for creating MD5 Hash
            AuthenticateUser authenticate = new AuthenticateUser();// authenticate user object for checking user name and password.
            RoleDisplay printRole = new RoleDisplay(); // creates object for displaying roles.

            while (attemptsRemaining > 0 && authenticationStatus == false) { //checks authentication status and attempts remaining. exits if false
                                                                              //authentication status and no attempts remaining.
                System.out.println("Enter Username or \"q\" to quit.");  //prompts user for username
                userName = scnr.nextLine(); // inputs username

                if (userName.startsWith("q")) { // this if statement will exit the loop if the user enters q
                    userChoice = "q";
                    break;
                }

                System.out.println("Enter Password"); // Prompts the user to enter a password. 
                passWord = scnr.nextLine();
                hashedPassword = hash.getMD5Hash(passWord); //sends the password through the GetHash class and stores ass hasedPassword

                authenticationStatus = authenticate.AuthenticateUser(userName, hashedPassword); //this feeds the username and hashed password through the
                                                                                                //authenticator and returns boolean value
                if (authenticationStatus == false) { // this if statement reads the authentication status and restarts the while loop while decrementing 
                    attemptsRemaining--;             // the attemptsRemaining variable.
                    if (attemptsRemaining > 0) {
                        System.out.println("Incorrect Username or password. " + attemptsRemaining + " attempts remaining.");
                    }
                    if (attemptsRemaining == 0) { // this if statement is used when the attemptsRemaining counter hits zero and exits the program.
                        System.out.println("Attempts exceeded.");
                        System.out.println("Exiting...");
                        userChoice = "q";
                        break;
                    }
                } else if (authenticationStatus == true) { //this if statement is initiated if authenticationStatus returns true. It calls the
                    printRole.roleDisplay(userName);    //RoleDisplay class and displays the role of the user.
                    System.out.println("Enter any character to return to login or"); // prompts user to press any character to return to login or
                    System.out.println("enter \"q\" to quit"); // prompts user to quit
                    userChoice = scnr.nextLine(); // Inputs user choice.

                }

            }
            return userChoice; // returns users choice to main method to either exit or return to login. 
        }
    }
}
