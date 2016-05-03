package auroratech.traber.common.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by E on 4/28/2016.
 *
 *  TODO:
 */
public class TBSimpleCrossBox extends View {
    public TBSimpleCrossBox(Context context) {
        super(context);
    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int w = getWidth();
        int h = getHeight();

        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(0xFF000000);  // alpha.r.g.b
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setStrokeWidth(2);

        canvas.drawLine(0, 0, w, h, p);
        canvas.drawLine(0, h, w, 0, p);

        canvas.drawRect(0, 0, w, h, p);

    }
}
