/*  */
package Robot;
import java.awt.Robot; // robot (very important)
import java.awt.AWTException; 
import java.awt.event.InputEvent;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom; // random number generator (very important)
import java.awt.event.KeyEvent; // used for pressing keys and keylisterner

public class stevev2 {
    public static void main(String [] args) throws IOException, AWTException, InterruptedException {    
        decide();
    }

    public static void decide() throws IOException, AWTException, InterruptedException { // decides next action randomly
        int state = ThreadLocalRandom.current().nextInt(1,5);
        if (state == 1) { //move 
            move();
        } else if (state == 2) { // break
            breaking();
        } else if (state == 3) { // place
            place();
        } else if (state == 4) { //swap
            swap();
        } else if (state == 5) { // look    

        }
    }
    public static void move() throws IOException, AWTException, InterruptedException {
        int direction = ThreadLocalRandom.current().nextInt(1,5);
        int moveTime = ThreadLocalRandom.current().nextInt(1000,5000);
        Robot Mover = new Robot();
        if (direction == 1) { // fordward (w)
            Mover.keyPress(KeyEvent.VK_W);
            System.out.println("moving fordward");
            Thread.sleep(moveTime);
            Mover.keyRelease(KeyEvent.VK_W);
            decide();
        } else if (direction == 2) { // right (d)
            Mover.keyPress(KeyEvent.VK_D);
            System.out.println("moving right");
            Thread.sleep(moveTime);
            Mover.keyRelease(KeyEvent.VK_D);
            decide();
        } else if (direction == 3) { // backwards (s)
            Mover.keyPress(KeyEvent.VK_S);
            System.out.println("moving backwards");
            Thread.sleep(moveTime);
            Mover.keyRelease(KeyEvent.VK_S);
            decide();
        } else if (direction == 4) { // left (a)
            Mover.keyPress(KeyEvent.VK_A);
            System.out.println("moving left");
            Thread.sleep(moveTime);
            Mover.keyRelease(KeyEvent.VK_A);
            decide();
        } else if (direction == 5) { // jump fordward
            Mover.keyPress(KeyEvent.VK_W);
            Mover.keyPress(KeyEvent.VK_SPACE);
            System.out.println("jumping");
            Thread.sleep(moveTime);
            Mover.keyRelease(KeyEvent.VK_A);
            Mover.keyRelease(KeyEvent.VK_SPACE);
            decide();     
        }
    }
    public static void breaking() throws IOException, AWTException, InterruptedException {
        Robot breaker = new Robot();
        breaker.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        System.out.println("breaking block");
        Thread.sleep(5000);
        breaker.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        decide();
    }
    public static void place() throws IOException, AWTException, InterruptedException {
        Robot placer = new Robot();
        placer.mousePress(InputEvent.BUTTON2_DOWN_MASK);
        System.out.println("placing block");
        placer.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
        decide();
    }
    public static void swap() throws IOException, AWTException, InterruptedException {
        Robot swapper = new Robot();
        int hotbar = ThreadLocalRandom.current().nextInt(1,9);
        System.out.println("swapping to hatbar slot: "+hotbar);
        if (hotbar == 1) {
            swapper.keyPress(KeyEvent.VK_1);
            decide();
        } else if (hotbar == 2) {
            swapper.keyPress(KeyEvent.VK_2);
            decide();
        } else if (hotbar == 3) {
            swapper.keyPress(KeyEvent.VK_3);
            decide();
        } else if (hotbar == 4) {
            swapper.keyPress(KeyEvent.VK_4);
            decide();
        } else if (hotbar == 5) {
            swapper.keyPress(KeyEvent.VK_5);
            decide();
        } else if (hotbar == 6) {
            swapper.keyPress(KeyEvent.VK_6);
            decide();
        } else if (hotbar == 7) {
            swapper.keyPress(KeyEvent.VK_7);
            decide();
        } else if (hotbar == 8) {
            swapper.keyPress(KeyEvent.VK_8);
            decide();
        } else if (hotbar == 9) {
            swapper.keyPress(KeyEvent.VK_9);
            decide();
        }
        decide();
    }
    public static void look() throws IOException, AWTException, InterruptedException {
        Robot inv = new Robot(); 
        inv.keyPress(KeyEvent.VK_E);
        System.out.println("opening/closing inventory");
        decide();
    }

    }

