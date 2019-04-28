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

    public void render()
    {
        ui.image(img, pos.x, pos.y, size, size);
    }

    /**
     * @return the img
     */
    public PImage getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(PImage img) {
        this.img = img;
    }
}