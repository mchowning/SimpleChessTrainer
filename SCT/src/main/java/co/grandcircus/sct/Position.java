package co.grandcircus.sct;

/**
 * Created by Matt on 1/8/14.
 */
public class Position {

    /* Grid for chess squares of the form [row][col] where bottom left (with white on bottom) is
    [0][0] and top right is [7][7] */

    private Piece[][] squares = new Piece[7][7];

    public enum Piece {
        WKING, WQUEEN, WROOK, WBISHOP, WKNIGHT, WPAWN,
        BKING, BQUEEN, BROOK, BBISHOP, BKNIGHT, BPAWN,
        EMPTY;

        /* Returns the letter that corresponds to the appropriate piece in the ChessCases.ttf
        font. */
        public char getFontLetter1() {
            switch(this) {
                case WKING:     return 'H';
                case WQUEEN:    return 'I';
                case WROOK:     return 'J';
                case WBISHOP:   return 'K';
                case WKNIGHT:   return 'L';
                case WPAWN:     return 'M';
                case BKING:     return 'N';
                case BQUEEN:    return 'O';
                case BROOK:     return 'P';
                case BBISHOP:   return 'Q';
                case BKNIGHT:   return 'R';
                case BPAWN:     return 'S';
                default:        return ' ';
            }
        }

        public char getFontLetter2() {
            switch(this) {
                case WKING:     return 'k';
                case BKING:     return 'l';
                case WQUEEN:    return 'm';
                case BQUEEN:    return 'n';
                case WROOK:     return 'o';
                case BROOK:     return 'p';
                case WBISHOP:   return 'q';
                case BBISHOP:   return 'r';
                case WKNIGHT:   return 's';
                case BKNIGHT:   return 't';
                case WPAWN:     return 'u';
                case BPAWN:     return 'v';
                default:        return ' ';
            }
        }
    }

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
