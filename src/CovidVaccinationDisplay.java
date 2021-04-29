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
            "CZE:31", "DNK:32", "DMA:33", "DOM:34 ","ECU:35 ","SLV:36 ", "GNQ:37", "EST:38","FRO:39","FIN:40","DEU:41","GHA:42","GIB:43","GRC:44",
            "GRD:45","GTM:46","GGY:47","GUY:48","HND:49","HKG:50","HUN:51","ISL:52","IND:53","IRL:54","IMN:55","ISR:56","ITA57","JAM:58","JPN:59",
            "JEY:60","JOR:61","KAZ:62","KEN:63","LVA:64","LBN:65","LTU:66","LUX:67","MAC:68","MWI:69","MYS:70","MDV:71","MTL:72","MEX:73","MDA:74",
            "MCO:75","MNG:76","MNE:77","MSR:78","MAR:79","MOZ:80","NLD:81","NZL:82","MKD:83","NOR:84","OMN:85","PAN:86","PRY:87","PER:88","PHL:89",
            "POL:90","PRT:91","QAT:92","ROU:93","RUS:94","RWA:95","SHN:96","KNA:97","LCA:98","SMR:99","SAU:100","SEN:101","SRB:102","SYC:103","SGP:104",
            "SVK:105","SVN:106","ZAF:107","KOR:108","SSD:109","ESP:110","LKA:111","SUR:112","SWE:113","CHE:114","THA:115","TUN:116","TUR:117","UGA:118","UKR:119","ARE:120","GBR:121",":USA:122","URY:123","VNM:124","ZWE:125"};
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
                frame.setSize(1500,900);
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
                displayTextArea.setBounds(10,350,1500,500);
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
                            for(int i = 0; i < n +1; i++)
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
              
 
