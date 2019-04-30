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
    boolean scanning;
    boolean deepScaned;
    AbsUI ui2;

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
        scanning = false;
        deepScaned = false;
        counter = 0;
        ui2 = null;
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
            ui.text("Mass: " + mass + "M☉", pos.x - 10, pos.y + offset);
        }
        if(counter >= 3)
        {
            ui.text("Iron: " + iron + "%", pos.x - 10, pos.y + (2*offset));
        }
        if(counter >= 4)
        {
            ui.text("Gold: " + gold + "%", pos.x - 10, pos.y + (3*offset));
        }
        if(counter >= 5)
        {
            ui.text("Uranium: " + uranium + "%", pos.x - 10, pos.y + (4*offset));
        }
    }

    public void renderOrbit(float x, float y, float w)
    {
        ui2.image(getImg(), x, y, w, w);
        ui2.rect(x, y+w, 250, 100);
        ui2.textSize(28);
        ui2.text(name, x+125, y+w+50);

        ui2.textSize(12);
        ui2.text("No technology detected.", x+125, y+w+125);

        float offset = ui2.height/8.0f;

        ui2.strokeWeight(2);
        for(int i=0; i<8; i++)
        {
            ui2.rect(0, i*offset, x, offset);
        }
        float pos = offset/2.0f;

        ui2.text("Mass: " + mass + "M☉", x/2.0f, pos);
        pos += offset;
        ui2.text("Iron: " + iron + "%", x/2.0f, pos);
        pos += offset;
        ui2.text("Gold: " + gold + "%", x/2.0f, pos);
        pos += offset;
        ui2.text("Uranium: " + uranium + "%", x/2.0f, pos);
        pos += offset;

        if(deepScaned)
        {
            ui2.text("Water: " + water + "%", x/2.0f, pos);
            pos += offset;
            ui2.text("Tempureture: " + temp + "K", x/2.0f, pos);
            pos += offset;
            ui2.text("Life signs: " + life, x/2.0f, pos);
            pos += offset;
            ui2.text("Atmosphere: " + atmosphere, x/2.0f, pos);
        }
        else
        {
            ui2.text("Water: ???", x/2.0f, pos);
            pos += offset;
            ui2.text("Tempureture: ???", x/2.0f, pos);
            pos += offset;
            ui2.text("Life signs: ???", x/2.0f, pos);
            pos += offset;
            ui2.text("Atmosphere: ???", x/2.0f, pos);
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

    /**
     * @param water the water to set
     */
    public void setWater(float water) {
        this.water = water;
    }

    /**
     * @return the scanning
     */
    public boolean isScanning() {
        return scanning;
    }

    /**
     * @param scanning the scanning to set
     */
    public void setScanning(boolean scanning) {
        this.scanning = scanning;
    }

    /**
     * @return the deepScaned
     */
    public boolean isDeepScaned() {
        return deepScaned;
    }

    /**
     * @param deepScaned the deepScaned to set
     */
    public void setDeepScaned(boolean deepScaned) {
        this.deepScaned = deepScaned;
    }

    /**
     * @return the ui2
     */
    public AbsUI getUi2() {
        return ui2;
    }

    /**
     * @param ui2 the ui2 to set
     */
    public void setUi2(AbsUI ui2) {
        this.ui2 = ui2;
    }
}