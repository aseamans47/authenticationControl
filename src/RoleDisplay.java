
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author whataruckus
 */
public class RoleDisplay {

    String role = ""; // creates a variable for the role

    public void roleDisplay(String userName) {
        BufferedReader roleBuffer = null;
        FileReader roleReader = null;
        String currentLine = "";

        try { // this try method opens the credentials and contains a while loop
            FileReader credReader = new FileReader("credentials.txt");
            BufferedReader credBuffer = new BufferedReader(credReader);

            // loops through the credentials and matches the userName to the role.
            while ((currentLine = credBuffer.readLine()) != null) {
                if (currentLine.contains(userName) && currentLine.contains("zookeeper")) {
                    role = "zookeeper";
                    break;
                } else if (currentLine.contains(userName) && currentLine.contains("veterinarian")) {
                    role = "veterinarian";
                    break;
                } else if (currentLine.contains(userName) && currentLine.contains("admin")) {
                    role = "admin";
                    break;
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        if (role == "zookeeper") { //this series of if statements will check the role and open the corresponding file.
            try {
                roleReader = new FileReader("zookeeper.txt");
                roleBuffer = new BufferedReader(roleReader);

                while ((currentLine = roleBuffer.readLine()) != null) {
                    System.out.println(currentLine);
                }
            } catch (FileNotFoundException fnfe) {
                System.out.println(fnfe);
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        }
        if (role == "veterinarian") {
            try {
                roleReader = new FileReader("veterinarian.txt");
                roleBuffer = new BufferedReader(roleReader);

                while ((currentLine = roleBuffer.readLine()) != null) {
                    System.out.println(currentLine);
                }
            } catch (FileNotFoundException fnfe) {
                System.out.println(fnfe);
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        }
        if (role == "admin") {
            try {
                roleReader = new FileReader("admin.txt");
                roleBuffer = new BufferedReader(roleReader);

                while ((currentLine = roleBuffer.readLine()) != null) {
                    System.out.println(currentLine);
                }
            } catch (FileNotFoundException fnfe) {
                System.out.println(fnfe);
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        }
    }

}
