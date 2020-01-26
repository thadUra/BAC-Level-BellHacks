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

    public static JTextArea nameT, heightT, weightT;
    public static JComboBox<String> genderT;
    public static JButton sendData;

    public static boolean changeMade;

    public static Alcohol currentProfile;

    public static Font f = new Font(Font.SANS_SERIF, 15, 15);

    public static void initialize() {
        frame = new JFrame("BAC Project");
        frame.setFont(f);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 200, 800, 500);
        frame.setVisible(true);

        nameT = new JTextArea("Insert Name");
        nameT.setEditable(true);
        nameT.setText("Insert Name");
        heightT = new JTextArea("Insert Height");
        weightT = new JTextArea("Insert Weight");
        String[] genders = {"Male", "Female"};
        genderT = new JComboBox<String>(genders);
        sendData = new JButton("Send Data");
        sendData.setFont(f);
        

        menuBar = new JMenuBar();
        menuBar.setFont(f);
        menuBar.setEnabled(true);
        menuBar.setVisible(true);
        
        drinkM = new JMenu("Add Drink");
        drinkM.setFont(f);
        profileM = new JMenu("Profile");
        profileM.setFont(f);
        timerM = new JMenu("Timer");
        timerM.setFont(f);
        drinkM.setEnabled(true);
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
        frame.setJMenuBar(menuBar);
        profileMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screen = 0;
                changeMade = true;
            }
        });

        frame.setLayout(new BoxLayout(frame, 1));
        nameT.setFont(f);
        panelProfile.add(nameT);
        nameT.setEnabled(true);
        panelProfile.add(genderT);
        genderT.setFont(f);
        frame.add(nameT);
        frame.add(genderT);
        

        sendData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressed = true;
            }
        });
        
        currentProfile = profileScreen();
    }

    public static Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            frame.add(panelProfile);
            
            while (true) {
                if (changeMade) {
                    switch(screen) {
                        case 0:
                            frame.remove(panelDrink);
                            frame.remove(panelTime);
                            frame.add(panelProfile);
                            currentProfile = profileScreen();
                        break;
                    }
                }

            }
        }
    });
    public static boolean pressed = false;
    public static Alcohol profileScreen() {
        while (!pressed) {

        }
        String temp;
        if (genderT.getSelectedIndex() == 0) temp = "Male";
        else temp = "Female";
        Alcohol profile = new Alcohol(nameT.getText(), temp, Double.parseDouble(heightT.getText()), Integer.parseInt(weightT.getText()));
        return profile;
    }

}