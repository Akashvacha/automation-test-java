package alraji_system_admin_bia_creation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class FileSelectionHelper {
    public void selectFile(String filePath) {
        try {
            Robot robot = new Robot();

            // Simulate pressing Ctrl + O to open the file dialog (assuming this is the shortcut to open the dialog)
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Type the file path character by character
            for (char c : filePath.toCharArray()) {
                simulateKeyPress(robot, c);
            }

            // Simulate pressing Enter to confirm the file selection
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void simulateKeyPress(Robot robot, char key) {
        int keyCode = (int) key;
        
        if (Character.isUpperCase(key)) {
            robot.keyPress(KeyEvent.VK_SHIFT);
        }

        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);

        if (Character.isUpperCase(key)) {
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }
}
