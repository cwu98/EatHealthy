package GamingAssignment;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * The fruit class that makes fruits appear from the ceiling
 * @author caryw
 *
 */
public class Fruits {
	EatHealthy foo;
	
	private final static String FRUIT_IMAGE_PATH= "src/banana.png"; //banana image file
	
	private PImage img; //holds fruit image
	
	private boolean notEaten = true; //flag 
	
	private int x = 100; //x coord of this object's location on the screen
	private int y = 300; //y coord of this object's location on the screen
	
	private int maxSpeed = 5; //max speed the object moves
	
	private int speedY = 2; //when moving along y direction, 
	
	/**
	 * accepts reference to parent object
	 * @param foo parent object that is a child of the PApplet class
	 */
	
	public Fruits(EatHealthy foo) {
		//set up initial properties for fruits
		
		this.foo = foo;
		
		//load image and store in PImage var
		this.img = foo.loadImage(Fruits.FRUIT_IMAGE_PATH);
		
		//resize image
		this.img.resize(70,100);
		
		//add this object to the PApplet's list of fruits
		this.foo.fruits.add(this);
		
	
		
		//random location for fruit in x direction
		this.x = (int)(Math.random() * foo.width-this.img.width);
		this.y = 10;
		
		//random speed in y direction
		this.speedY = (int)(Math.random() * this.maxSpeed+1);
		
			
	}
		/**
		 * Get the height of fruit img
		 * @return int height of img
		 */
		public int getH() {
			return this.img.height;
		}
		
		/**
		 * Get the width of fruit img
		 * @return int width of img
		 */
		public int getW() {
			return this.img.width;
		}
		
		/**
		 * Get the x-position of fruit img
		 * @return x coordinate of img
		 */
		public int getX() {
			return this.x;
		}
		
		/**
		 * Get the y-position of the fruit img
		 * @return y-coordinate of img
		 */
		public int getY() {
			return this.y;
		}
	
		/**
		 * update the object's position
		 */
		public void move() {
			//update x and y by speedY amount
			int newY = this.y + this.speedY;
			
			//check bounds
			boolean outOfBottomBound = newY > 1000;
			
			//if out of bounds, remove
			if (outOfBottomBound) {
				foo.fruits.remove(this);
			}
			
			//update position
			this.y = newY;
		}
		/**
		 * eat the fruit
		 */
		public void eat() {
			this.notEaten = false; //change boolean notEaten
			foo.fruits.remove(this); //remove this fruit
		}
		
		/**
		 * static method to check if human ate the fruit
		 * @return boolean human ate fruit or not
		 */
		public static boolean ateFruit(Fruits fruit, Human eater ) {
			boolean eaten = false; //flag
			
			//check if fruit "touches" human img
			if(fruit.getX() >= eater.getX() && fruit.getX() + fruit.getW() <= eater.getX() + eater.getW()
			&& fruit.getY() >= eater.getY() && fruit.getY() + fruit.getH() <= eater.getY() + eater.getH()) {
					eaten = true;
				}
			
			return eaten;
		}
		
		
		/**
		 * draw this object to the parent object's screen
		 */
		public void draw() {
			if(this.notEaten) {
				foo.image(this.img, this.x, this.y);	
			}
				
		}
				
}
