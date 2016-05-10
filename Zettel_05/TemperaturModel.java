public class TemperaturModel extends java.util.Observable
{
	private int _celsius, _fahrenheit;
	
	public TemperaturModel()
	{
		setCelsius(0);
		setFahrenheit(0);
	}
	
	public int getCelsius()
	{
		return _celsius;
	}
	
	public int getfFahrenheit()
	{
		return _fahrenheit;
	}
	
	public void setCelsius(int celsius)
	{
		_celsius = celsius;
        setChanged();
        notifyObservers();
	}
	
	public void setFahrenheit(int fahrenheit)
	{
		_fahrenheit = fahrenheit;
        setChanged();
        notifyObservers();
	}
	
	public void convertFtoC(int fahrenheit)
	{
		_celsius = Math.round((fahrenheit - 32)*5/9);
		setFahrenheit(fahrenheit);
	}
	
	public void convertCtoF(int celsius)
	{	
		_fahrenheit = Math.round((celsius*(float)1.8)+32);
		setCelsius(celsius);
	}
	
}
