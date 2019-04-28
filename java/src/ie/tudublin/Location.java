package ie.tudublin;

import processing.core.PImage;

public class Location
{
    UI ui;
    int height;
    int width;
    PImage Stars;
    PImage Sun;

    public Location(UI ui, int height, int width)
    {
        this.ui = ui;
        this.height = height;
        this.width = width;
        Stars = ui.loadImage("Stars.png");
        Sun = ui.loadImage("Sun.png");
    }

    public void drawMainScreen()
    {
        ui.image(Stars, 0, 0, 1200, 600);
        ui.image(Sun, 0, 0, 150, 150);
    }

    /**
     * @return the ui
     */
    public UI getUi() {
        return ui;
    }

    /**
     * @param ui the ui to set
     */
    public void setUi(UI ui) {
        this.ui = ui;
    }
}