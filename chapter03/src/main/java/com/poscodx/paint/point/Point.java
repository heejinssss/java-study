package com.poscodx.paint.point;

import com.poscodx.paint.i.Drawable;

public class Point implements Drawable {
	private int x;
	private int y;

	// ColorPoint.java에서 부모 생성자를 직접 호출함
//	public Point() {
//	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void show(boolean visible) {
		if (visible) {
//			System.out.println("점(" + x + ", " + y + ")을 그렸습니다.");
			show();
		} else {
			System.out.println("점(" + x + ", " + y + ")을 지웠습니다.");
		}
	}

	public void show() {
		System.out.println("점(" + x + ", " + y + ")을 그렸습니다.");
	}

	@Override
	public void draw() {
		show();
	}
//	public void disappear() {
//		System.out.println("점(" + x + ", " + y + ")을 지웠습니다.");
//	}
}
