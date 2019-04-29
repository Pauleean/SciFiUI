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
        size(600, 400);
    }

}