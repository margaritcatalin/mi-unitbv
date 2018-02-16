package abstarct;

import java.awt.Color;

abstract class GraphicObject {
private int x,y;
private Color color=Color.black;
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public Color getColor() {
	return color;
}
public void setColor(Color color) {
	this.color = color;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
abstract void draw();
}
