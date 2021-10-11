import java.awt.*;

import sun.security.util.Length;

/**
 * A square that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Square
{
    private int size;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    
    /**
     * Create a new square at default position with default color.
     */
    public Square()
    {
        this(30, 50, 60, "red");
        makeVisible();
    }

    /**
     * Create a new square with default color that starts at xStart, yStart
     */
    public Square(int xStart, int yStart) {
        this(30, xStart, yStart, "red");
        makeVisible();
    }
    
    /**
     * Create a new square at a size, starting position, and color
     * Acts as the generic constructor
     */
    public Square(int startSize, int xStart, int yStart, String startColor) {
        size = startSize;
        xPosition = xStart;
        yPosition = yStart;
        color = startColor;
        makeVisible();
    }
    
    /**
     * Create a square at a specified size
     */
    public Square(int startSize) {
        this(startSize, 50, 60, "red");
        makeVisible();
    }
    
    /**
     * Create a square of a specified color
     */
    public Square(String startColor) {
        this(30, 50, 60, startColor);
        makeVisible();
    }
    
    /**
     * Create a square at a specified size and position on the XY-plane
     */
    public Square(int startSize, int xStart, int yStart) {
        this(startSize, xStart, yStart, "red");
        makeVisible();
    }
    
    /**
     * Create a square at a specific size and color
     */
    public Square(int startSize, String startColor) {
        this(startSize, 50, 60, startColor);
        makeVisible();
    }
    
    /**
     * Returns the Square's current position
     */
    public String getPosition() {
        String coords = "(" + xPosition + ", " + yPosition + ")";
        return coords;
    }
    
    /**
     * Returns the current value of the size attribute
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Return the current value of the color attribute
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Reposition the Square to (newX, newY)
     */
    public void reposition(int newX, int newY){
        xPosition = newX;
        yPosition = newY;
        draw();
    }
    
    /**
     * Returns the square to point (0,0)
     */
    public void moveToOrigin()  {
    	xPosition = 0;
    	yPosition = 0;
    	draw();
    }
    
    /**
     * Automates exercise six on lab one
     */
    public void exercise6() {
            isVisible = true;
            changeSize(10);
            moveToOrigin();
            slowMoveHorizontal(290);
            slowMoveVertical(290);
            slowMoveHorizontal(-290);
            slowMoveVertical(-290);
    }
    
    /**
     * Make this square visible. If it was already visible, do nothing.
     */
    public void makeVisible()
    {
        isVisible = true;
        draw();
    }

    /**
     * Make this square invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible()
    {
        erase();
        isVisible = false;
    }

    /**
     * Move the square a few pixels to the right.
     */
    public void moveRight()
    {
        moveHorizontal(20);
    }

    /**
     * Move the square a few pixels to the left.
     */
    public void moveLeft()
    {
        moveHorizontal(-20);
    }

    /**
     * Move the square a few pixels up.
     */
    public void moveUp()
    {
        moveVertical(-20);
    }

    /**
     * Move the square a few pixels down.
     */
    public void moveDown()
    {
        moveVertical(20);
    }

    /**
     * Move the square horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance)
    {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the square vertically by 'distance' pixels.
     */
    public void moveVertical(int distance)
    {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the square horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the square vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance)
    {
        int delta;

        if(distance < 0) 
        {
            delta = -1;
            distance = -distance;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distance; i++)
        {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newSize)
    {
        erase();
        size = newSize;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor)
    {
        color = newColor;
        draw();
    }

    /*
     * Draw the square with current specifications on screen.
     */
    private void draw()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                    new Rectangle(xPosition, yPosition, size, size));
            canvas.wait(10);
        }
    }

    /*
     * Erase the square on screen.
     */
    private void erase()
    {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    public String toString() {
    	return String.format("%s Square with a side length of %d at (%d, %d)", color, size, xPosition, yPosition);
        }
}
