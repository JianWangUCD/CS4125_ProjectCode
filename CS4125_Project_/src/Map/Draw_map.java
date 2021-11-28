package Map;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import Driver.Driver;
import Driver.DriverFactory;
import Vehicle.Vehicle;
import Vehicle.VehicleFactory;
import Driver.DriverFactory.DriverTemper;

import java.awt.BasicStroke;

public class Draw_map implements I_Draw_map{
	private int index;
	private int Map_size_x;
	private int Map_size_y;
	private Road road;//may not be used
	
	
	private Lane1 lane1;
	private Lane2 lane2;
	
	
	private IDisplay display;
	private Graphics2D graphics;
	private BufferStrategy buffer;
	private BufferedImage background;
	private final String BACKGROUND_PATH;
	private Point center;
	private Driver driver;
	private Vehicle vehicle;
	
	//private Road road
	
	
	public Draw_map(IDisplay idis, double map_wi, double map_he, Road road,Driver driver)
	{
		System.out.println("Draw_map "+Map_size_x+" "+Map_size_y);

		this.Map_size_x = (int)map_wi;
		this.Map_size_y = (int)map_he;   		
	    this.road = road;//may not be used
	    
	    this.center = new Point((Map_size_x), (Map_size_y));
	    int currentX = (int) center.getX();
        int currentY = (int) center.getY();
        System.out.println("Draw_map class currentX: "+currentX+" currentY "+currentY);
        
        
        
	    this.lane1 = new Lane1();//will use the arraylist
	    this.lane2 = new Lane2();//will use the arraylist  
	    //Point center = new Point(450,25);	
	    //this.vehicle = new VehicleFactory().createVehicle(25, 25, 10, 3, center, road, lane, "yellow.jpg", null);
	    this.driver = driver;	
	    
	    
		this.display = idis;	
		this.BACKGROUND_PATH = "background.png";
		this.background =  create_background();
		this.set_map();
	
	}
	


	public void set_map() //create the graphics of map
	{
		
		this.display.getCanvas().createBufferStrategy(1);
		
		this.buffer = display.getCanvas().getBufferStrategy();
		
        this.graphics = (Graphics2D) buffer.getDrawGraphics();
        
         this.graphics.clearRect(0, 0, 700, 700);
        


	}
	

	
	private void drawVehicle(Vehicle vehicle)
	{
		Point pos = driver.getVehilce().getPosition();
        Point p2 = new Point((int)(pos.x - (vehicle.getVehicleWidth() / 2)), (int)(pos.y - (vehicle.getVehicleLength() / 2)));

        AffineTransform at = new AffineTransform();
        at.rotate(vehicle.getAngle(), p2.x + (vehicle.getVehicleWidth() / 2), p2.y + (vehicle.getVehicleLength() / 2));
        at.translate(p2.x + (vehicle.getVehicleWidth() / 8), p2.y + (vehicle.getVehicleWidth() / 4));

        this.graphics.drawImage(vehicle.getCarImage(), at, null);
	}
	
	
	private void drawLane(Lane1 lane)
	{
		this.graphics.setColor(lane.getLaneColor());
		this.graphics.setStroke(new BasicStroke(lane.getline_width()));
		this.graphics.draw(new Ellipse2D.Double(lane.getX(), lane.getY(), lane.getWi(), lane.getHe()));
		
	}
	
	
	
	private void drawbackground() {
		this.graphics.drawImage(this.background, 0,0,null);
	}
	
	
	public void render() {
		
		
		this.drawbackground();
		this.drawLane(lane1);
		//this.drawLane(lane2);		
        this.drawVehicle(this.driver.getVehilce());
		this.buffer.show();
	}
	
	
	
	
	private BufferedImage create_background()
	{
		
		try {
			
			return ImageIO.read(new File(this.BACKGROUND_PATH));
			

            } 
		
		
		catch (Exception e) {
			
			System.out.print(e);
            return null;
        }
		
	}
		
	
	

}
