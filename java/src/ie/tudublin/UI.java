package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class UI extends PApplet {
    Button b;
    MovingCircle mc;
    Radar r;
    Scanner scanner;
    Location location;
    boolean mouseDown;
    ArrayList<PImage> Planets = new ArrayList<PImage>();

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        location = new Location(this, height, width);
        strokeWeight(3);
        
        for(int i=1; i<6; i++)
        {
            
        }
    }

    public void draw()
    {
        background(0);
        location.drawMainScreen();
        
        if(scanner != null)
        {
            scanner.update(mouseX, mouseY, 4);
            scanner.render();
        }

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }

    public void mousePressed()
    {
        scanner = new Scanner(this, 100, mouseX, mouseY, "Iron");
    }

    public void mouseClicked()
    {
        mouseDown = false;
    }

    public void scanComp(Scanner s)
    {
        scanner = null;
    }
}

