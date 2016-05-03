package auroratech.traber.common.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import auroratech.traber.R;

/**
 * Created by E on 4/28/2016.
 */
public class TBChatTriangleShape extends View {

    boolean isLeftArrow;
    boolean isRightArrow;

    public TBChatTriangleShape(Context context) {
        super(context);
    }


    public TBChatTriangleShape(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TBChatTriangleShape,
                0, 0);

        try {
            isLeftArrow = a.getBoolean(R.styleable.TBChatTriangleShape_isLeftArrow, false);
            isRightArrow = a.getBoolean(R.styleable.TBChatTriangleShape_isRightArrow, false);
        } finally {
            a.recycle();
        }

        // set back ground to always be transparent
        setBackgroundColor(Color.TRANSPARENT);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth() / 2;
        int w_by4 = getWidth() / 4;
        int h_by4 = getHeight() / 4;

        Path path = new Path();

        /*

        example:

        -------
        |   \  |
        |    \ |
        |     \|
        |      |
        |      |
        |      |
        -------

        path.moveTo( w, 0);
        path.lineTo( 2 * w , 0);
        path.lineTo( 2 * w , w);
        path.lineTo( w , 0);

        */

        if(isRightArrow) {

            path.moveTo( 0, h_by4);
            path.lineTo( 3 * w_by4 , 2 * h_by4);
            path.lineTo( 0 , 3 * h_by4);
            path.moveTo( 0, h_by4);

        } else if (isLeftArrow) {

            path.moveTo( 2 * w, h_by4);
            path.lineTo( w_by4 , 2 * h_by4);
            path.lineTo( 2 * w , 3 * w);
            path.moveTo( 2 * w, h_by4);

        }

        path.close();

        Paint p = new Paint();
        p.setColor( Color.WHITE );

        if(isLeftArrow) {
            p.setColor(getContext().getResources().getColor(R.color.tb_transparent_30));
        } else if (isRightArrow) {
            p.setColor(getContext().getResources().getColor(R.color.tb_transparent_75));
        }

        canvas.drawPath(path, p);
    }


}
