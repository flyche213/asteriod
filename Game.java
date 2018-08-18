package Game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;




public class Game {
	
	public static void main(String[] args) 
	{                                                 
		myFrame frame = new myFrame();
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setup();
		frame.run();
}
  
}
	 class myFrame extends JFrame
	 {
		  Image background;
			Image raster;
			Graphics rasterGraphics;
			java.awt.Image Background;
		 
		 

		public void setup() {
			
			raster = this.createImage(this.getWidth(), this.getHeight());
			rasterGraphics = raster.getGraphics();
			
			Background = this.createImage(this.getWidth(), this.getHeight());
			Background = new ImageIcon("Space.jpg").getImage();
			
		}

		public void run() {
			
			rasterGraphics.drawImage(Background,0,0,null);
			
			
		}
		 
	 }
	
	 class Blocks {
		 
				public void draw(Graphics g)
				{
					Vector2D location;
					location = new Vector2D(200,450);
				g.setColor(Color.black);
				
				g.fillRect((int)location.getX(), (int)location.getY(), 100, 50);
				}
	 }
	 class Vector2D 
		{
		    private float x;
		    private float y;

		    public Vector2D() 
		    {
		        this.setX(0);
		        this.setY(0);
		    }
		  

			public Vector2D(float x, float y) 
		    {
		        this.setX(x);
		        this.setY(y);
		    }
		    public Vector2D(Vector2D v) 
		    {
		        this.setX(v.getX());
		        this.setY(v.getY());
		    }
		    public void set(float x, float y) 
		    {
		        this.setX(x);
		        this.setY(y);
		    }

		    public void setX(float x) 
		    {
		        this.x = x;
		    }

		    public void setY(float y) 
		    {
		        this.y = y;
		    }

		    public float getX() 
		    {
		        return x;
		    }

		    public float getY() 
		    {    	
		        return y;
		    }
		    public void rotate(double angle) 
		    {
		    	Vector2D newVect = new Vector2D(this);
				newVect.setX(getX() * (float)Math.cos(Math.toRadians(angle)) + 
						getY() * (float)Math.sin(Math.toRadians(angle)));
				newVect.setY(-getX() * (float)Math.sin(Math.toRadians(angle)) + 
						getY() * (float)Math.cos(Math.toRadians(angle)));
				this.set(newVect.getX(),newVect.getY());
		    }
		    //Specialty method used during calculations of ball to ball collisions.
		    public float dot(Vector2D v2) 
		    {
		    	float result = 0.0f;
		        result = this.getX() * v2.getX() + this.getY() * v2.getY();
		        return result;
		    }

		    public float getLength() 
		    {
		        return (float) Math.sqrt(getX() * getX() + getY() * getY());
		    }

		    public Vector2D add(Vector2D v2) 
		    {
		        Vector2D result = new Vector2D();
		        result.setX(getX() + v2.getX());
		        result.setY(getY() + v2.getY());
		        return result;
		    }

		    public Vector2D subtract(Vector2D v2) 
		    {
		        Vector2D result = new Vector2D();
		        result.setX(this.getX() - v2.getX());
		        result.setY(this.getY() - v2.getY());
		        return result;
		    }

		    public Vector2D multiply(float scaleFactor) 
		    {
		        Vector2D result = new Vector2D();
		        result.setX(this.getX() * scaleFactor);
		        result.setY(this.getY() * scaleFactor);
		        return result;
		    }

		    //Specialty method used during calculations of ball to ball collisions.
		    public Vector2D normalize() 
		    {
		    	float length = getLength();
		        if (length != 0.0f) 
		        {
		            this.setX(this.getX() / length);
		            this.setY(this.getY() / length);
		        } 
		        else 
		        {
		            this.setX(0.0f);
		            this.setY(0.0f);
		        }
		        return this;
		    }
		    public String toString()
		    {
		    	return "("+x+", "+y+")";
		    }
		}








