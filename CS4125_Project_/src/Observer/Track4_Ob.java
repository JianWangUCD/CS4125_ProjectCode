package Observer;

import java.util.ArrayList;

public class Track4_Ob implements Observer{
	
    private Subject S_monitor;
    ArrayList<Double>speeds;
    ArrayList<String>drivernames;
    ArrayList<String>carNames;
	public Track4_Ob(Subject Speed_monitor)
	{
		this.S_monitor = S_monitor;
		Speed_monitor.registerOb(this);
		
	}
	@Override
	public void update(ArrayList<Double>speeds, ArrayList<String>drivernames, ArrayList<String>carNames) {
		this.speeds = speeds;
		this.drivernames = drivernames;
		this.carNames = carNames;
	
	}
	public double Track4_speed()
	{
		return this.speeds.get(3);
	}
	
	public String Track4_drivernames()
	{
		return this.drivernames.get(3);
	}
	public String Track4_carnames()
	{
		return this.carNames.get(3);
	}

}
