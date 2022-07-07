public class Queen extends ChessPiece{

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //��������, ���� ��������� ������ ������� � ��� �����
        if (chessBoard.board[line][column] !=null && chessBoard.board[line][column].equals(this)) {
            // ��������, ���� � ������ ���������� ���� 8 � 8 checkBorder(),
            // � �������� ���������� �� ����� ��������� �����������
            if (checkBorder(line, column, toLine, toColumn)){
                // �������� ���� �������� ������ ����� ���� ��� ������ ������� �����
                if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                    // �������� ���� ����� �� ���������, ��� �� ����� "�� ������"
                    if (line != toLine && column == toColumn) {
                        // ������ ���� ����� �����
                        if (line < toLine){
                            for (int i = 1; i <= (toLine - line - 1); i++){
                                if (chessBoard.board[line+i][column] != null) return false;
                            } return true;
                            // ������ ���� ����� ����
                        } else {
                            for (int i = 1; i <= (line - toLine - 1); i++){
                                if (chessBoard.board[line-i][column] != null) return false;
                            } return true;
                        }
                        // �������� ���� ����� �� �����������, ��� �� ����� "�� ������"
                    } else if (line == toLine && column != toColumn) {
                        // ������ ���� ����� ������
                        if (column < toColumn){
                            for (int i = 1; i <= (toColumn - column - 1); i++){
                                if (chessBoard.board[line][column+i] != null) return false;
                            } return true;
                            // ������ ���� ����� �����
                        } else {
                            for (int i = 1; i <= (column - toColumn - 1); i++){
                                if (chessBoard.board[line][column-i] != null) return false;
                            } return true;
                        }
                        // � �������� ���������� �� ����� ��������� �����������
                        // � ��� �������� �� ���������
                    } else if (checkDiagonalAndMove(line, column, toLine, toColumn)) {
                        // ���� ���� ����� ������ �����
                        if (toLine > line && toColumn > column){
                            for (int i = 1; i <= (toLine - line - 1); i++){
                                if (chessBoard.board[line+i][column+i] != null) return false;
                            } return true;
                        }
                        // ���� ���� ����� ����� �����
                        if (toLine > line && toColumn < column){
                            for (int i = 1; i <= (toLine - line - 1); i++){
                                if (chessBoard.board[line+i][column-i] != null) return false;
                            } return true;
                        }
                        // ���� ���� ����� ����� ����
                        if (toLine < line && toColumn < column){
                            for (int i = 1; i <= (line - toLine - 1); i++){
                                if (chessBoard.board[line-i][column-i] != null) return false;
                            } return true;
                        }
                        // ���� ���� ����� ������ ����
                        if (toLine < line && toColumn > column){
                            for (int i = 1; i <= (line - toLine - 1); i++){
                                if (chessBoard.board[line-i][column+i] != null) return false;
                            } return true;
                        }
                    }
                }
            }
        } return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
