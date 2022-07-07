public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    // �������� ����������� ������
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //��������, ���� ��������� ������ ������� � ��� �����
        if (chessBoard.board[line][column] != null && chessBoard.board[line][column].equals(this)) {
            // ��������, ���� � ������ ���������� ���� 8 � 8, � �������� ���������� �� ����� ��������� �����������
            if (checkBorder(line, column, toLine, toColumn)) {
                if (column == toColumn) {
                    //�������� ���� ������ ��� �� ����� ������ �� ��� ������ � ������ ������
                    //�������� ���� �����
                    if (color.equals("White") && toLine > line) {
                        if (line == 1 && Math.abs(toLine - line) <= 2 &&
                                chessBoard.board[line + 1][column] == null && chessBoard.board[toLine][toColumn] == null)
                            return true;
                            //�������� ���� �� ������ ��� �� ����� ������ ������ �� ���� ������ � ������ ������
                        else if (Math.abs(toLine - line) == 1 && chessBoard.board[toLine][toColumn] == null)
                            return true;
                        //�������� ���� ������
                    } else if (color.equals("Black") && toLine < line) {
                        if (line == 6 && Math.abs(toLine - line) <= 2 &&
                                    chessBoard.board[line - 1][column] == null && chessBoard.board[toLine][toColumn] == null)
                            return true;
                            //�������� ���� �� ������ ��� �� ����� ������ ������ �� ���� ������ � ������ ������
                        else if (Math.abs(toLine - line) == 1 && chessBoard.board[toLine][toColumn] == null)
                            return true;
                    }
                    //����� ������ ������
                } else if (color.equals("White") && Math.abs(toColumn - column) == 1 && (toLine > line) &&
                        !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) return true;
                else if (color.equals("Black") && Math.abs(toColumn - column) == 1 && (toLine < line) &&
                        !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) return true;
            } else return false;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
