abstract public class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();

    // ��������, ���� � ������ ���������� ���� 8 � 8
    protected boolean checkBorder (int line, int column, int toLine, int toColumn){
        return (line >= 0 && line < 8 && column >= 0 && column < 8 && toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8);
    }
    //�������� ���� ���� �� ���������, � ��������� ������ ������� ��������
    protected boolean checkDiagonalAndMove(int line, int column, int toLine, int toColumn){
        return Math.abs(toColumn - column) == Math.abs(toLine - line) && line != toLine && column != toColumn;
    }
}
