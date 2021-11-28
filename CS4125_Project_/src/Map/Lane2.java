package Map;
import java.awt.*;
import java.util.HashMap;

public class Lane2 extends Lane{
	private Point center;
	private int wi;
	private int he;
	private int lane_width;
	private Color lane_Color;
	private double angle_per_cell;// every single space has a specified angle
	private int number_of_cells;
	
	
	public Lane2()
	{
		this.center = new Point();
		center.x = 525;
		center.y = 50;
		this.wi = 556;
		this.he = 556;
		this.lane_width = 25;
		this.number_of_cells = 1000;
		this.angle_per_cell = 360/this.number_of_cells;
		this.lane_Color =  new Color(87, 73, 76);
		

	}
	public int getX() {
		return this.center.x / 2;
	}

	public int getY() {
		return this.center.y / 2;
	}

	public int getWi() {
		return this.wi;
	}

	public int getHe() {
		return this.he;
	}
	
	public int getline_width()
	{
		return this.lane_width;
	}

	public int getNumCells() {
		return this.number_of_cells;
	}
	
	public Color getLaneColor() {
		return lane_Color;
	}
	
	public Point get_Position(int cell_index)// need to be modified
	{
		Point p = new Point();
		double angele = this.angle_per_cell*(cell_index % this.number_of_cells);
		return p;
		
	}

}
