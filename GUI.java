import java.awt.*;
import javax.swing.*;

public class GUI {

    public static JFrame frame;
    public static JPanel panelDrink, panelProfile;
    public static BoxLayout drinkL, panelL;

    public static Font f = new Font(Font.SANS_SERIF, 15, 15);

    public static void initialize() {
        frame = new JFrame("BAC Project");
        frame.setFont(f);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 200, 800, 500);
        frame.setVisible(true);
    }

}