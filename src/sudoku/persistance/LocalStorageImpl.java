package sudoku.persistance;

import sudoku.problemdomain.IStorage;
import sudoku.problemdomain.SudokuGame;

import java.io.*;

public class LocalStorageImpl implements IStorage {
	private static File GAME_DATA = new File(System.getProperty("user.home"), "gamedata.txt");

	@Override
	public void updateGameData(SudokuGame obj) throws IOException {
		if (GAME_DATA.exists())
			GAME_DATA.delete();
		try (final ObjectOutputStream outputStream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(GAME_DATA)))) {
			outputStream.writeObject(obj);
			outputStream.flush();
		}
	}

	@Override
	public SudokuGame getGameData() throws IOException, ClassNotFoundException {
		try (final ObjectInputStream is = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(GAME_DATA)))) {
			return (SudokuGame) is.readObject();
		}
	}

//    @Override
//    public void updateGameData(SudokuGame game) throws IOException {
//    	if (GAME_DATA.exists()) GAME_DATA.delete();
//    	try {
//            FileOutputStream fileOutputStream = new FileOutputStream(GAME_DATA);
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            
//           
//            
//            objectOutputStream.writeObject(game);
//            objectOutputStream.close();
//        } catch (IOException e) {
//            throw new IOException("Unable to access Game Data");
//        }
//    }
//
//    @Override
//    public SudokuGame getGameData() throws IOException {
//        FileInputStream fileInputStream = new FileInputStream(GAME_DATA);
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//        try {
//            SudokuGame gameState = (SudokuGame) objectInputStream.readObject();
//            objectInputStream.close();
//            return gameState;
//        } catch (ClassNotFoundException e) {
//            throw new IOException("File Not Found");
//        }
//    }
}
