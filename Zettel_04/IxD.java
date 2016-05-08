import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
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
    JMenu dateiMenu, datenbankMenu,fensterMenu, hilfeMenu;
    JMenuItem menuItem;

    JPanel panel;
    JButton buttonBenutzer, buttonBuch, buttonEntleihen, buttonRückgabe;

    public IxDGUI()
    {
    	//Menü
        menuBar = new JMenuBar();

        dateiMenu = new JMenu("Datei");
        datenbankMenu = new JMenu("Datenbank");
        fensterMenu = new JMenu("Fenster");
        hilfeMenu = new JMenu("Hilfe");

        menuBar.add(dateiMenu);
        menuBar.add(datenbankMenu);
        menuBar.add(fensterMenu);
        menuBar.add(hilfeMenu);

        menuItem = new JMenuItem("Als anderer Nutzer anmelden");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.ALT_MASK));
        dateiMenu.add(menuItem);

        menuItem = new JMenuItem("Schließen");
        menuItem.setMnemonic(KeyEvent.VK_Q);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.ALT_MASK));
        dateiMenu.add(menuItem);

        menuItem = new JMenuItem("Datenbankeinstellungen anzeigen");
        menuItem.setMnemonic(KeyEvent.VK_D);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_D, ActionEvent.ALT_MASK));
        datenbankMenu.add(menuItem);
        menuItem = new JMenuItem("Verbindung wiederherstellen");
        datenbankMenu.add(menuItem);

        menuItem = new JMenuItem("Maximieren");
        menuItem.setMnemonic(KeyEvent.VK_G);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, ActionEvent.ALT_MASK));
        fensterMenu.add(menuItem);
        menuItem.setMnemonic(KeyEvent.VK_K);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_K, ActionEvent.ALT_MASK));
        menuItem = new JMenuItem("Minimieren");
        fensterMenu.add(menuItem);

        menuItem = new JMenuItem("Version");
        hilfeMenu.add(menuItem);
        menuItem = new JMenuItem("?");
        hilfeMenu.add(menuItem);


        //Buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        add(menuBar);
        add(panel);
        setJMenuBar(menuBar);

        buttonBenutzer = new JButton("Benutzer hinzufügen");
        buttonBenutzer.setBackground(Color.white);
        buttonBenutzer.setMnemonic(KeyEvent.VK_E);

        buttonBuch = new JButton("Buch hinzufügen");
        buttonBuch.setBackground(Color.white);
        buttonBuch.setMnemonic(KeyEvent.VK_U);

        buttonEntleihen = new JButton("Ausleihen");
        buttonEntleihen.setBackground(Color.white);
        buttonEntleihen.setMnemonic(KeyEvent.VK_A);

        buttonRückgabe = new JButton("Rückgabe");
        buttonRückgabe.setBackground(Color.white);
        buttonRückgabe.setMnemonic(KeyEvent.VK_R);

        panel.add(buttonBenutzer);
        panel.add(buttonBuch);
        panel.add(buttonEntleihen);
        panel.add(buttonRückgabe);

        buttonBenutzer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new benutzerHinzufügenDialog();
			}
		});


        buttonBuch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new buchHinzufügenDialog();
			}
		});

        buttonEntleihen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new buchAusleihenDialog();
			}
		});

        buttonRückgabe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new buchZurückgebenDialog();
			}
		});


    }
}
class benutzerHinzufügenDialog
{
	JDialog benutzerHinzufügenDialog;
	private JButton aufnehmen = new JButton("Aufnehmen");
	private JButton abbrechen = new JButton("Abbrechen");
	private ActionListener close = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			benutzerHinzufügenDialog.dispose();
		}
	};

	benutzerHinzufügenDialog(){
		benutzerHinzufügenDialog = new JDialog();
	  JPanel benutzerHinzufügenBorderPanel = new JPanel();
	  JPanel benutzerHinzufügenOptionsPanel = new JPanel();
	  JPanel benutzerHinzufügenFieldsPanel = new JPanel();

	  benutzerHinzufügenDialog.add(benutzerHinzufügenBorderPanel);
	  benutzerHinzufügenBorderPanel.setLayout(new BorderLayout());

		JPanel radioPanel = new JPanel();
		ButtonGroup radioGroup = new ButtonGroup();
		JRadioButton männlich = new JRadioButton("Männlich");
		JRadioButton weiblich = new JRadioButton("Weiblich");
		radioGroup.add(männlich);
		radioGroup.add(weiblich);
		radioPanel.add(männlich);
		radioPanel.add(weiblich);

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
		benutzerHinzufügenFieldsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

		benutzerHinzufügenOptionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
    benutzerHinzufügenOptionsPanel.add(aufnehmen);
    benutzerHinzufügenOptionsPanel.add(abbrechen);
    aufnehmen.addActionListener(close);
    abbrechen.addActionListener(close);

    benutzerHinzufügenDialog.add(benutzerHinzufügenOptionsPanel, BorderLayout.SOUTH);
    benutzerHinzufügenDialog.add(benutzerHinzufügenFieldsPanel, BorderLayout.CENTER);
    benutzerHinzufügenDialog.setTitle("Neuen Benutzer hinzufügen");
    benutzerHinzufügenDialog.setSize(500, 400);
    benutzerHinzufügenDialog.setModal(true);
    benutzerHinzufügenDialog.setLocation(130, 60);

    benutzerHinzufügenDialog.setResizable(false);
    benutzerHinzufügenDialog.setVisible(true);
	}
}


