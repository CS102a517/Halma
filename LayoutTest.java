package xyz.chengzi.halma.view;


    // Testing ButtonFrame.
import javax.swing.JFrame;

    public class LayoutTest {
        public static void main(String[] args) {
            Layout calculationFrame = new Layout(); // create ButtonFrame
            calculationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            calculationFrame.setLocationRelativeTo(null);
            calculationFrame.setSize(500,220); // set frame size
            calculationFrame.setVisible(true); // display frame
        }
    }

