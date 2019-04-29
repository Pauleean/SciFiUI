package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet {
    Scanner scanner;
    Location location;
    boolean mouseDown;
    ArrayList<DisplayObject> Objects = new ArrayList<DisplayObject>();

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
        size(1200, 600);
        // Use fullscreen instead of size to make your interface fullscreen
        //fullScreen(); 
    }

    public void setup()
    {
        location = new Location(this, height, width);
        strokeWeight(3);
        
        Table table = loadTable("Planets.csv", "header");

        for(TableRow row : table.rows())
        {
            Planet planet = new Planet(this, row);
            Objects.add(planet);
        }
    }

    public void draw()
    {
        background(0);
        location.drawMainScreen();


        for(int i = Objects.size()-1; i>-1; i--)
        {
            Objects.get(i).render();
        }
        
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

