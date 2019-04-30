package ie.tudublin;

public class DeepScan extends DisplayObject
{
    float scanX;
    float scanY;
    float scanLen;
    float scanHeight;
    float count;
    boolean scanning;
    boolean scanned;

    public DeepScan(AbsUI ui, float x1, float y1, float x2, float y2, float size, float len, float hight)
    {
        super(ui, size, x1, y1);
        this.scanX = x2;
        this.scanY = y2;
        this.scanLen = len;
        this.scanHeight = hight;
        count = 5;
        scanning = false;
        scanned = false;
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
                ui.stroke(150, 0, 0);
                float Y = UI.map(count, 5, 0, pos.y, pos.y+size);
                ui.line(pos.x, Y, pos.x+size, Y);

                ui.stroke(0, 150, 0);
                ui.text("Scanning. . .", scanX+(scanLen/2.0f), scanY+(scanHeight/2.0f));
            }
            else
            {
                ui.text("Scan\ncomplete", scanX+(scanLen/2.0f), scanY+(scanHeight/2.0f));
                scanned = true;
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

    /**
     * @return the scanX
     */
    public float getScanX() {
        return scanX;
    }

    /**
     * @param scanX the scanX to set
     */
    public void setScanX(float scanX) {
        this.scanX = scanX;
    }

    /**
     * @return the scanY
     */
    public float getScanY() {
        return scanY;
    }

    /**
     * @param scanY the scanY to set
     */
    public void setScanY(float scanY) {
        this.scanY = scanY;
    }

    /**
     * @return the scanLen
     */
    public float getScanLen() {
        return scanLen;
    }

    /**
     * @param scanLen the scanLen to set
     */
    public void setScanLen(float scanLen) {
        this.scanLen = scanLen;
    }

    /**
     * @return the scanHeight
     */
    public float getScanHeight() {
        return scanHeight;
    }

    /**
     * @param scanHeight the scanHeight to set
     */
    public void setScanHeight(float scanHeight) {
        this.scanHeight = scanHeight;
    }

    /**
     * @return the count
     */
    public float getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(float count) {
        this.count = count;
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
     * @return the scanned
     */
    public boolean isScanned() {
        return scanned;
    }

    /**
     * @param scanned the scanned to set
     */
    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }
}