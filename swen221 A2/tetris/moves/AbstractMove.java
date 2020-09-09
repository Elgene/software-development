// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * Provides some mechanisms which are common across all moves.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public abstract class AbstractMove implements Move {

	@Override
	public boolean isValid(Board board) {
		// NOTE: to check whether move is valid or not, you can employ Move.apply() to
		// compute the new board and then check whether the active tetromino is in a
		// valid position.

		if(board.getActiveTetromino() == null){
			return false;
		}
		board = boardStep(board);
		ActiveTetromino tetromino = board.getActiveTetromino();
		Rectangle bb = tetromino.getBoundingBox();
		if(bb.getMinX() >= 0 && bb.getMaxX() < board.getWidth() &&
				bb.getMinY() >= 0 && bb.getMaxY() < board.getHeight()){
			return board.canPlaceTetromino(tetromino);
		}
		return false;
	}

	/**
	 * Apply one step move to a board to update the board
	 * This is to check each intermediate step in a multi part move is valid
	 *
	 * @param board
	 */
	protected abstract Board boardStep(Board board);

}
