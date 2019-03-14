package ie.tudublin;

public class Scanner
{
    UI ui;
    float rad;
    float time;
    float percent;
    float x;
    float y;
    String mat;

    public Scanner(UI ui, float rad)
    {
        this.ui = ui;
        this.rad = rad;
        this.percent = 0;
    }

    public void render()
    {
        if(percent > 0)
        {
            ui.noFill();
            ui.stroke(0, 0, 150);
            ui.ellipse(x, y, 2*rad, 2*rad);
            ui.fill(0, 0 , 150);
            ui.arc(x, y, 2*rad, 2*rad, 0.0f, UI.map(percent, 0.0f, 100.0f, 0.0f, 6.28f));
        }
    }

    public void update(float x, float y, String mat, float time)
    {
        this.x = x;
        this.y = y;
        if(percent < 100)
        {
            percent = percent + ((100/time)/60);
        }
    }

    public void end()
    {
        percent = 0;
    }
}