package Thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JComponent;

public class SSaver extends JComponent {
	
	static Random rand = new Random();
	
	Point mPos = new Point();
	String mText;
	int mSpeed;
	
	int mWidth, mHeight;
	
	public SSaver(int width, int height, int speed) {
		mWidth = width;
		mHeight = height;
		
		mPos.x = 0;
		mPos.y = 50 + rand.nextInt(mHeight - 100);
		
		mText = "Hello World!";
		mSpeed = speed;
	}
	
	public void move() {
		mPos.x += mSpeed;
		
		if (mPos.x > mWidth) {
			mPos.x = 0;
			mPos.y = 50 + rand.nextInt(mHeight - 100);
		}
		
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, mWidth, mHeight);
		
		g.setFont(new Font("맑은 고딕", Font.PLAIN, 50));
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawString(mText, mPos.x, mPos.y);
		
	}
}
