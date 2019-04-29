package ie.tudublin;

public class Scanner extends DisplayObject
{
    float time;
    float percent;
    float dispTime;
    Planet planet;

    public Scanner(UI ui, float size, float x, float y, Planet planet)
    {
        super(ui, size, x, y);
        this.percent = 0;
        this.planet = planet;
        dispTime = 1;
    }

    public void render()
    {
        ui.colorMode(UI.RGB);
        ui.fill(0, 150 , 0);
        ui.noFill();
        ui.textAlign(UI.CENTER, UI.CENTER);
        ui.stroke(0, 150, 0);

        if(percent < 100)
        {
            ui.ellipse(pos.x, pos.y, 2.4f*size, 2.4f*size);
            //draw crosshair
            for(int i=0; i<4; i++)
            {
                float rote = UI.map(i, 0, 4, 0, 6.28f);
                ui.line((float)(pos.x + (size * Math.sin(rote))), (float)(pos.y - (size * Math.cos(rote))), (float)(pos.x + (1.2f * (size * Math.sin(rote)))), (float)(pos.y - (1.2f * (size * Math.cos(rote)))));
            }

            //draw notches
            for(int i=0; i<10; i++)
            {
                float rote = UI.map(i, -1, 10, 0, 1.57f);
                ui.line((float)(pos.x + (1.2f * size * Math.sin(rote))), (float)(pos.y - (1.2f * size * Math.cos(rote))), (float)(pos.x + (1.1f * (size * Math.sin(rote)))), (float)(pos.y - (1.1f * (size * Math.cos(rote)))));
            }
            ui.noFill();

            //draw status bar
            for(int i=0; i<10; i++)
            {
                float off = UI.map(i, 0, 10, size*2.2f, size*2.4f);
                ui.arc(pos.x, pos.y, off, off, UI.map(percent, 0.0f, 100.0f, 0.0f, -1.57f), 0.0f);
            }
        }
        else
        {
            ui.text("Scan complete", pos.x, pos.y-(size+20));
        }
    }

    public void update()
    {
        if(percent < 100)
        {
            percent = percent + (25/60.0f);
        }
        else
        {
            planet.setScaned(true);
            dispTime -= 1/60.0f;
        }
        if(dispTime <= 0) end();
    }

    public void end()
    {
        ui.scanComp(this);
    }

    /**
     * @return the time
     */
    public float getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(float time) {
        this.time = time;
    }

    /**
     * @return the percent
     */
    public float getPercent() {
        return percent;
    }

    /**
     * @param percent the percent to set
     */
    public void setPercent(float percent) {
        this.percent = percent;
    }

    /**
     * @return the dispTime
     */
    public float getDispTime() {
        return dispTime;
    }

    /**
     * @param dispTime the dispTime to set
     */
    public void setDispTime(float dispTime) {
        this.dispTime = dispTime;
    }

    /**
     * @return the planet
     */
    public Planet getPlanet() {
        return planet;
    }

    /**
     * @param planet the planet to set
     */
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}