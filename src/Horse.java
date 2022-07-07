public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    // проверка возможности ходить
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        //проверка, если начальная клетка непуста и это конь
        if (chessBoard.board[line][column] !=null && chessBoard.board[line][column].equals(this)) {
            // проверка, хода в рамках шахматного поля 8 х 8, и конечные координаты не равны начальным координатам
            if (checkBorder(line, column, toLine, toColumn) && line != toLine && column != toColumn) {
                // проверка если конечная клетка пуста либо там фигура другого цвета
                if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                    //создаем матрицу возможных ходов для коня
                    int[][] moveSheet = new int[][]{
                            {line - 2, column - 1}, {line + 2, column + 1}, {line + 2, column - 1}, {line - 2, column + 1},
                            {line - 1, column - 2}, {line + 1, column + 2}, {line + 1, column - 2}, {line - 1, column + 2}
                    };
                    // сопоставляем конечные координаты с матрицей возможных ходов: если находиться совпадение возвращаем true
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
