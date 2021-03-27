
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxFrame extends JFrame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ComboBoxFrame() {
        initialize();
    }

    private void initialize() {
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lblCountry = new JLabel("Country Name:");

        // Create
        // 
        String[] countryISOCode = {""};

        // Create a month selection combo box.
        JComboBox<String> comboBox = new JComboBox<>(countryISOCode);
        comboBox.addActionListener(this);
        comboBox.setEditable(true);


        // Adds to pane
        getContentPane().add(lblCountry);
        getContentPane().add(comboBox);
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxFrame().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==comboBox) {
            System.out.println(comboBox.getSelectedItem());
            //System.out.println(comboBox.getSelectedIndex());
           }
        
    }
}