import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javafx.scene.layout.Border;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class IxD
{
    public static void main(String[] args)
    {
        new IxD();
    }
    
    public IxD()
    {
        new IxDGUI();
    }
    
    
    
    public class IxDGUI extends JFrame implements ActionListener
    {
        //JFrame frame;
        JMenuBar menuBar;
        JMenu menu1;
        JMenu menu2;
        JMenu menu3;
        JMenu menu4;
        JPanel panel;
        JTextField Name;
        JTextField Adresse;
        JTextField Titel;
        JTextField ISBN;
        JTextField ID;
        JTextField Gebd;
        JTextField Aufd;
        JButton buttonBenutzer;
        JButton buttonBuch;
        JButton buttonEntleihen;
        JButton buttonRückgabe;
        JButton aufnehmen;
        JButton abbrechen;
        JButton aufnehmen2;
        JButton abbrechen2;
        JComboBox<String> geschlecht;
        JComboBox<String> verleihstatus;
        JPanel panel1;
        JPanel panel2;
        JPanel panel3;
        JPanel panel4;
        JPanel panel5;
        JPanel panel6;
        
        LineBorder bo;
        JDialog dialog1;
        JDialog dialog2;
        JDialog dialog3;
        JDialog dialog4;
    
        public IxDGUI()
        {
            bo = new LineBorder(Color.red);
            
            menuBar = new JMenuBar();
            menu1 = new JMenu("Datei");
            menu2 = new JMenu("Datenbank");
            menu3 = new JMenu("Fenster");
            menu4 = new JMenu("Hilfe");            
            menuBar.add(menu1);
            menuBar.add(menu2);
            menuBar.add(menu3);
            menuBar.add(menu4);
            menuBar.setBorder(bo);
            
            Name = new JTextField(15);
            Adresse = new JTextField(15);
            Titel = new JTextField(15);
            ISBN = new JTextField(15);
            Gebd = new JTextField(15);
            Aufd = new JTextField(15);
            ID = new JTextField(15);
            
            panel = new JPanel();
            panel.setLayout(new GridLayout(2, 2));
            
            add(menuBar);
            add(panel);
            setJMenuBar(menuBar);
        
            buttonBenutzer = new JButton("Benutzer hinzufügen");
            buttonBenutzer.setBackground(Color.green);
            buttonBuch = new JButton("Buch hinzufügen");
            buttonBuch.setBackground(Color.orange);
            buttonEntleihen = new JButton("Eintleihen");
            buttonEntleihen.setBackground(Color.red);
            buttonRückgabe = new JButton("Rückgabe");
            buttonRückgabe.setBackground(Color.white);
            buttonBenutzer.setSize(50, 50);
            buttonBenutzer.setLocation(250, 200);
            
            aufnehmen = new JButton("Aufnehmen");
            abbrechen = new JButton("Abbrechen");
            aufnehmen2 = new JButton("Aufnehmen");
            abbrechen2 = new JButton("Abbrechen");
            
            panel.add(buttonBenutzer);
            panel.add(buttonBuch);
            panel.add(buttonEntleihen);
            panel.add(buttonRückgabe);      
            
            buttonBenutzer.addActionListener(this);
            buttonBuch.addActionListener(this);
            buttonEntleihen.addActionListener(this);
            buttonRückgabe.addActionListener(this);
            aufnehmen.addActionListener(this);
            abbrechen.addActionListener(this);
            aufnehmen2.addActionListener(this);
            abbrechen2.addActionListener(this);
            
            String[] g = {"männlich", "weiblich"};
            geschlecht = new JComboBox<String>(g); 

            String[] v = {"verliehen", "verfügbar"};
            verleihstatus = new JComboBox<String>(v); 
            
               

            setSize(500, 500);
            setVisible(true);
        }

       
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == this.buttonBenutzer)
            {
                
                dialog1 = new JDialog();
                panel1 = new JPanel();
                panel2 = new JPanel();
                panel5 = new JPanel();
                dialog1.add(panel1);
                panel1.setLayout(new BorderLayout());
                panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
                panel2.add(aufnehmen);
                panel2.add(abbrechen);
                panel5.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
                panel5.add(new JLabel("Name "));
                panel5.add(Name);
                panel5.add(new JLabel("ID          "));
                panel5.add(ID);
                panel5.add(new JLabel("Adresse "));
                panel5.add(Adresse);
                panel5.add(new JLabel("Geburtsdatum "));
                panel5.add(Gebd);
                panel5.add(new JLabel("Aufnahmedatum "));
                panel5.add(Aufd);
                panel5.add(new JLabel("Geschlecht                      "));
                panel5.add(geschlecht);
                dialog1.add(panel2, BorderLayout.SOUTH);
                dialog1.add(panel5, BorderLayout.CENTER);
                dialog1.setTitle("Benutzerdaten");
                dialog1.setSize(235, 380);
                dialog1.setModal(true);
                dialog1.setLocation(130, 60);
                dialog1.setVisible(true);
            }
            else if(e.getSource() == this.buttonBuch)
            {
                dialog2 = new JDialog();                
                panel3 = new JPanel();
                panel4 = new JPanel();

                panel6 = new JPanel();
                dialog2.add(panel3);
                panel3.setLayout(new BorderLayout());
                panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
                panel4.add(aufnehmen2);
                panel4.add(abbrechen2);
                panel6.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
                panel6.add(new JLabel("Titel      "));
                panel6.add(Titel);
                panel6.add(new JLabel("ISBN          "));
                panel6.add(ISBN);
                panel6.add(new JLabel("Adresse "));
                panel6.add(Adresse);
                panel6.add(new JLabel("Entleiher ID "));
                panel6.add(ID);

                panel6.add(new JLabel("Verleihstatus                    "));
                panel6.add(verleihstatus);
                /*panel6.add(new JLabel("Aufnahmedatum "));
                panel6.add(Aufd);
                panel6.add(new JLabel("Geschlecht "));
                panel6.add(geschlecht);*/
                dialog2.add(panel4, BorderLayout.SOUTH);
                dialog2.add(panel6, BorderLayout.CENTER);
                dialog2.setTitle("Buchdaten");
                dialog2.setSize(235, 380);
                dialog2.setModal(true);
                dialog2.setLocation(130, 60);
                dialog2.setVisible(true);
            }
            else if(e.getSource() == this.buttonEntleihen)
            {
                dialog3 = new JDialog();
                dialog3.setTitle("Entleihdaten");
                dialog3.setSize(400, 200);
                dialog3.setModal(true);
                dialog3.setLocation(50, 150);
                dialog3.setVisible(true);
            }
            else if(e.getSource() == this.buttonRückgabe)
            {
                dialog4 = new JDialog();
                dialog4.setTitle("Rückgabedaten");
                dialog4.setSize(400, 200);
                dialog4.setModal(true);
                dialog4.setLocation(50, 150);
                dialog4.setVisible(true);
            }
            else if(e.getSource() == this.aufnehmen)
            {
                dialog1.dispose();
            }
            else if(e.getSource() == this.abbrechen)
            {
                dialog1.dispose();
            }
            else if(e.getSource() == this.aufnehmen2)
            {
                dialog2.dispose();
            }
            else if(e.getSource() == this.abbrechen2)
            {
                dialog2.dispose();
            }
        }
    }        
}
