package finalProject;

import java.time.LocalDate;

/**
 * Thrown when a file has an incorrect file extension
 * @author Ana Oharciuc
 */
public class UnknownFileExtensionException extends Exception {

    // Name of the file
    private static String file = "";
    // Timestamp of the error
    private static LocalDate timestamp;

    /**
     * Throw a new UnknownFileExtensionException
     * @author Ana Oharciuc
     * @param file the name of the file
     */
    public UnknownFileExtensionException(String filename) {
        super("[" + timestamp + "] Incorrect file extension: " + filename + ". Correct file extensions are .txt and .ser.");
        file = filename;
        timestamp = LocalDate.now();
        printStackTrace();
    }

    /**
     * Returns the file name
     * @author Ana Oharciuc
     * @return
     */
    public static String getFile() {
        return file;
    }

    /**
     * Returns the time in which the error was thrown
     * @author Ana Oharciuc
     * @return
     */
    public static LocalDate getTimestamp() {
        return timestamp;
    }
}
