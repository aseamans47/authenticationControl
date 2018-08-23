
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author whataruckus
 */
public class AuthenticateUser {

    public Boolean AuthenticateUser(String userName, String hashedPassword) { //class accepts username and password as parameters
        BufferedReader credBuffer = null; // reader of credentials.txt
        Boolean authenticationStatus = false; // creates variable to return.
        String currentLine = null;//current line that the buffered reader is reading through

        try {
            FileReader credReader = null;
            try { // this method reads throught the credentials
                credReader = new FileReader("credentials.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AuthenticateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            credBuffer = new BufferedReader(credReader);

            while ((currentLine = credBuffer.readLine()) != null) { // this while loop iterates through the credentials file

                if (currentLine.contains(userName) && currentLine.contains(hashedPassword)) { // this if statement ensures that username exists and password
                    authenticationStatus = true;                                              // is on the same line. Sets authenticationStatus to true if so. 
                    break;
                }
            }
        } catch (FileNotFoundException fnfe) {// exceptions for readers
            System.out.println(fnfe);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return authenticationStatus; // returns boolean value. True if password match, false if not. 
    }
}
