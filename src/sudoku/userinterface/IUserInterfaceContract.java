package sudoku.userinterface;

import sudoku.problemdomain.SudokuGame;

public interface IUserInterfaceContract {
    interface EventListener {
        void onSudokuInput (int x, int y, int input) throws Exception;
        void onDialogClick() throws Exception;
    }

    interface View {
        void setListener (IUserInterfaceContract.EventListener listener);
        void updateSquare (int x, int y, int input);
        void updateBoard (SudokuGame game);
        void showDialog (String message) throws Exception;
        void showError (String message);
    }
}
