import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RobotKeyboard{
    public static void main(String[] args) throws AWTException, IOException {
        int keyInput[] = {
                KeyEvent.VK_W,
                KeyEvent.VK_E,
                KeyEvent.VK_L,
                KeyEvent.VK_C,
                KeyEvent.VK_O,
                KeyEvent.VK_M,
                KeyEvent.VK_E
        };

        Runtime.getRuntime().exec("code .");
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_SHIFT);
        for(int cnt2 = 0; cnt2 < keyInput.length; cnt2++){
            if(cnt2 > 0){
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            robot.keyRelease(keyInput[cnt2]);
            robot.delay(500);
        }

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);

        robot.delay(1500);

        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);

        robot.delay(1500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);



    }
}
