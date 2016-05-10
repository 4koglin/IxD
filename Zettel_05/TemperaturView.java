import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class TemperaturView implements Observer{
	
	private final int MAXCELSIUS = 100;
	private final int MINCESLIUS = -51;
	private final int INITIALCELSIUS = 0;
	
	private final int MAXFAHRENHEIT = 212;
	private final int MINFAHRENHEIT = -60;
	private final int INITIALFAHRENHEIT = 32;
	
	JFrame window = new JFrame();
	private JTextField _temperatureFTf = new JTextField(3);
	private JTextField _temperatureCTf = new JTextField(3);
	
	
	private String Ganzzahl = "Bitte eine Ganzzahl eingeben";
	private String Ganzzahl_AZ = "Bitte eine Ganzzahl eingeben!!!!!!!!!!!!!!!!!!!!";
	
	private JLabel _warningLabel = new JLabel(Ganzzahl);
	private JButton _convertFtoCBtn = new JButton("-> Fahrenheit to Celsius");
	private JButton _convertCtoFBtn = new JButton("Celsius to Fahrenheit <-");
	
	JSlider _celsiusSlider = new JSlider(JSlider.VERTICAL, MINCESLIUS, MAXCELSIUS, INITIALCELSIUS);
	JSlider _fahrenheitSlider = new JSlider(JSlider.VERTICAL, MINFAHRENHEIT, MAXFAHRENHEIT, INITIALFAHRENHEIT);
	
	
	TemperaturView(TemperaturModel temperaturModel) {
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		
		_celsiusSlider.setPaintTicks(true);
		_celsiusSlider.setPaintLabels(true);
		_celsiusSlider.setMinorTickSpacing(1);
		_celsiusSlider.setMajorTickSpacing(15);
		
		_fahrenheitSlider.setPaintTicks(true);
		_fahrenheitSlider.setPaintLabels(true);
		_fahrenheitSlider.setMinorTickSpacing(1);
		_fahrenheitSlider.setMajorTickSpacing(20);
		
		_temperatureFTf.setText(Integer.toString(INITIALFAHRENHEIT));
		_temperatureCTf.setText(Integer.toString(INITIALCELSIUS));
		
		
		//kann man noch anpassen, dann muss aber noch einiges hinzugefügt werden
		//_temperatureFTf.setEditable(false);
		//_temperatureCTf.setEditable(false);
		
		temperaturModel.setCelsius(INITIALCELSIUS);
		temperaturModel.setFahrenheit(INITIALFAHRENHEIT);
		
		content.add(_fahrenheitSlider);
		content.add(new JLabel("Fahrenheit"));
		content.add(_temperatureFTf);
		content.add(_convertFtoCBtn);
		content.add(_convertCtoFBtn);
		content.add(_temperatureCTf);
		content.add(new JLabel("Celsius"));
		content.add(_celsiusSlider);
		content.add(_warningLabel);
		
		window.setContentPane(content);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setSize(800, 280);  
	    window.setVisible(true);
	    
	    temperaturModel.addObserver(this);
	} 
	
	public void setFahrenheitSliderChangeListener(ChangeListener cl)
	{
		_fahrenheitSlider.addChangeListener(cl);
	}
	
	public void setCelsiusSliderChangeListener(ChangeListener cl)
	{
		_celsiusSlider.addChangeListener(cl);
	}
	
	public void setFtCButtonListener(ActionListener al)
	{
		_convertFtoCBtn.addActionListener(al);
	}
	
	public void setCtFButtonListener(ActionListener al)
	{
		_convertCtoFBtn.addActionListener(al);
	}
	
	public int getSliderCelsius()
	{
		return _celsiusSlider.getValue();
	}
	
	public int getSliderFahrenheit()
	{
		return _fahrenheitSlider.getValue();
	}
	
	public int getTFCelsius()
	{
		int result = 0;
		
		//Die Frage ist, gehört sowas in die View oder in den Controller?
		try {
			result = Integer.parseInt(_temperatureCTf.getText());
		} catch (NumberFormatException e)
		{
			setWarningRed();
			return result;
		}

		setWarningBlack();
		return result;
	}
	
	public int getTFFahrenheit()
	{
		int result = 32;
		
		//Die Frage ist, gehört sowas in die View oder in den Controller?
		try {
			result = Integer.parseInt(_temperatureFTf.getText());
		} catch (NumberFormatException e)
		{
			setWarningRed();
			return result;
		}
		
		setWarningBlack();
		return result;
	}
	
	
	//Pulling, man könnte auch das Model pushen lassen.
	@Override
	public void update(Observable arg0, Object arg1) {
        if (arg0 instanceof TemperaturModel) {
        	TemperaturModel temperatur = (TemperaturModel) arg0;
            int celsius = temperatur.getCelsius();
            int fahrenheit = temperatur.getfFahrenheit();
            _temperatureCTf.setText(Integer.toString(celsius));
            _temperatureFTf.setText(Integer.toString(fahrenheit));
            
            _celsiusSlider.setValue(celsius);
            _fahrenheitSlider.setValue(fahrenheit);
        }
	}
	
	private void setWarningBlack()
	{
		_warningLabel.setForeground(Color.BLACK);
		_warningLabel.setText(Ganzzahl);
	}
	
	private void setWarningRed()
	{
		_warningLabel.setForeground(Color.RED);
		_warningLabel.setText(Ganzzahl_AZ);
	}
}
