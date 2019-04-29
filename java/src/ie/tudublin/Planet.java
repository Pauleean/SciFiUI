package ie.tudublin;

import processing.core.PImage;
import processing.data.TableRow;

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
    float water;
    float counter;

    public Planet(UI ui, TableRow data)
    {
        super(ui, data.getFloat("size"), data.getFloat("x"), data.getFloat("y"));
        this.name = data.getString("name");
        this.mass = data.getFloat("mass");
        this.iron = data.getFloat("iron");
        this.gold = data.getFloat("gold");
        this.uranium = data.getFloat("uranium");
        this.water = data.getFloat("water");
        this.temp = data.getFloat("temp");
        this. life = data.getString("life");
        this. atmosphere = data.getString("atmosphere");
        img = ui.loadImage(data.getString("Image"));
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

    /**
     * @return the scaned
     */
    public boolean isScaned() {
        return scaned;
    }

    /**
     * @param scaned the scaned to set
     */
    public void setScaned(boolean scaned) {
        this.scaned = scaned;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mass
     */
    public float getMass() {
        return mass;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(float mass) {
        this.mass = mass;
    }

    /**
     * @return the iron
     */
    public float getIron() {
        return iron;
    }

    /**
     * @param iron the iron to set
     */
    public void setIron(float iron) {
        this.iron = iron;
    }

    /**
     * @return the gold
     */
    public float getGold() {
        return gold;
    }

    /**
     * @param gold the gold to set
     */
    public void setGold(float gold) {
        this.gold = gold;
    }

    /**
     * @return the uranium
     */
    public float getUranium() {
        return uranium;
    }

    /**
     * @param uranium the uranium to set
     */
    public void setUranium(float uranium) {
        this.uranium = uranium;
    }

    /**
     * @return the atmosphere
     */
    public String getAtmosphere() {
        return atmosphere;
    }

    /**
     * @param atmosphere the atmosphere to set
     */
    public void setAtmosphere(String atmosphere) {
        this.atmosphere = atmosphere;
    }

    /**
     * @return the temp
     */
    public float getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(float temp) {
        this.temp = temp;
    }

    /**
     * @return the life
     */
    public String getLife() {
        return life;
    }

    /**
     * @param life the life to set
     */
    public void setLife(String life) {
        this.life = life;
    }

    /**
     * @return the water
     */
    public Float getWater() {
        return water;
    }

    /**
     * @param water the water to set
     */
    public void setWater(Float water) {
        this.water = water;
    }

    /**
     * @return the counter
     */
    public float getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(float counter) {
        this.counter = counter;
    }
}