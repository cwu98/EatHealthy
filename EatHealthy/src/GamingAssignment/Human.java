package GamingAssignment;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * The human class
 * @author caryw
 *
 */
public class Human {
	
	PApplet foo;
	
	private final static String HUMAN_IMAGE = "julia.png"; //image of a person
	
	private PImage img; //holds human image
	
	//position variables
	private int x;
	private int y; 
	
	private int x_speed = 0; //speed moving left/right
	
	/**
	 * reference to PApplet class
	 * @param foo
	 */
	public Human(PApplet foo) {
		//initial properties 
		this.foo = foo; //keep reference to PApplet class
	
		//load image
		this.img = foo.loadImage(Human.HUMAN_IMAGE);
		
		//resize image
		this.img.resize(150, 200);

		//position the image
		this.x = (int) (foo.width/2 - this.img.width/2); 
		this.y = foo.height - this.img.height;
	}
	
	/**
	 * getter height method
	 * @return int image height
	 */
	public int getH() {
		return this.img.height;
	}
	
	/**
	 * getter width method
	 * @return int image width
	 */
	public int getW() {
		return this.img.width;
	}
	
	/**
	 * getter x-position method
	 * @return int x-coordinate of image
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * getter y-position methd
	 * @return int y-coordinate of image
	 */
	public int getY() {
		return this.y;
	}
	
	
	/**
	 * setter for speed that the human can move
	 */
	public void setSpeed(int X) {
		this.x_speed = x_speed;
	}
	
	public void oppositeDirection() {
		this.x_speed = -this.x_speed; //negates speed, changes direction in x
	}
	
	public void draw() {
		foo.image(this.img, this.x, this.y);
	}
	/**
	 * moves the human but updatign position
	 */
	public void move() {
		int newX = this.x + this.x_speed;
		
		//checking bounds
		boolean outOfBoundsLeft = newX < 0;
		boolean outOfBoundsRight = newX > 1000;
		
		//if out of bounds
		if(outOfBoundsLeft || outOfBoundsRight) {
			oppositeDirection();
			newX = this.x + this.x_speed; //moving in new direction
		}
		
		this.x = newX;
		this.x_speed = 0;
	}
	
	/**
	 * sets to negative speed in x direction for moving left
	 */
	public void moveLeft() {
		this.x_speed = 30;
		this.x_speed = -Math.abs(this.x_speed); //moves towards -x
		
	}
	
	/**
	 * sets to positive speed in x direction for moving right
	 */
	public void moveRight() {
		this.x_speed = 30;
		this.x_speed = Math.abs(this.x_speed); //moves along +x
		
	}
	
	
}
