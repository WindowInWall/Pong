package w5d1;

import apcs.Window;

public class Ball {

	int radius;
	String cirColor;
	int cirX;
	int cirY;
	int xChange;
	int yChange;
	int totalHeight;
	int totalWidth;
	int cirOriginalX;
	int cirOriginalY;
	int leftScore;
	int rightScore;
	Paddle pLeft;
	Paddle pRight;
	

	Ball(int radius, int cirX, int cirY, String cirColor, int xChange, int yChange, int totalHeight, int totalWidth, Paddle pLeft, Paddle pRight, int leftScore, int rightScore) {
		this.radius = radius;
		this.cirX = this.cirOriginalX = cirX;
		this.cirY = this.cirOriginalY = cirY;
		this.cirColor = cirColor;
		this.xChange = xChange;
		this.yChange = yChange;
		this.totalHeight = totalHeight;
		this.totalWidth = totalWidth;
		this.pLeft = pLeft;
		this.pRight = pRight;
		this.leftScore = leftScore;
		this.rightScore = rightScore;
	}

	public void draw() {
		//ball
		Window.out.color(cirColor);
		Window.out.circle(cirX, cirY, radius);
		
		//scores
		Window.out.print("LEFT: " + String.valueOf(leftScore), 384, 30);
		Window.out.print("RIGHT: " + String.valueOf(rightScore), 640, 30);
		
	}

	public void move() {
		cirX += xChange;
		cirY += yChange;
		reflect();
	}

	private void reflect() {
		
		//TODO: fix the reflection problem near the paddle BUGGY AS HELL
		
		// If ball hits the top or bottom
		if (cirY < radius || cirY > totalHeight - radius) {
			yChange = yChange * -1;
		}
		// If the ball hits the paddle on the right it bounces
		else if (cirX >= pRight.recX - pRight.recWidth/2 - radius && cirY <= pRight.recY + (pRight.recHeight / 2) && cirY >= pRight.recY - (pRight.recHeight / 2)) {
			xChange = xChange * -1;
		} 
		// If the ball hits the paddle on the left it bounces
		else if (cirX <= pLeft.recX + pLeft.recWidth/2 + radius && cirY <= pLeft.recY + (pLeft.recHeight / 2) && cirY >= pLeft.recY - (pLeft.recHeight / 2)) {
			xChange = xChange * -1;
		} 
		// If the ball goes past the left paddle it goes back to the middle
		else if (cirX <= 0) {
			cirX = totalWidth / 2;
			cirY = totalHeight / 2;
			xChange = 1;
			yChange = -1;
			rightScore += 1;
		} 
		// If the ball goes past the right paddle it goes back to the middle
		else if (cirX >= totalWidth) {
			cirX = totalWidth / 2;
			cirY = totalHeight / 2;
			xChange = -1;
			yChange = -1;
			leftScore += 1;
		} 
	}
}