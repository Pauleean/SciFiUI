package ie.tudublin;

import processing.core.PVector;

public class DisplayObject
{
    UI ui;
    float size;
    PVector pos = new PVector();

    public DisplayObject(UI ui, float size, float x, float y)
    {
        this.ui = ui;
        this.size = size;
        pos.x = x;
        pos.y = y;
    }
}