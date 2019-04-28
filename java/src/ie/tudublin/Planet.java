package ie.tudublin;

import processing.core.PImage;

public class Planet extends DisplayObject
{
    PImage img;
    boolean scaned;
    String name;
    float mass;
    float iron;
    float gold;
    float uranium;
    String atmosphere;
    float temp;
    String life;
    String water;
    float counter;

    public Planet(UI ui, float size, float x, float y, PImage img)
    {
        super(ui, size, x, y);
        this.img = img;
        scaned = false;
        counter = 0;
    }

    public void render()
    {
        ui.image(img, pos.x, pos.y, size, size);

        float offset = size/5.0f;
        ui.textAlign(UI.CENTER);
        if(counter >= 1)
        {
            ui.text(name, pos.x + (size/2.0f), pos.y - 10);
        }
        ui.textAlign(UI.RIGHT);
        if(counter >= 2)
        {
            ui.text(mass, pos.x - 10, pos.y + offset);
        }
        if(counter >= 3)
        {
            ui.text(iron, pos.x - 10, pos.y + (2*offset));
        }
        if(counter >= 4)
        {
            ui.text(gold, pos.x - 10, pos.y + (3*offset));
        }
        if(counter >= 5)
        {
            ui.text(uranium, pos.x - 10, pos.y + (4*offset));
        }

        update();
    }

    public void update()
    {
        if(scaned && counter < 5)
        {
            counter += 1/60.0f;
        }
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