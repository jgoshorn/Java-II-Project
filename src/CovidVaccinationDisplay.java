import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class CovidVaccinationDisplay {
    private static JTextArea displayTextArea;
    static String[] codes = {
            "AFG:1","ALB:2","AND:3","AGO:4","AIA:5","ARG:6","AUS:7","AUT:8","AZE:9","BHS:10","BHR:11","BGD:12","BRD:13","BLR:14","BEL:15",
            "BLZ:16","BMU:17","BOL:18","BRA:19","BGR:20","KHM:21","CAN:22","CYM:23","CHL:24","CHN:25","COL:26","CRI:27","CIV:28","HRV:29","CYP:30",
            "CZE:31", "DNK:32", "DMA:33", "ECU:34","SLV:35","GNQ:36", "EST:37", "FRO:38", "FIN:39", "FRA:40", "DEU:41", "GHA:42", "GIB:43", 
            "GRC:44", "GRD:45", "GTM:46", "GUY:47", "HND:48", "HKG:49", "HUN:50", "ISL:51", "IND:52","IDN:53", "IRL:54", "IMN:55", "ISR:56",
            "ITA:57", "JAM:58", "JPN:59", "JEY:60", "JOR:61", "KAZ:62", "KEN:63", "LVA:64", "LBN:65", "LTU:66", "LUX:67", "MAC:68", "MWI:69",
            "MYS:70", "MDV:71", "MLT:72", "MEX:73", "MDA:74", "MCO:75", "MNG:76", "MNE:77", "MSR:78", "MAR:79", "MOZ:80", "NLD:81", "NZL:82",
            "MKD:83", "NOR:84", "OMN:85", "PAN:86","PRY:87", "PER:88", "PHL:89", "PRT:90", "QAT:91", "ROU:92", "RUS:93", "RWA:94", "SHN:95", 
            "KNA:96", "LCA:97", "SMR:98", "SAU:99", "SEN:100", "SRB:101", "SYC:102", "SGP:103","SVK:104", "SVN:105", "ZAF:106", "KOR:107", "SSD:108",
            "ESP:109", "LKA:110", "SUR:111", "SWE:112", "CHE:113", "THA:114", "TUR:115", "UGA:116", "UKR:117", "GBR:118", "USA:119", "URY:120","VNM:121",
                                       "ZWE:122"};
            static String outPut = " ";
            /**
             * 
             *  run program here 
             * 
             * 
             *
             * 
             */
            public static void main(String[] args)throws IOException {
                // creates JFrame instance
                JFrame frame = new JFrame("Country Vaccination");
                frame.setSize(2000,900);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                frame.addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent windowEvent){
                        System.exit(0);
                    }
                });
    
    
                // creates panel
                JPanel panel = new JPanel();
                frame.add(panel);
    
                // creates area for calculation output to be displayed
                JScrollPane scrollPane = new JScrollPane(displayTextArea);
                //panel.add(scrollPane, BorderLayout.WEST);
                displayTextArea = new JTextArea();
                displayTextArea.setBounds(10,350,2000,500);
                displayTextArea.setEditable(false);
                panel.add(displayTextArea);
    
                // defined method for adding components
                createGuiComponents(panel);
    
                // Setting the frame visibility to true
                frame.setVisible(true);
    
            }
            private static void createGuiComponents(JPanel panel){
                panel.setLayout(null);
    
    
                // creates employee label, sets bounds and adds to the panel
                JLabel countryLabel = new JLabel("Country ISO Code: ");
                countryLabel.setBounds(10,10,180,55);
                panel.add(countryLabel);
    


                JTextField countryCodeTextField = new JTextField();
                countryCodeTextField.setBounds(140,20,120,20);
                panel.add(countryCodeTextField);
    
    
                // creates the clear button for panel, bounds and adds to panel
                JButton clearButton = new JButton("Clear");
                clearButton.setBounds(300,210,100,40);
                panel.add(clearButton);
                clearButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.repaint();
                        displayTextArea.setText("");
                    }
                });
    
                // creates the display button
                JButton displayButton = new JButton("Display");
                displayButton.setBounds(100, 210, 100, 40);
                panel.add(displayButton);
    
                // display data on press action
                displayButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        int n = Integer.parseInt(countryCodeTextField.getText().trim()); 
                                     
                        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("owid.txt"))){
                            for(int i = 0; i < n -1; i++)
                                bufferedReader.readLine();
                            outPut = bufferedReader.readLine();
                            System.out.println(outPut);
                            displayTextArea.append("||ISO Code||Continent||Location||LastUpdated||Total Vaccinations||People Vaccinated||People fully vaccinated||New Vaccinations||Total Vaccinations Per Hundred||People Vaccinated Per Hundred||People Fully Vaccinated Per Hundred||Brand Name\n" + outPut+" \t ");
                            
                            
                        } catch(Exception e1){
    
                        }
                    }
                });
            }
        }
              
 
