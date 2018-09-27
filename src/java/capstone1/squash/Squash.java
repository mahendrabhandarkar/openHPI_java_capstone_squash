package java.capstone1.squash;

public class Squash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controller controller = new Controller();
		
		Ball ball = new Ball();
		Paddle paddle = new Paddle();
		
		final int rad = 60;	// Radius of the ball
		float xpos;		// Starting position of the ball    
		float ypos;

		float xspeed = (float) 2.5;	// Speed of the ball
		float yspeed = (float) 2.5;  

		int xdirection = 1;	// Left to Right
		int ydirection = 1;	// Top to Bottom
		
		int ppos;	// Tracks changes in paddle position
		
		public float getXpos() {
			return this.xpos;
		}
		
		public float getYpos() {
			return this.ypos;
		}
		
		public void setPos(int pos) {
			this.ppos = pos;
		}
		
		public void move() {
			// Update the position of the ball
			this.xpos = xpos + (xspeed * xdirection);
			this.ypos = ypos + (yspeed * ydirection);
				  
			// Test to see if the ball exceeds the boundaries of the screen
			// If it does, reverse its direction by multiplying by -1
			// Test whether it hits or misses the paddle
			if (xpos > width-rad || xpos < rad) {
				this.xdirection *= -1;
			}
			if ((ypos > height-rad-35 && xpos > 200 + ppos && xpos < 500 + ppos) || ypos < rad) {
				this.ydirection *= -1;
			}
			else if (ypos > height-rad-35 && (xpos < 200 + ppos || xpos > 500 + ppos)) {
				double random = Math.random(); // Determine randomly whether to exit or not
				if (random <= 0.5) {
					// Reset the game
					xpos = width/2;
					ypos = height/2;
					xdirection = 1;
					ydirection = 1;
					controller.setCount(0);
				}
				else {
					exit();
				}
			}
		}

		@Override
		public void settings() {
			// Set the screen
			size(700, 350);
		}
		
		@Override
		public void setup() {
			noStroke();
			frameRate(30);
			ellipseMode(RADIUS);
			// Set the starting position of the ball
			xpos = width/2;
			ypos = height/2;
		}

		@Override
		public void draw() {
			// Draw the screen
			background(255);
			ball.update();
			paddle.update();
		}
		
		@Override
		public void keyPressed() {
			// User moves paddle to the right
			if (key == 'r') {
				controller.setCount(ppos + 1);
			}
			// User moves paddle to the left
			if (key == 'l') {
				controller.setCount(ppos - 1);
			}
	} 
		
	}

}
