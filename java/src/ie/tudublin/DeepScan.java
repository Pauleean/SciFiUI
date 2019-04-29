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
        super(ui, x1, y1, size);
        this.scanX = x2;
        this.scanY = y2;
        this.scanLen = len;
        this.scanHeight = hight;
        count = 5;
        scanning = false;
    }

    public void render()
    {
        ui.rect(scanX, scanY, scanLen, scanHeight);

        if(count == 5)
        {
            ui.text("Deep scan", scanX + (scanLen/2.0f), scanY + (scanHeight/2.0f));
        }
    }

    public void update()
    {

    }
}