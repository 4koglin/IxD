import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TemperaturController {
	private TemperaturView _temperaturView;
	private TemperaturModel _temperaturModel;
	
	//Der Controller ist jetzt nicht als eigener ActionListener implementiert, kann man also noch machen
	public TemperaturController()
	{
		
		_temperaturModel = new TemperaturModel();
		_temperaturView = new TemperaturView(_temperaturModel);
		
		_temperaturView.setCelsiusSliderChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				_temperaturModel.setCelsius(_temperaturView.getSliderCelsius());
			}
		});
		
		_temperaturView.setCtFButtonListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				_temperaturModel.convertCtoF(_temperaturView.getTFCelsius());
			}
		});
		
		_temperaturView.setFahrenheitSliderChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				_temperaturModel.setFahrenheit(_temperaturView.getSliderFahrenheit());
			}
		});
		
		_temperaturView.setFtCButtonListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				_temperaturModel.convertFtoC(_temperaturView.getTFFahrenheit());
			}
		});
	}
	
	
}
