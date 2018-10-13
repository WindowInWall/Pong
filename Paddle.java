package w5d1;

import apcs.Window;

public class Paddle {

	int recWidth;
	int recHeight;
	String recColor;
	int recPixelDist;
	int totalHeight;
	int recX;
	int recY;

	enum Direction {
		UP, DOWN
	};

	Paddle(int recWidth, int recHeight, String recColor, int recPixelDist, int recX, int recY, int totalHeight) {
		this.recWidth = recWidth;
		this.recHeight = recHeight;
		this.recColor = recColor;
		this.recPixelDist = recPixelDist;
		this.recX = recX;
		this.recY = recY;
		this.totalHeight = totalHeight;
	}

	public void draw() {
		Window.out.color(recColor);
		Window.out.rectangle(this.recX, this.recY, recWidth, recHeight);
	}

	public void move(Direction dir) {
		switch (dir) {
		case UP:
			if (this.recY >= (this.recHeight / 2)) {
				this.recY -= 1;
			}
			break;
		case DOWN:
			if (this.recY <= this.totalHeight - (this.recHeight / 2)) {
				this.recY += 1;
			}
			break;
		}
	}

}