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
        //проверка, если начальная клетка непуста и это ладья
        if (chessBoard.board[line][column] !=null && chessBoard.board[line][column].equals(this)) {
            // проверка, хода в рамках шахматного поля 8 х 8 checkBorder(),
            // и конечные координаты не равны начальным координатам
            if (checkBorder(line, column, toLine, toColumn)){
                // проверка если конечная клетка пуста либо там фигура другого цвета
                if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)) {
                    // проверка если ходит по вертикали, нет ли фигур "по дороге"
                    if (line != toLine && column == toColumn) {
                        // провка если ходим вверх
                        if (line < toLine){
                            for (int i = 1; i <= (toLine - line - 1); i++){
                                if (chessBoard.board[line+i][column] != null) return false;
                            } return true;
                            // провка если ходим вниз
                        } else {
                            for (int i = 1; i <= (line - toLine - 1); i++){
                                if (chessBoard.board[line-i][column] != null) return false;
                            } return true;
                        }
                        // проверка если ходит по горизонтали, нет ли фигур "по дороге"
                    } else if (line == toLine && column != toColumn) {
                        // провка если ходим вправо
                        if (column < toColumn){
                            for (int i = 1; i <= (toColumn - column - 1); i++){
                                if (chessBoard.board[line][column+i] != null) return false;
                            } return true;
                            // провка если ходим влево
                        } else {
                            for (int i = 1; i <= (column - toColumn - 1); i++){
                                if (chessBoard.board[line][column-i] != null) return false;
                            } return true;
                        }
                        // и конечные координаты не равны начальным координатам
                        // и ход выполнен по диагонали
                    } else if (checkDiagonalAndMove(line, column, toLine, toColumn)) {
                        // если слон ходит вправо вверх
                        if (toLine > line && toColumn > column){
                            for (int i = 1; i <= (toLine - line - 1); i++){
                                if (chessBoard.board[line+i][column+i] != null) return false;
                            } return true;
                        }
                        // если слон ходит влево вверх
                        if (toLine > line && toColumn < column){
                            for (int i = 1; i <= (toLine - line - 1); i++){
                                if (chessBoard.board[line+i][column-i] != null) return false;
                            } return true;
                        }
                        // если слон ходит влево вниз
                        if (toLine < line && toColumn < column){
                            for (int i = 1; i <= (line - toLine - 1); i++){
                                if (chessBoard.board[line-i][column-i] != null) return false;
                            } return true;
                        }
                        // если слон ходит вправо вниз
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
