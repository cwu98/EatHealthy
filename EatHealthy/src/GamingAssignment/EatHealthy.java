package GamingAssignment;
import java.util.ArrayList;
import processing.core.*;
import GamingAssignment.Fruits;
import GamingAssignment.Human;

/**
 * *A game that helps my friend, Julia, become healthier by eating more fruits.
 * @author caryw
 * @version 1
 */
public class EatHealthy extends PApplet{
	//instance properties
	
	//declaring height and width of the window
	public final int w = 1200;
	public final int h = 800;
	
	//colors
	public final int BEIGE = color(245,245,220);
	
	
	//variable to hold human
	public Human human;
	
	
	//array to hold fruits 
	public ArrayList<Fruits> fruits = new ArrayList<Fruits>(); //will hold fruits 
	
	//num of fruits eaten counter
	private int score = 0;
	
	//declare font
	PFont f;

	
	/**
	 * Sets up window
	 */
	public void settings() {
		this.size(this.w, this.h); //set window size
	}
	
	/**
	 * Create window and "global" settings
	 */
	public void setup() {
		
		//create font for text
		f = createFont("Arial", 16, true);
		       
		this.background(BEIGE); //set bg color 
		
		//initialize Human
		this.human = new Human(this); //pass reference to this class
		
		//initialize Fruits 
		for (int i=0; i<1; i++) {
			this.fruits.add(new Fruits(this));
		}
		
	}
	
	/**
	 * Called repeatedly, does the actual displaying onto the screen
	 */
	public void draw() {
		//time passed since start of program
		int milsec = this.millis();

		//wipe the screen blank
		this.background(BEIGE);
		
		//text
		this.textFont(f,28);
		this.fill(240,128,128);
		text("Help me eat my fruits!", 400, 40); //description of game
		text("Score: " + score, 10, 150); //display score
		text("Click anywhere to quit",10 ,120); //click to quit
		text("Use L/R arrow keys to move", 10, 90); //instructions	

		//draw the human
		human.draw();
		human.move();
		
	
		//loop through ArrayList of Fruits
		for (int i=0; i<fruits.size();i++) {
			Fruits thisFruit = this.fruits.get(i); //get the current object
			thisFruit.move(); //move the fruit
			thisFruit.draw(); //make it show
		}

		
		//continuously add fruit objects to the screen
		if (moreFruit()) {
			fruits.add(new Fruits(this));
			time = milsec + 3000;
		}
		
		ArrayList<Fruits> fruitsToRemove = new ArrayList<Fruits>();
		
		//detect when human eats fruit
		for (Fruits el : fruits) {
			if (Fruits.ateFruit(el, human)) {
				fruitsToRemove.add(el);
				score++; //accumulate score when fruit is eaten
			}	
		}
		
		//eats the fruit, makes it disappear
		for (Fruits el : fruitsToRemove) {
			el.eat();
		}
		
	
		
	}
	/**
	 * getter for milisec
	 * @return int milisectonds passed since program started
	 */
	public int getTime() {
		return this.millis();
	}
	
	//declare time var
	int time;
	
	/**
	 * sees if it's time for more fruits to appear
	 * @return boolean to make more fruit
	 */
	public boolean moreFruit() {
		return (getTime() >= time);
	}
	
	/**
	 * getter for size of Fruits ArrayList
	 * @return int number of fruits in ArrayList
	 */
	public int getSize() {
		return fruits.size();
	}
	
	/**
	 * controls the human by calling methods from Human class to move left/right based on whether L/R keys are pressed
	 */
	public void keyPressed() {
		if(key == CODED) {
			if(keyCode == LEFT) {
				human.moveLeft();
			}
			else if (keyCode == RIGHT)
				human.moveRight();
			}
		}
	
	/**
	 * exits program when mouse is clicked anywhere on the screen
	 */
	public void mousePressed() {
		exit();
	}
	
	
	public static void main(String[] args) {
		//call PApplet's static main method
		PApplet.main("GamingAssignment.EatHealthy");
	}
}