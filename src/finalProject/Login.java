package finalProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.TreeSet;
import java.util.logging.Logger;

public class Login {
    
    /** Tree set of people who use the program **/
    TreeSet<Person> credentials;

    /** The file name of credentials **/
    String fileName;

    /** Logger for the login class **/
    Logger logger = Logger.getLogger(Login.class.getName());

    /**
     * Constructor. Populates credentials with the file
     * 
     * @param fileName The name of the file to read
     */
    public Login(String fileName) {
        if(fileName != null) {
            this.fileName = fileName;
            credentials = new TreeSet<Person>();
            setCredentials(0);
        }
        else {
            logger.log(Level.WARNING, "The input file name was null.");
        }
    }

    /**
     * Adds a person to credentials
     * @param person The person to add
     */
    public void addLogin(Person person) {
        if(person != null) {
            credentials.add(person);
        }
        else {
            logger.log(Level.WARNING, "The input person is null.");
        }
    }

    /**
     * Save the credentials to a .txt file.
     * Overwrites the last file.
     */
    public void saveCredentials() {
        final boolean OVERWRITE_MODE = false;
        try (BufferedWriter credWriter = new BufferedWriter(new FileWriter(fileName, OVERWRITE_MODE))) {
            credWriter.write("Member Name, Member Role");
            credWriter.write(System.lineSeparator());
            credentials.forEach(person -> {try { 
                                            credWriter.write(person.getName() + ", " + person.getUsername() + ", " + person.getPassword());
                                            credWriter.write(System.lineSeparator());
                                        } catch (IOException i) {} });
                                        credWriter.close();
        } catch (IOException i) {
            logger.log(Level.WARNING, "There was an issue saving the credentials.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Overloaded method that sets the credentials
     * by reading a .txt file
     * @param numHeaderRows The number of header rows in the file
     */
    public void setCredentials(int numHeaderRows) {
        if(fileName.endsWith(".txt")) {
            try (BufferedReader credReader = new BufferedReader(new FileReader(fileName))) {
                if(!credentials.isEmpty() || !(credentials == null))
                    credentials.clear();
                String line = credReader.readLine();
                int linesRead = 0;
                String delims = "[,]";
                while(line != null) {
                    linesRead++;
                    line = credReader.readLine();
                    if(linesRead > numHeaderRows && line != null)
                    {
                        String[] data = line.split(delims);
                        Person person = new Person(data[0].trim(), data[1].trim(), data[2].trim());
                        credentials.add(person); 
                    }
                }
            } catch (FileNotFoundException f) {
                logger.log(Level.WARNING, "The file, " + fileName + ", could not be found.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            logger.log(Level.WARNING, "File name does not end with .txt");
        }
    }
}
