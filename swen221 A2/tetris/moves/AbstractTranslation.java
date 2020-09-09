// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * Implements a translation move.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public abstract class AbstractTranslation extends AbstractMove implements Move {
	/**
	 * Amount to translate x-coordinate.
	 */
	private final int dx;
	/**
	 * Amount to translate y-coordinate.
	 */
	private final int dy;

	/**
	 * Construct new TranslationMove for a given amount of horizontal and vertical
	 * translation.
	 *
	 * @param dx
	 *            Amount to translate in horizontal direction.
	 * @param dy
	 *            Amount to translate in vertical direction.
	 */
	public AbstractTranslation(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	@Override
	public Board boardStep(Board board) {
		//create a different copy of the board to avoid any changes on the previous board.
		board = new Board(board);
		//set translation value
		int x = toValue(dx);
		int y = toValue(dy);
		// Perform translation to move
		ActiveTetromino tetromino = board.getActiveTetromino().translate(x, y);
		//Move to perform a new board.
		board.setActiveTetromino(tetromino);
		// Return the updated board
		return board;
	}

	/**
	 * To determine the translation value
	 * @param value The value to translation
	 * @return
	 */
	private int toValue(int value) {
		if(value < 0) {
			return -1;
		} else if(value > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Board apply(Board board) {
		// Create copy of the board to prevent modifying its previous state.
		board = new Board(board);
		// Apply translation for this move
		ActiveTetromino tetromino = board.getActiveTetromino().translate(dx, dy);
		// Apply the move to the new board.
		board.setActiveTetromino(tetromino);
		// Return updated version of board
		return board;
	}
}
