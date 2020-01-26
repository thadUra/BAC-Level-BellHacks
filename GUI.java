import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {

    public static int screen = 0;

    public static JFrame frame;
    public static JPanel panelDrink, panelProfile, panelTime;
    public static BoxLayout drinkL, profileL, timerL;
    public static JMenuBar menuBar;
    public static JMenu drinkM, profileM, timerM;
    public static JMenuItem drinkMI, profileMI, timerMI;

    public static Font f = new Font(Font.SANS_SERIF, 15, 15);

    public static void initialize() {
        frame = new JFrame("BAC Project");
        frame.setFont(f);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 200, 800, 500);
        frame.setVisible(true);
        menuBar = new JMenuBar();
        menuBar.setFont(f);
        frame.setJMenuBar(menuBar);
        drinkM = new JMenu("Add Drink");
        drinkM.setFont(f);
        profileM = new JMenu("Profile");
        profileM.setFont(f);
        timerM = new JMenu("Timer");
        timerM.setFont(f);
        menuBar.add(profileM);
        menuBar.add(drinkM);
        menuBar.add(timerM);
        drinkMI = new JMenuItem("Add Drink");
        profileMI = new JMenuItem("Profile");
        timerMI = new JMenuItem("Timer");
        drinkMI.setFont(f);
        profileMI.setFont(f);
        timerMI.setFont(f);
        drinkM.add(drinkMI);
        timerM.add(timerMI);
        profileM.add(profileMI);

        profileMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        

        thread.start();
    }

    public static Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            int oldScreen = screen;
            while (true) {
                if (oldScreen != screen) {
                    switch(screen) {
                        case 0:
                            frame.remove(panelDrink);
                            frame.remove(panelTime);
                            frame.add(panelProfile);
                        break;
                    }
                }

            }
        }
    });
    public static void profileScreen() {

    }

}