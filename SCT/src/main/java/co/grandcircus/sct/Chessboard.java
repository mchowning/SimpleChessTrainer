package co.grandcircus.sct;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Matt on 1/4/14.
 */
public class Chessboard extends View {

    public Chessboard(Context context) {
        super(context);
    }

    public Chessboard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Chessboard(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int boardSize = Math.min(width, height);
        setMeasuredDimension(boardSize, boardSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /* Calculate square size.  View size was already properly set in onMeasure override */
        int sqSize = getWidth() / 8;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                int xCoord = col * sqSize;
                int yCoord = row * sqSize;

                /* Set paint color */
                Paint paint = new Paint();

                if ((row + col) % 2 == 0) {
                    paint.setColor(Color.WHITE);
                } else {
                    paint.setColor(Color.parseColor("#8acced"));
                }
                canvas.drawRect(xCoord, yCoord, xCoord + sqSize, yCoord + sqSize, paint);
            }
        }
    }
}
