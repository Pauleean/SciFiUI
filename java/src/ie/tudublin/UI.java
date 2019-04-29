package ie.tudublin;

import java.util.ArrayList;
import processing.core.PVector;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends AbsUI {
    Scanner scanner;
    Location location;
    boolean mouseDown;
    ArrayList<Planet> Planets = new ArrayList<Planet>();

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
            Planets.add(planet);
        }
    }

    public void draw()
    {
        background(0);
        location.drawMainScreen();


        for(int i = Objects.size()-1; i>-1; i--)
        {
            Objects.get(i).render();
            Objects.get(i).update();
        }

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }

    public void mousePressed()
    {
        for(Planet planet:Planets)
        {
            PVector pos = planet.getPos();
            float rad = planet.getSize()/2.0f;
            if(mouseX > pos.x && mouseX < pos.x+(2*rad) && mouseY > pos.y && mouseY < pos.y+(2*rad))
            {
                if(!planet.isScanning())
                {
                    planet.setScanning(true);
                    Scanner scanner = new Scanner(this, rad, pos.x+rad, pos.y+rad, planet);
                    Objects.add(scanner);
                }

                if(planet.isScaned())
                {
                    String[] a = {"UI"};
                    processing.core.PApplet.runSketch(a, new OrbitalView(planet));
                }
            }
        }
    }

    public void mouseClicked()
    {
        mouseDown = false;
    }

    public void scanComp(Scanner s)
    {
        Objects.remove(s);
    }
}

