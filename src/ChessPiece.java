abstract public class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();

    // проверка, хода в рамках шахматного поля 8 х 8
    protected boolean checkBorder (int toLine, int toColumn){
        return (toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8);
    }
    //проверка хода если по диагонали, и начальная клетка неравна конечной
    protected boolean checkDiagonalAndMove(int line, int column, int toLine, int toColumn){
        return Math.abs(toColumn - column) == Math.abs(toLine - line) && line != toLine && column != toColumn;
    }
}
