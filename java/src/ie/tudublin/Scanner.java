package ie.tudublin;

public class Scanner
{
    UI ui;
    float rad;
    float time;
    float percent;
    float x;
    float y;
    float dispTime;
    String mat;
    boolean scan;

    public Scanner(UI ui, float rad, float x, float y, String mat)
    {
        this.ui = ui;
        this.rad = rad;
        this.percent = 0;
        this.x = x;
        this.y = y;
        this.mat = mat;
        dispTime = 2;
    }

    public void render()
    {
        ui.noFill();
        ui.textAlign(UI.CENTER, UI.CENTER);
        ui.stroke(0, 150, 0);
        ui.ellipse(x, y, 2*rad, 2*rad);
        ui.fill(0, 150 , 0);

        //draw crosshair
        for(int i=0; i<4; i++)
        {
            float pos = UI.map(i, 0, 4, 0, 6.28f);
            ui.line((float)(x + (rad * Math.sin(pos))), (float)(y - (rad * Math.cos(pos))), (float)(x + (0.25f * (rad * Math.sin(pos)))), (float)(y - (0.25f * (rad * Math.cos(pos)))));
        }

        //draw notches
        for(int i=0; i<10; i++)
        {
            float pos = UI.map(i, -1, 10, 0, 1.57f);
            ui.line((float)(x + (rad * Math.sin(pos))), (float)(y - (rad * Math.cos(pos))), (float)(x + (0.9f * (rad * Math.sin(pos)))), (float)(y - (0.9f * (rad * Math.cos(pos)))));
        }

        //draw status bar
        if(percent < 100)
        {
            ui.arc(x, y, rad/2.0f, rad/1.5f, 0.0f, UI.map(percent, 0.0f, 100.0f, 0.0f, 6.28f));
        }
        else
        {
            ui.text(mat, x, y);
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
}