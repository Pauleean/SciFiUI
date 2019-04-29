package ie.tudublin;

import processing.core.PApplet;

public class OrbitalView extends PApplet
{
    Planet planet;

    public OrbitalView(Planet planet)
    {
        this.planet = planet;
    }

    public void settings()
    {
        size(500, 500);
    }

    public void setup()
    {
        stroke(0, 150, 0);
        noFill();
    }

    public void draw()
    {
        background(0);
        image(planet.getImg(), 150, 0, 350, 350);
        drawGrid(150, 0, 350, 12);
    }

    public void drawGrid(float x, float y, float len, float num)
    {
        strokeWeight(2);
        rect(x, y, len, len);
        strokeWeight(1);

        for(int i = 0; i < 12; i++)
        {
            float X = map(i, 0, num, x, x+len);
            float Y = map(i, 0, num, y, y+len);

            line(X, y, X, y+len);
            line(x, Y, x+len, Y);
        }
    }
}