public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    // �������� ����������� ������
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //��������, ���� ��������� ������ ������� � ��� ����
        if (chessBoard.board[line][column] !=null && chessBoard.board[line][column].equals(this)) {
            // ��������, ���� � ������ ���������� ���� 8 � 8, � �������� ���������� �� ����� ��������� �����������
            if (checkBorder(line, column, toLine, toColumn) && line != toLine && column != toColumn) {
                // �������� ���� �������� ������ ����� ���� ��� ������ ������� �����
                if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                    //������� ������� ��������� ����� ��� ����
                    int[][] moveSheet = new int[][]{
                            {line - 2, column - 1}, {line + 2, column + 1}, {line + 2, column - 1}, {line - 2, column + 1},
                            {line - 1, column - 2}, {line + 1, column + 2}, {line + 1, column - 2}, {line - 1, column + 2}
                    };
                    // ������������ �������� ���������� � �������� ��������� �����: ���� ���������� ���������� ���������� true
                    for (int i = 0; i < moveSheet.length; i++){
                        if (moveSheet[i][0] == toLine && moveSheet[i][1] == toColumn) return true;
                    }
                }
            } else return false;
        } return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

}