class buchHinzufügenDialog
{
	JDialog buchHinzufügenDialog;
	private JButton aufnehmen = new JButton("Aufnehmen");
	private JButton abbrechen = new JButton("Abbrechen");
	private ActionListener close = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			buchHinzufügenDialog.dispose();
		}
	};

	buchHinzufügenDialog(){
		buchHinzufügenDialog = new JDialog();
    JPanel buchHinzufügenBorderPanel = new JPanel();
    JPanel buchHinzufügenOptionsPanel = new JPanel();
    JPanel buchHinzufügenFieldsPanel = new JPanel();

    buchHinzufügenBorderPanel.setLayout(new BorderLayout());

    buchHinzufügenFieldsPanel.setLayout(new GridLayout(0,2, 10, 10));
    buchHinzufügenFieldsPanel.add(new JLabel("Titel      "));
    buchHinzufügenFieldsPanel.add(new JTextField());
    buchHinzufügenFieldsPanel.add(new JLabel("Autor"));
    buchHinzufügenFieldsPanel.add(new JTextField());
    buchHinzufügenFieldsPanel.add(new JLabel("ISBN "));
    buchHinzufügenFieldsPanel.add(new JTextField());
    buchHinzufügenFieldsPanel.add(new JLabel("RFID Nummer "));
    buchHinzufügenFieldsPanel.add(new JTextField());
    buchHinzufügenFieldsPanel.add(new JLabel("Präsenzexemplar"));
    buchHinzufügenFieldsPanel.add(new JCheckBox());
    buchHinzufügenFieldsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

    buchHinzufügenOptionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
    buchHinzufügenOptionsPanel.add(aufnehmen);
    buchHinzufügenOptionsPanel.add(abbrechen);
    aufnehmen.addActionListener(close);
    abbrechen.addActionListener(close);

    buchHinzufügenDialog.add(buchHinzufügenBorderPanel);
    buchHinzufügenDialog.add(buchHinzufügenOptionsPanel, BorderLayout.SOUTH);
    buchHinzufügenDialog.add(buchHinzufügenFieldsPanel, BorderLayout.CENTER);
    buchHinzufügenDialog.setTitle("Buch hinzufügen");
    buchHinzufügenDialog.setSize(450, 230);
    buchHinzufügenDialog.setModal(true);
    buchHinzufügenDialog.setLocation(130, 60);

    buchHinzufügenDialog.setResizable(false);
    buchHinzufügenDialog.setVisible(true);
	}
}

class buchZurückgebenDialog
{
	JDialog buchZurückgebenDialog;
	private JButton manuell = new JButton("Manuelle Rückgabe");
	private JButton abbrechen = new JButton("Abbrechen");
	private ActionListener close = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			buchZurückgebenDialog.dispose();
		}
	};

	buchZurückgebenDialog()
	{
		buchZurückgebenDialog = new JDialog();

		JPanel infoTextPanel = new JPanel();
		JPanel optionsPanel = new JPanel();

		JLabel infoText = new JLabel("<html><h2>Rückgabe</h2>"
				+ "Legen Sie das nächste Buch auf den RFID Scanner</html>");
		infoText.setHorizontalAlignment(JLabel.CENTER);
		infoText.setForeground(Color.BLUE);

		infoTextPanel.add(infoText);

		optionsPanel.add(manuell);
		optionsPanel.add(abbrechen);
		manuell.addActionListener(close);
		abbrechen.addActionListener(close);

		buchZurückgebenDialog.add(infoTextPanel, BorderLayout.CENTER);
		buchZurückgebenDialog.add(optionsPanel, BorderLayout.SOUTH);

		buchZurückgebenDialog.setTitle("Buch - Rückgabe");
		buchZurückgebenDialog.setSize(500, 200);
		buchZurückgebenDialog.setModal(true);
		buchZurückgebenDialog.setLocation(130, 60);

		buchZurückgebenDialog.setResizable(false);
		buchZurückgebenDialog.setVisible(true);
	}
}

class buchAusleihenDialog
{
	JDialog buchAusleihenDialog;
	private JButton manuell = new JButton("Manuelle Ausleihe");
	private JButton abbrechen = new JButton("Abbrechen");
	private ActionListener close = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			buchAusleihenDialog.dispose();
		}
	};

	buchAusleihenDialog()
	{
		buchAusleihenDialog = new JDialog();

		JPanel infoTextPanel = new JPanel();
		JPanel optionsPanel = new JPanel();

		JLabel infoText = new JLabel("<html><h2>Ausleihe</h2>"
				+ "Legen Sie das nächste Buch auf den RFID Scanner</html>");
		infoText.setHorizontalAlignment(JLabel.CENTER);
		infoText.setForeground(Color.BLUE);

		infoTextPanel.add(infoText);

		optionsPanel.add(manuell);
		optionsPanel.add(abbrechen);
		manuell.addActionListener(close);
		abbrechen.addActionListener(close);

		buchAusleihenDialog.add(infoTextPanel, BorderLayout.CENTER);
		buchAusleihenDialog.add(optionsPanel, BorderLayout.SOUTH);

		buchAusleihenDialog.setTitle("Buch - Ausleihe");
		buchAusleihenDialog.setSize(500, 200);
		buchAusleihenDialog.setModal(true);
		buchAusleihenDialog.setLocation(130, 60);

		buchAusleihenDialog.setResizable(false);
		buchAusleihenDialog.setVisible(true);
	}
}
