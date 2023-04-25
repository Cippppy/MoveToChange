package finalProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * Helper class to help hold the logins
 */
public class Login {
    
    /** The credentials for all users **/
    private static TreeMap<String, Person> credentials = new TreeMap<String, Person>();

    /** Logger for the login class **/
    transient private static Logger logger = Logger.getLogger(Login.class.getName());

    /** File name where the credenitals are stored **/
    private static final String FILE_NAME = "credentials.ser";

    /**
     * Constructor. Populates credentials with the file
     * 
     * @param fileName The name of the file to read
     */
    public Login() {
        credentials = new TreeMap<String, Person>();
        credentials.put("ballfart", new Person("shid", "fart"));
        credentials.put("Po", new Person("Po", "Po"));
    }

    /**
     * Adds a person to credentials
     * @param person The person to add
     */
    public static void addLogin(String name, String username, String password) {
        if(name != null && username != null && password != null) {
            credentials.put(username.toUpperCase(), new Person(name.toUpperCase(), password.toUpperCase()));
            logger.log(Level.INFO, "Login Successfully added");
        }
        else {
            logger.log(Level.WARNING, "The input person is null.");
        }
    }

    /**
     * Finds the login of a specifc username and password
     * @param username The username of the person to find
     * @param password The password of the person to find
     * @return The person found
     */
    public static Person findLogin(String username, String password) {
        Person person = null;
        if (credentials.containsKey(username.toUpperCase())) {
            logger.log(Level.INFO, "Contains Key!");
            if (credentials.get(username.toUpperCase()).getPassword().toUpperCase().equals(password.toUpperCase())) {
                logger.log(Level.INFO, "Found the person!");
                return credentials.get(username.toUpperCase());
            }
        }
        return person;
    }

    /**
     * Checks if the person is inside of the credentials
     * @param person The person to check
     * @return True or False
     */
    public static boolean isLoginValid(Person person) {
        boolean valid = false;
        if (credentials.values().contains(person)) {
            logger.log(Level.INFO, "Valid");
            valid = true;
        }
        return valid;
    }

    /**
     * Serializes the credentials tree map
     */
    public static void serialize() {

		try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME)) {
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(credentials);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data for login stored in " + FILE_NAME);
		} catch (IOException e) {
				e.printStackTrace();
		}
	}

    /**
     * Deserializes the credentials tree map
     */
	public static void deserialize() {
        if(credentials == null) {
            credentials = new TreeMap<String, Person>();
        }
		FileInputStream fileIn = null;
		ObjectInputStream in = null;

		try {
			fileIn = new FileInputStream(FILE_NAME);
			in = new ObjectInputStream(fileIn);
			credentials = (TreeMap<String, Person>) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Deserializing login in " + FILE_NAME);
		} catch (ClassNotFoundException c) {
			System.out.println("The target login have a different version ID.");
			c.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + 
					": " + e.getMessage() + "\n");
		} 
	}
}