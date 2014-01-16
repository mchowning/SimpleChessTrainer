package co.grandcircus.sct;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Matt on 1/4/14.
 */
public class Chessboard extends View {

    private Position pos;
    private Paint piecePaint;

    public static final int NUM_ROWS = 8;
    public static final int NUM_COLS = 8;

    private static final String DARK_SQUARE_COLOR = "#8acced";

//    public Chessboard(Context context) {
//        super(context);
//
//
//    }

    public Chessboard(Context context, AttributeSet attrs) {
        super(context, attrs);

        pos = new Position();
        pos.initialize();

        piecePaint = new Paint();
        piecePaint.setAntiAlias(true);
        Typeface chessFont = Typeface.createFromAsset(getContext().getAssets(), "ChessCases.ttf");
        piecePaint.setTypeface(chessFont);

        // setColor?
        // setTextSize?
        // Can use getTextBounds to size?
    }
//
//    public Chessboard(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//    }

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
        drawBoard(canvas);
        drawPieces(canvas);
    }

    /* Draws the squares for the board. */
    private void drawBoard(Canvas canvas) {

        /* Calculate square size.  View size was already properly set in onMeasure override */
        int sqSize = getWidth() / 8;

        for (int col = 0; col < NUM_COLS; col++) {
            for (int row = 0; row < NUM_ROWS; row++) {

                int boardHeight = (NUM_COLS) * sqSize;
                int xCoord = col * sqSize;
                int yCoord =  boardHeight - (row * sqSize); // To move y-coord up from bottom of board

                /* Set square color */
                Paint squarePaint = new Paint();
                if ((row + col) % 2 == 0) {
                    squarePaint.setColor(Color.WHITE);
                } else {
                    squarePaint.setColor(Color.parseColor(DARK_SQUARE_COLOR));
                }

                /* FIXME!!!
                Somehow I'm not getting the top row of squares regardless of whether I
                draw the pieces.  Oddly, if I draw the pieces, I only get the top row of the
                pieces (but still no squares) */
                canvas.drawRect(xCoord, yCoord, xCoord + sqSize, yCoord + sqSize, squarePaint);

                piecePaint.setTextSize(sqSize);
                Position.Piece piece = pos.getPiece(row, col);
                String[] pieceLetters = getPieceLetters(piece);

                //  TODO Testing
//                if (row < 1) {
//                    canvas.drawText(pieceLetters[0],xCoord, yCoord, piecePaint);
//                }
            }
        }
    }

    /* Draws the pieces on the board based on the object's position variable. */
    private void drawPieces(Canvas canvas) {

    }

    public void setPosition(Position pos) {
        this.pos = pos;
        // redraw?
    }

    /* Returns the letters that corresponds to the appropriate piece in the ChessCases.ttf
    font. */
    private String[] getPieceLetters(Position.Piece aPiece) {
        String[] result = new String[2];
        switch(aPiece) {
            case WKING:
                result[0] = "H";
                result[1] = "k";
                break;
            case WQUEEN:
                result[0] = "I";
                result[1] = "m";
                break;
            case WROOK:
                result[0] = "J";
                result[1] = "o";
                break;
            case WBISHOP:
                result[0] = "K";
                result[1] = "q";
                break;
            case WKNIGHT:
                result[0] = "L";
                result[1] = "s";
                break;
            case WPAWN:
                result[0] = "M";
                result[1] = "u";
                break;
            case BKING:
                result[0] = "N";
                result[1] = "l";
                break;
            case BQUEEN:
                result[0] = "O";
                result[1] = "n";
                break;
            case BROOK:
                result[0] = "P";
                result[1] = "p";
                break;
            case BBISHOP:
                result[0] = "Q";
                result[1] = "r";
                break;
            case BKNIGHT:
                result[0] = "R";
                result[1] = "t";
                break;
            case BPAWN:
                result[0] = "S";
                result[1] = "v";
                break;
            default:
                result[0] = " ";
                result[1] = " ";
                break;
        }
        return result;
    }


    //private void initializeBoard(
}
