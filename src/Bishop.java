public class Bishop extends ChessPiece{

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //��������, ���� ��������� ������ ������� � ��� ����
        if (chessBoard.board[line][column] !=null && chessBoard.board[line][column].equals(this)) {
            // ��������, ���� � ������ ���������� ���� 8 � 8 checkBorder(),
            // � �������� ���������� �� ����� ��������� �����������
            // � ��� �������� �� ���������
            if (checkBorder(toLine, toColumn) && checkDiagonalAndMove(line, column, toLine, toColumn)){
                // �������� ���� �������� ������ ����� ���� ��� ������ ������� �����
                if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                    // ���� ���� ����� ������ �����
                    if (toLine > line && toColumn > column){
                        for (int i = 1; i <= (toLine-line); i++){
                            if (chessBoard.board[line+i][column+i] != null) return false;
                        } return true;
                    }
                    // ���� ���� ����� ����� �����
                    if (toLine > line && toColumn < column){
                        for (int i = 1; i <= (toLine-line); i++){
                            if (chessBoard.board[line+i][column-i] != null) return false;
                        } return true;
                    }
                    // ���� ���� ����� ����� ����
                    if (toLine < line && toColumn < column){
                        for (int i = 1; i <= (line-toLine); i++){
                            if (chessBoard.board[line-i][column-i] != null) return false;
                        } return true;
                    }
                    // ���� ���� ����� ������ ����
                    if (toLine < line && toColumn > column){
                        for (int i = 1; i <= (line-toLine); i++){
                            if (chessBoard.board[line-i][column+i] != null) return false;
                        } return true;
                    }
                }
            }
        }return false;
    }


    @Override
    public String getSymbol() {
        return "B";
    }
}
