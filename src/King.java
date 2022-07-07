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
        //проверка, если начальная клетка непуста и это король
        if (chessBoard.board[line][column] !=null && chessBoard.board[line][column].equals(this)) {
            // проверка, хода в рамках шахматного поля 8 х 8 checkBorder(),
            if (checkBorder(line, column, toLine, toColumn)) {
                // начальные координаты неравны конечным
                if (line == toLine && column == toColumn) return false;
                // ход на одну клетку
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



