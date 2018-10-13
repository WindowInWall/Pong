package w5d1;

import apcs.Window;

public class PongV2 {

	public static void main(String[] args) {

		int width = 1024;
		int height = 512;

		Window.size(width, height);

		int widthMiddle = width / 2;
		int heightMiddle = height / 2;

		int radius = 5;
		String cirColor = "Black";
		int xChange = 1;
		int yChange = 2;

		

		int recWidth = 20;
		int recHeight = 75;
		String recColor = "Red";
		int pixelDist = 1;
		int distFromWall = 30;

		int leftX = recWidth + distFromWall;
		int rightX = width - recWidth - distFromWall;
		
		int startingLeftScore= 0;
		int startingRightScore = 0;

		Paddle leftPaddle = new Paddle(recWidth, recHeight, recColor, pixelDist, leftX, heightMiddle, height);
		Paddle rightPaddle = new Paddle(recWidth, recHeight, recColor, pixelDist, rightX, heightMiddle, height);
		Ball ball = new Ball(radius, widthMiddle, heightMiddle, cirColor, xChange, yChange, height, width, leftPaddle, rightPaddle, startingLeftScore, startingRightScore);

		while (true) {

			Window.frame(1);
			Window.out.background("White");

			ball.move();
			ball.draw();

			leftPaddle.draw();
			rightPaddle.draw();

			// The left paddle goes up if 1 is pressed and down if 2 is pressed
			if (Window.key.pressed("1")) {
				leftPaddle.move(Paddle.Direction.UP);
			}
			if (Window.key.pressed("2")) {
				leftPaddle.move(Paddle.Direction.DOWN);
			}

			// The right paddle goes up if 8 is pressed and down if 9 is pressed
			if (Window.key.pressed("8")) {
				rightPaddle.move(Paddle.Direction.UP);
			}
			if (Window.key.pressed("9")) {
				rightPaddle.move(Paddle.Direction.DOWN);
			}
			
			// Exit if q is pressed
			if (Window.key.pressed("q")) {
				//TODO: find a way to exit the program
			}
		}

	}
}