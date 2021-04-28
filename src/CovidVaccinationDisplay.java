import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class CovidVaccinationDisplay {

    /**
         * 
         * 
         * @param args
         * @throws IOException
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


        static String outPut="";
        private static JTextArea displayTextArea;
        static String codes[] = {
            "AFG","ALB","AND","AGO","AIA","ARG","AUS","AUT","AZE","BHS","BHR","BGD","BRD","BLR","BEL",
            "BLZ","BMU","BOL","BRA","BGR","KHM","CAN","CYM","CHL","CHN","COL","CRI","CIV","HRV","CYP",
            "CZE", "DNK", "DMA", "ECU","SLV","GNQ", "EST", "FRO", "FIN", "FRA", "DEU", "GHA", "GIB", 
            "GRC", "GRD", "GTM", "GUY", "HND", "HKG", "HUN", "ISL", "IND","IDN", "IRL", "IMN", "ISR",
            "ITA", "JAM", "JPN", "JEY", "JOR", "KAZ", "KEN", "LVA", "LBN", "LTU", "LUX", "MAC", "MWI",
            "MYS", "MDV", "MLT", "MEX", "MDA", "MCO", "MNG", "MNE", "MSR", "MAR", "MOZ", "NLD", "NZL",
            "MKD", "NOR", "OMN", "PAN","PRY", "PER", "PHL", "PRT", "QAT", "ROU", "RUS", "RWA", "SHN", 
            "KNA", "LCA", "SMR", "SAU", "SEN", "SRB", "SYC", "SGP","SVK", "SVN", "ZAF", "KOR", "SSD",
            "ESP", "LKA", "SUR", "SWE", "CHE", "THA", "TUR", "UGA", "UKR", "GBR", "USA", "URY","VNM",
                                       "ZWE"};

    static class CountryComboBox{
         String readFile(String code)throws IOException{

            String line= "";
            String fileOutput = "";

            var fileName = "owid.txt";
            var filePath = Paths.get(fileName);


            BufferedReader bufferedReader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8);

            while((line = bufferedReader.readLine()) != null){
               // System.out.println("this line works");

                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
                
                /*
                * this while loop is what doesn't work at the moment
                * specifically the if statement doesn't compare (check if equal) the code entered from the combo box
                * which means it won't output anything
                *
                *
                */
                while(stringTokenizer.hasMoreTokens()){

                    System.out.println(stringTokenizer.nextToken());
                    System.out.println(code);;
                    String isoCode=stringTokenizer.nextToken();
                    System.out.println(isoCode);
                    String continent=stringTokenizer.nextToken();
                    System.out.println(continent);
                    String location=stringTokenizer.nextToken();
                    System.out.println(location);
                    String lastUpdated=stringTokenizer.nextToken();
                    System.out.println(lastUpdated);
                    String totalVaccinations=stringTokenizer.nextToken();
                    System.out.println(totalVaccinations);
                    String peopleVaccinated=stringTokenizer.nextToken();
                    System.out.println(peopleVaccinated);
                    String peopleFullyVaccinated=stringTokenizer.nextToken();
                    System.out.println(peopleFullyVaccinated);
                    String newVaccinations=stringTokenizer.nextToken();
                    System.out.println(newVaccinations);
                    String totalVaccPerHunderd=stringTokenizer.nextToken();
                    System.out.println(totalVaccPerHunderd);
                    String peopleVaccPerHundred=stringTokenizer.nextToken();
                    System.out.println(peopleVaccPerHundred);
                    String fullyVaccPerHundred=stringTokenizer.nextToken();
                    System.out.println(fullyVaccPerHundred);
                    String brandName=stringTokenizer.nextToken();
                    System.out.println(brandName);

                    /**
                     * 
                     * fileOutput = isoCode+"\t"+continent+"\t"+location+"\t"+lastUpdated+"\t"+totalVaccinations+"\t"
                        +peopleVaccinated+"\t"+peopleFullyVaccinated+"\t"+newVaccinations+"\t"+totalVaccPerHunderd+"\t"
                        +peopleVaccPerHundred+"\t"+fullyVaccPerHundred+"\t"+brandName;
                     */


                    if(isoCode.equals(code)){
                        System.out.println("work");
                        fileOutput = isoCode+"\t"+continent+"\t"+location+"\t"+lastUpdated+"\t"+totalVaccinations+"\t"
                        +peopleVaccinated+"\t"+peopleFullyVaccinated+"\t"+newVaccinations+"\t"+totalVaccPerHunderd+"\t"
                        +peopleVaccPerHundred+"\t"+fullyVaccPerHundred+"\t"+brandName;
                    }  else{System.out.println("nope");}                  
                }
                return fileOutput;
            }
            return fileOutput;         
/*
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("owid.txt"))){
                            for(int i=0; i < n; i++){
                                bufferedReader.readLine();
                            line = bufferedReader.readLine();
                            System.out.println(line);
                            outPut = line; 
                            }
                        }catch(Exception e1){
                            System.out.println(e1);
                        } */
         }           
        }  
        private static void createGuiComponents(JPanel panel){
            panel.setLayout(null);


            // creates employee label, sets bounds and adds to the panel
            JLabel countryLabel = new JLabel("Country ISO Code: ");
            countryLabel.setBounds(10,10,180,55);
            panel.add(countryLabel);


            JComboBox<String> counrtyComboBox = new JComboBox<String>(codes);
            counrtyComboBox.setBounds(140,20,120,20);
            panel.add(counrtyComboBox);


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


            // display on press action
            displayButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String countryIsoCode = counrtyComboBox.getItemAt(counrtyComboBox.getSelectedIndex());
                    
                    
                    try{
                        CountryComboBox object = new CountryComboBox();
                     //   System.out.println("stuff ");;

                        outPut = object.readFile(countryIsoCode);
                        System.out.println(outPut);

                    }catch(Exception e1){

                    }
                  //  System.out.println("working ");

                    displayTextArea.append("\nISO Code\tContinent\tLocation\tLast Updated\tTotal Vaccinations\tPeople Vaccinated\tPeople fully vaccinated\tNew Vaccinations\tTotal Vaccinations Per Hundred\tPeople Vaccinated Per Hundred\tPeople Fully Vaccinated Per Hundred\tBrand Name\n" + outPut);
                }
            });
        }
    
    }   

