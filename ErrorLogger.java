import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ErrorLogger {
    private static final String LOG_FILE_PATH = "./files/errors.txt"; 
    public static void logException(Exception e) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) { 
            writer.write(e.toString()); // Запись информации об исключении
            writer.newLine();
            for (StackTraceElement element : e.getStackTrace()) { // Запись стека вызовов
                writer.write("\tat " + element.toString());
                writer.newLine();
            }
            writer.newLine();
        } catch (IOException ioException) { 
            System.out.println("Error write log file: " + ioException.getMessage()); 
        }
    }
}
