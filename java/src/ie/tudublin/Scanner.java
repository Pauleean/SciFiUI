package ie.tudublin;

public class Scanner extends DisplayObject
{
    float time;
    float percent;
    float dispTime;
    String mat;
    boolean scan;

    public Scanner(UI ui, float size, float x, float y, String mat)
    {
        super(ui, size, x, y);
        this.percent = 0;
        this.mat = mat;
        dispTime = 2;
    }

    public void render()
    {
        ui.colorMode(UI.RGB);
        ui.noFill();
        ui.textAlign(UI.CENTER, UI.CENTER);
        ui.stroke(0, 150, 0);
        ui.ellipse(pos.x, pos.y, 2*size, 2*size);
        ui.fill(0, 150 , 0);

        //draw crosshair
        for(int i=0; i<4; i++)
        {
            float rote = UI.map(i, 0, 4, 0, 6.28f);
            ui.line((float)(pos.x + (size * Math.sin(rote))), (float)(pos.y - (size * Math.cos(rote))), (float)(pos.x + (0.25f * (size * Math.sin(rote)))), (float)(pos.y - (0.25f * (size * Math.cos(rote)))));
        }

        //draw notches
        for(int i=0; i<10; i++)
        {
            float rote = UI.map(i, -1, 10, 0, 1.57f);
            ui.line((float)(pos.x + (size * Math.sin(rote))), (float)(pos.y - (size * Math.cos(rote))), (float)(pos.x + (0.9f * (size * Math.sin(rote)))), (float)(pos.y - (0.9f * (size * Math.cos(rote)))));
        }
        ui.noFill();

        //draw status bar
        if(percent < 100)
        {
            //ui.arc(x, y, size/2.0f, size/2.0f, 0.0f, UI.map(percent, 0.0f, 100.0f, 0.0f, 6.28f));
            for(int i=0; i<10; i++)
            {
                float off = UI.map(i, 0, 10, size*1.8f, size*2.0f);
                ui.arc(pos.x, pos.y, off, off, UI.map(percent, 0.0f, 100.0f, 0.0f, -1.57f), 0.0f);
            }
        }
        else
        {
            ui.text(mat, pos.x, pos.y);
        }

        if(dispTime <= 0) end();
    }

    public void update(float x, float y,  float time)
    {
        if(percent < 100)
        {
            percent = percent + ((100/time)/60.0f);
        }
        else
        {
            dispTime -= 1/60.0f;
        }
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
     * @return the mat
     */
    public String getMat() {
        return mat;
    }

    /**
     * @param mat the mat to set
     */
    public void setMat(String mat) {
        this.mat = mat;
    }

    /**
     * @return the scan
     */
    public boolean isScan() {
        return scan;
    }

    /**
     * @param scan the scan to set
     */
    public void setScan(boolean scan) {
        this.scan = scan;
    }
}