package co.grandcircus.sct;

/**
 * Created by Matt on 1/8/14.
 */
public class Position {

    /* Grid for chess squares of the form [row][col] where bottom left (with white on bottom) is
    [0][0] and top right is [7][7] */

    private Piece[][] squares = new Piece[Chessboard.NUM_ROWS][Chessboard.NUM_COLS];

    public enum Piece {
        EMPTY,
        WKING, WQUEEN, WROOK, WBISHOP, WKNIGHT, WPAWN,
        BKING, BQUEEN, BROOK, BBISHOP, BKNIGHT, BPAWN;
    }

    /* Puts the board in a valid starting position with white on the bottom. (0, 0) is the
    lower-left square on the board and (7, 7) is the square on the upper-right. */
    public void initialize() {

        // Remove all pieces
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                removePiece(row, col);
            }
        }

        addPiece(0, 0, Piece.WROOK);
        addPiece(0, 1, Piece.WBISHOP);
        addPiece(0, 2, Piece.WKNIGHT);
        addPiece(0, 3, Piece.WQUEEN);
        addPiece(0, 4, Piece.WKING);
        addPiece(0, 5, Piece.WBISHOP);
        addPiece(0, 6, Piece.WKNIGHT);
        addPiece(0, 7, Piece.WROOK);

        for (int col = 0; col < 8; col++) {
            addPiece(1, col, Piece.WPAWN);
            addPiece(6, col, Piece.BPAWN);
        }

        addPiece(7, 0, Piece.BROOK);
        addPiece(7, 1, Piece.BKNIGHT);
        addPiece(7, 2, Piece.BBISHOP);
        addPiece(7, 3, Piece.BQUEEN);
        addPiece(7, 4, Piece.BKING);
        addPiece(7, 5, Piece.BBISHOP);
        addPiece(7, 6, Piece.BKNIGHT);
        addPiece(7, 7, Piece.BROOK);
    }

    /* Returns the piece at the specified position on the board. (0, 0) is the lower-left
    square on the board and (7, 7) is the square on the upper-right. */
    public Piece getPiece(int row, int col) {
       return squares[row][col];
    }

    /* Adds the specified piece to the specified square location.  The square's piece value before
    adding the specified piece is the return value. */
    public Piece addPiece(int row, int col, Piece p) {
        Piece replacedPiece = squares[row][col];
        squares[row][col] = p;
        return replacedPiece;
    }

    /* Makes the specified square empty.  Returns true if the square previously had a piece (i.e.,
    it was not empty. */
    public boolean removePiece(int row, int col) {
        boolean squareHadPiece = squares[row][col] != Piece.EMPTY;
        squares[row][col] = Piece.EMPTY;
        return squareHadPiece;
    }

    /* Moves the piece in the original square to the destination square.  Returns whether or not
    a piece was present at the original square. */
    public boolean movePiece(int origRow, int origCol, int destRow, int destCol) {
        if (squares[origRow][origCol] == Piece.EMPTY) return false;
        squares[destRow][destCol] = squares[origRow][origCol];
        squares[origRow][origCol] = Piece.EMPTY;
        return true;
    }
}
