package ie.tudublin;

import java.util.ArrayList;
import processing.core.PVector;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends AbsUI {
    Scanner scanner;
    Location location;
    ArrayList<Planet> Planets = new ArrayList<Planet>();    

    public void settings()
    {
        size(1200, 600);
    }

    public void setup()
    {
        //Instantaite location
        location = new Location(this, height, width);
        strokeWeight(3);
        
        //Instantate Plantes using data from table
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
        //Draw background
        background(0);
        location.drawMainScreen();

        //Draw Planets and radars
        for(int i = Objects.size()-1; i>-1; i--)
        {
            Objects.get(i).render();
            Objects.get(i).update();
        }
    }

    public void mousePressed()
    {
        for(Planet planet:Planets)
        {
            //Check if planet was clicked on
            PVector pos = planet.getPos();
            float rad = planet.getSize()/2.0f;
            if(mouseX > pos.x && mouseX < pos.x+(2*rad) && mouseY > pos.y && mouseY < pos.y+(2*rad))
            {
                //check if planet is being scaned 
                if(!planet.isScanning())
                {
                    //Instantaite scanner
                    planet.setScanning(true);
                    Scanner scanner = new Scanner(this, rad, pos.x+rad, pos.y+rad, planet);
                    Objects.add(scanner);
                }

                //Check if planet has been scanned
                if(planet.isScaned() && planet.getUi2() == null)
                {
                    //Create new window for single planet
                    String[] a = {"UI"};
                    processing.core.PApplet.runSketch(a, new OrbitalView(planet));
                }
            }
        }
    }
}

