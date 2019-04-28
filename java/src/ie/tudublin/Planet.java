package ie.tudublin;

import processing.core.PImage;

public class Planet extends DisplayObject
{
    PImage img;

    public Planet(UI ui, float size, float x, float y, PImage img)
    {
        super(ui, size, x, y);
        this.img = img;
    }
}