// entleihe, rückgabe fehlt noch, dialog button sind ohne funktion, tastenkürzel fehlen

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.*;

public class IxD 
{
    public static void main(String[] args) 
    {
        JFrame window = new IxDGUI();
        window.setTitle("Bibliothekssoftware");
        window.setSize(800, 800);  
        window.setVisible(true);
    }
}
    

class IxDGUI extends JFrame
{
    //JFrame frame;
    JMenuBar menuBar;
    JMenu dateiMenuItem;
    JMenu datenbankMenuItem;
    JMenu fensterMenuItem;
    JMenu hilfeMenuItem;
    
    JPanel panel;
    JButton buttonBenutzer;
    JButton buttonBuch;
    JButton buttonEntleihen;
    JButton buttonRückgabe;


    LineBorder bo;
 
    public IxDGUI()
    {
        bo = new LineBorder(Color.red);
        
        menuBar = new JMenuBar();
        
        dateiMenuItem = new JMenu("Datei");
        datenbankMenuItem = new JMenu("Datenbank");
        fensterMenuItem = new JMenu("Fenster");
        hilfeMenuItem = new JMenu("Hilfe");  
        
        menuBar.add(dateiMenuItem);
        menuBar.add(datenbankMenuItem);
        menuBar.add(fensterMenuItem);
        menuBar.add(hilfeMenuItem);
        
        menuBar.setBorder(bo);
        
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        
        add(menuBar);
        add(panel);
        setJMenuBar(menuBar);
    
        buttonBenutzer = new JButton("Benutzer hinzufügen");
        buttonBenutzer.setBackground(Color.white);
        buttonBuch = new JButton("Buch hinzufügen");
        buttonBuch.setBackground(Color.white);
        buttonEntleihen = new JButton("Eintleihen");
        buttonEntleihen.setBackground(Color.white);
        buttonRückgabe = new JButton("Rückgabe");
        buttonRückgabe.setBackground(Color.white);
        buttonBenutzer.setSize(40, 40);
        buttonBenutzer.setLocation(250, 200);

        panel.add(buttonBenutzer);
        panel.add(buttonBuch);
        panel.add(buttonEntleihen);
        panel.add(buttonRückgabe);      
        
        
        buttonBenutzer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JDialog benutzerHinzufügenDialog = new JDialog();
                JPanel benutzerHinzufügenBorderPanel = new JPanel();
                JPanel benutzerHinzufügenOptionsPanel = new JPanel();
                JPanel benutzerHinzufügenFieldsPanel = new JPanel();
                
                benutzerHinzufügenDialog.add(benutzerHinzufügenBorderPanel);
                benutzerHinzufügenBorderPanel.setLayout(new BorderLayout());
                
                
				JPanel radioPanel = new JPanel();
				ButtonGroup radioGroup = new ButtonGroup();
				JRadioButton male = new JRadioButton("Männlich");
				JRadioButton female = new JRadioButton("Weiblich");
				radioGroup.add(male);
				radioGroup.add(female);	
				radioPanel.add(male);
				radioPanel.add(female);	

				benutzerHinzufügenFieldsPanel.setLayout(new GridLayout(0,2, 20, 10));
				benutzerHinzufügenFieldsPanel.add(new JLabel("Name:"));
				benutzerHinzufügenFieldsPanel.add(new JTextField());
				benutzerHinzufügenFieldsPanel.add(new JLabel("Vorname:"));
				benutzerHinzufügenFieldsPanel.add(new JTextField());
				benutzerHinzufügenFieldsPanel.add(new JLabel("Straße / Hausnr:"));
				benutzerHinzufügenFieldsPanel.add(new JTextField());
				benutzerHinzufügenFieldsPanel.add(new JLabel("PLZ"));
				benutzerHinzufügenFieldsPanel.add(new JTextField());
				benutzerHinzufügenFieldsPanel.add(new JLabel("Ort"));
				benutzerHinzufügenFieldsPanel.add(new JTextField());
				benutzerHinzufügenFieldsPanel.add(new JLabel("Geburtsdatum:"));
				benutzerHinzufügenFieldsPanel.add(new DatePane());
				benutzerHinzufügenFieldsPanel.add(new JLabel("Aufnahmedatum:"));
				benutzerHinzufügenFieldsPanel.add(new DatePane());
				benutzerHinzufügenFieldsPanel.add(new JLabel("Geschlecht:"));
				benutzerHinzufügenFieldsPanel.add(radioPanel);
				
				benutzerHinzufügenOptionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
                benutzerHinzufügenOptionsPanel.add(new JButton("Aufnehmen"));
                benutzerHinzufügenOptionsPanel.add(new JButton("Abbrechen"));
                
                benutzerHinzufügenDialog.add(benutzerHinzufügenOptionsPanel, BorderLayout.SOUTH);
                benutzerHinzufügenDialog.add(benutzerHinzufügenFieldsPanel, BorderLayout.CENTER);
                benutzerHinzufügenDialog.setTitle("Benutzerdaten");
                benutzerHinzufügenDialog.setSize(500, 400);
                benutzerHinzufügenDialog.setModal(true);
                benutzerHinzufügenDialog.setLocation(130, 60);
                
                benutzerHinzufügenDialog.setResizable(false);
                benutzerHinzufügenDialog.setVisible(true);
			}
		});
        
        
        buttonBuch.addActionListener(new ActionListener() {
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog buchHinzufügenDialog = new JDialog();                
	            JPanel buchHinzufügenBorderPanel = new JPanel();
	            JPanel buchHinzufügenOptionsPanel = new JPanel();
	            JPanel buchHinzufügenFieldsPanel = new JPanel();
	            
	            buchHinzufügenDialog.add(buchHinzufügenBorderPanel);
	            buchHinzufügenBorderPanel.setLayout(new BorderLayout());
	            
	            buchHinzufügenFieldsPanel.setLayout(new GridLayout(0,2, 10, 10));
	            buchHinzufügenFieldsPanel.add(new JLabel("Titel      "));
	            buchHinzufügenFieldsPanel.add(new JTextField());
	            buchHinzufügenFieldsPanel.add(new JLabel("Autor"));
	            buchHinzufügenFieldsPanel.add(new JTextField());
	            buchHinzufügenFieldsPanel.add(new JLabel("ISBN "));
	            buchHinzufügenFieldsPanel.add(new JTextField());
	            buchHinzufügenFieldsPanel.add(new JLabel("Präsenzexemplar"));
	            buchHinzufügenFieldsPanel.add(new JCheckBox());
	            
	            buchHinzufügenOptionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
	            buchHinzufügenOptionsPanel.add(new JButton("Aufnehmen"));
                buchHinzufügenOptionsPanel.add(new JButton("Abbrechen"));

	            buchHinzufügenDialog.add(buchHinzufügenOptionsPanel, BorderLayout.SOUTH);
	            buchHinzufügenDialog.add(buchHinzufügenFieldsPanel, BorderLayout.CENTER);
	            buchHinzufügenDialog.setTitle("Buchdaten");
	            buchHinzufügenDialog.setSize(450, 230);
	            buchHinzufügenDialog.setModal(true);
	            buchHinzufügenDialog.setLocation(130, 60);
	            
	            buchHinzufügenDialog.setResizable(false);
	            buchHinzufügenDialog.setVisible(true);
			}
		});
        
        buttonEntleihen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	        
			}
		});   
        
        buttonRückgabe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	        
			}
		}); 
        
        ActionListener close = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
			}
		};
    } 
}        


