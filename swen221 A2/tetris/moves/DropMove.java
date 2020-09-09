// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.moves;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Rectangle;
import swen221.tetris.tetromino.ActiveTetromino;
import swen221.tetris.tetromino.Tetromino;

/**
 * Implements a "hard drop". That is, when the tetromino is immediately dropped
 * all the way down as far as it can go.
 *
 * @author David J. Pearce
 * @author Marco Servetto
 *
 */
public class DropMove implements Move {
	@Override
	@SuppressWarnings("Duplicates")
	public boolean isValid(Board board) {
		if(board.getActiveTetromino() == null) return false;
		board = apply(board);
		ActiveTetromino tetromino = board.getActiveTetromino();
		Rectangle bb = tetromino.getBoundingBox();
		if(bb.getMinX() >= 0 && bb.getMaxX() < board.getWidth() &&
				bb.getMinY() >= 0 && bb.getMaxY() < board.getHeight()){
			return board.canPlaceTetromino(tetromino);
		}
		return false;
	}

	@Override
	public Board apply(Board board) {
		ActiveTetromino tetromino = board.getActiveTetromino();
		while(board.canPlaceTetromino(tetromino)){
			tetromino = tetromino.translate(0, -1);///-----------------for sudden drop
		}
		tetromino = tetromino.translate(0, 1);///----------------------sudden drop
		board.setActiveTetromino(tetromino);
		return board;
	}

	@Override
	public String toString() {
		return "drop";
	}
}
