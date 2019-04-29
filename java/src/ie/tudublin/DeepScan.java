package ie.tudublin;

public class DeepScan extends DisplayObject
{
    float scanX;
    float scanY;
    float scanLen;
    float scanHeight;
    float count;
    boolean scanning;

    public DeepScan(AbsUI ui, float x1, float y1, float x2, float y2, float size, float len, float hight)
    {
        super(ui, size, x1, y1);
        this.scanX = x2;
        this.scanY = y2;
        this.scanLen = len;
        this.scanHeight = hight;
        count = 5;
        scanning = false;
    }

    public void render()
    {
        ui.strokeWeight(2);
        ui.rect(scanX, scanY, scanLen, scanHeight);

        if(count == 5)
        {
            ui.text("Deep scan", scanX + (scanLen/2.0f), scanY + (scanHeight/2.0f));
        }
        else
        {
            if(count > 0)
            {
                ui.strokeWeight(4);
                float Y = UI.map(count, 5, 0, pos.y, pos.y+size);
                ui.line(pos.x, Y, pos.x+size, Y);

                ui.text("Scanning. . .", scanX+(scanLen/2.0f), scanY+(scanHeight/2.0f));
            }
            else
            {
                ui.text("Scan\ncomplete", scanX+(scanLen/2.0f), scanY+(scanHeight/2.0f));
            }
        }
    }

    public void update()
    {
        if(scanning && count > 0)
        {
            count -= 1/60.0f;
        }
    }

    public void startScan()
    {
        scanning = true;
    }
}