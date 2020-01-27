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

    public static JTextArea nameT, heightT, weightT, timerArea, countA;
    public static JComboBox<String> genderT;
    public static JButton sendData, beerB, wineB, liquorB, blank;

    public static Alcohol currentProfile;

    public static boolean changeMade;

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
        String[] genders = { "Male", "Female" };
        genderT = new JComboBox<String>(genders);
        sendData = new JButton("Send Data");
        sendData.setFont(f);
        currentProfile = null;

        timerArea = new JTextArea("Timer");
        timerArea.setFont(f);

        beerB = new JButton("Beer");
        wineB = new JButton("Wine");
        liquorB = new JButton("Hard Liquor");
        beerB.setFont(f);
        wineB.setFont(f);
        liquorB.setFont(f);
        blank = new JButton();
        countA = new JTextArea("Add drink count here");
        countA.setFont(f);

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
                setProfileScreen();
                System.out.println("We Got Here");
            }
        });
        drinkMI.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setDrinkScreen();

            }
            
        });
        timerMI.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("We Got Here");
                setTimerScreen();

            }

        });

        setProfileScreen();
        

        sendData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("We Got Here");
                currentProfile = getProfile();
                System.out.println(currentProfile.getName());
                System.out.println(currentProfile.getGender());
                System.out.println(currentProfile.getHeight());
                System.out.println(currentProfile.getWeight());
            }
        });


        while (true) {
            System.out.println("We got here");
            if (!(currentProfile == null)) break;
        }
        System.out.println("We got here");
    }
    
    
    public static void setProfileScreen() {
        frame.setLayout(new GridLayout(5, 1));
        nameT.setMinimumSize(new Dimension(200, 100));
        genderT.setMinimumSize(new Dimension(200, 100));
        frame.remove(timerArea);
        frame.remove(beerB);
        frame.remove(wineB);
        frame.remove(liquorB);
        frame.remove(countA);
        frame.remove(blank);
        frame.remove(timerArea);
        frame.setLayout(new GridLayout(5, 1));
        frame.add(nameT);
        frame.add(genderT);
        frame.add(weightT);
        frame.add(heightT);
        frame.add(sendData);

        frame.revalidate();
        frame.setEnabled(true);
        frame.setVisible(true);
    }
    public static void setDrinkScreen() {
        frame.setLayout(new GridLayout(3, 2));
        frame.remove(nameT);
        frame.remove(genderT);
        frame.remove(weightT);
        frame.remove(heightT);
        frame.remove(sendData);
        frame.remove(countA);
        frame.remove(timerArea);
        frame.setLayout(new GridLayout(2, 3));
        frame.add(beerB);
        frame.add(wineB);
        frame.add(liquorB);
        frame.add(blank);
        
        frame.add(countA);
        
        

        frame.revalidate();
        frame.setEnabled(true);
        frame.setVisible(true);
    }
    public static void setTimerScreen() {
        frame.setLayout(new GridLayout(1, 1));
        frame.remove(nameT);
        frame.remove(genderT);
        frame.remove(weightT);
        frame.remove(heightT);
        frame.remove(sendData);
        frame.remove(beerB);
        frame.remove(wineB);
        frame.remove(liquorB);
        frame.remove(countA);
        frame.remove(blank);
        frame.setLayout(new GridLayout(1, 1));
        frame.add(timerArea);
        frame.revalidate();
        frame.setEnabled(true);
        frame.setVisible(true);

    }
    
    public static boolean pressed = false;
    public static Alcohol getProfile() {
        String temp;
        if (genderT.getSelectedIndex() == 0) temp = "Male";
        else temp = "Female";
        Alcohol profile = null;
        try {
        profile = new Alcohol(nameT.getText(), temp, Double.parseDouble(heightT.getText()), Integer.parseInt(weightT.getText()));
        } catch(NumberFormatException e)  {
            e.printStackTrace();
        }
        return profile;
    }

}