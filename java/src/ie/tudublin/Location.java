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
        ui.image(Sun, 0, 0, 250, 250);
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

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the stars
     */
    public PImage getStars() {
        return Stars;
    }

    /**
     * @param stars the stars to set
     */
    public void setStars(PImage stars) {
        Stars = stars;
    }

    /**
     * @return the sun
     */
    public PImage getSun() {
        return Sun;
    }

    /**
     * @param sun the sun to set
     */
    public void setSun(PImage sun) {
        Sun = sun;
    }
}