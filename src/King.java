public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //��������, ���� ��������� ������ ������� � ��� ������
        if (chessBoard.board[line][column] !=null && chessBoard.board[line][column].equals(this)) {
            // ��������, ���� � ������ ���������� ���� 8 � 8 checkBorder(),
            if (checkBorder(line, column, toLine, toColumn)) {
                // ��������� ���������� ������� ��������
                if (line == toLine && column == toColumn) return false;
                // ��� �� ���� ������
                if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1) {
                    if (isUnderAttack(chessBoard, toLine, toColumn)) return false;
                    if (chessBoard.board[toLine][toColumn] != null) {
                        return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                    }return true;
                }
            }
        } return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int toLine, int toColumn){
        if (checkBorder(0, 0, toLine, toColumn)){
            for (int i = 0; i < 7; i++){
                for (int j = 0; j < 7; j++){
                    if (chessBoard.board[i][j] !=null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) &&
                                chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, toLine, toColumn)) {
                            return true;
                        }
                    }
                }
            } return false;
        } else return false;
    }

}



