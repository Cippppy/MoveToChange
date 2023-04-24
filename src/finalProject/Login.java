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

public class Login {
    
    /** Tree set of people who use the program **/
   // TreeSet<Person> credentials;

    private static TreeMap<String, Person> credentials = new TreeMap<String, Person>();

    /** Logger for the login class **/
    private static Logger logger = Logger.getLogger(Login.class.getName());

    private static final String FILE_NAME = "credentials.ser";

    /**
     * Constructor. Populates credentials with the file
     * 
     * @param fileName The name of the file to read
     */
    public Login() {
        credentials = new TreeMap<String, Person>();
        credentials.put("ballfart", new Person("shid", "fart"));
    }

    /**
     * Adds a person to credentials
     * @param person The person to add
     */
    public static void addLogin(String name, String username, String password) {
        if(name != null && username != null && password != null) {
            credentials.put(username, new Person(name, username, password));
        }
        else {
            logger.log(Level.WARNING, "The input person is null.");
        }
    }

    private static Person findLogin(String username, String password) {
        Person person = null;
        if (credentials.get(username) != null) {
            if (credentials.get(username).getPassword().equals(password)) {
                return credentials.get(username);
            }
        }
        return person;
    }

    private static boolean isLoginValid(Person person) {
        boolean valid = false;
        if (credentials.values().contains(person)) {
            valid = true;
        }
        return valid;
    }

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
	 * Deserializes the instance of the Statistic stored in a file
     * @param fileName The name of the file to be read
	 * @return The deserialized StateStatistic.
	 * @throws StatisticDataNotFoundException
     * @author Christian Cipolletta
	 */
	public static TreeMap<String, Person> deserialize() {
        if(credentials == null) {
            credentials = new TreeMap<String, Person>();
        }
		TreeMap<String, Person> credentials = null;
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
		return credentials;
	}
}