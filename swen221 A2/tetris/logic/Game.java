// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.tetris.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import swen221.tetris.moves.DropMove;
import swen221.tetris.moves.Move;
import swen221.tetris.moves.ClockwiseRotation;
import swen221.tetris.moves.AbstractTranslation;
import swen221.tetris.tetromino.*;

/**
 * A Game instance represents a running game of Tetris. It accepts game moves
 * and updates the board accordingly. Likewise, it provides an API to access the
 * board itself. Finally, it determines when the game is over (i.e. because the
 * board is full).
 *
 * @author David J. Pearce
 * @author Marco Servetto
 */
public class Game {
	/**
	 * An (infinite) sequence of tetrominos to be used to determine the next tetromino.
	 */
	private final Iterator<Tetromino> tetrominoSequence;

	/**
	 * The next tetromnino to be issued. This is useful, amongst other things, for
	 * showing the user what is coming next.
	 */
	private ActiveTetromino nextTetromino;

	/**
	 * The current state of the game board.
	 */
	private Board board;

	/**
	 * Records the number of lines which have been removed.
	 */
	private int lines;
	/**
	 * Records the current score which is determined as a function of the number of
	 * lines removed.
	 */
	private int score;

	public Game(Iterator<Tetromino> sequence, int width, int height) {
		this.tetrominoSequence = sequence;
		// Initial boards list with an empty board.
		this.board = new Board(sequence, width, height);
		// Initialise next tetromino
		this.nextTetromino = nextActiveTetromino();
	}

	/**
	 * Get number of lines removed
	 *
	 * @return
	 */
	public int getLines() {
		return lines;
	}

	/**
	 * Get the current score.
	 *
	 * @return
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Get the current board being acted upon.
	 *
	 * @return
	 */
	public Board getActiveBoard() {
		return board;
	}

	/**
	 * Get the next tetromino which will be issued.
	 *
	 * @return
	 */
	public Tetromino getNextTetromino() {
		return nextTetromino.getUnderlyingTetromino();
	}

	/**
	 * Check whether the game is over. This happens when we can no longer place the
	 * next tetromino.
	 *
	 * @return
	 */
	public boolean isGameOver() {
		// Game is over when can no longer place next tetromino
		return !tetrominoSequence.hasNext() ||!board.canPlaceTetromino(nextTetromino);
	}

	/**
	 * Reset the game so another can be played.
	 */
	public void reset() {
		// reset the line count
		this.lines = 0;
		// reset the score
		this.score = 0;
		// reset the board
		this.board = new Board(tetrominoSequence, board.getWidth(), board.getHeight());
	}

	/**
	 * Apply a given move to the board. This will update the board if the move is
	 * valid, otherwise it will be ignored.
	 *
	 * @param move
	 */
	public boolean apply(Move move) {
		// Check whether the move was valid as, if not, then it's ignored.
		if (move.isValid(board)) {
			// Yes, move is valid therefore apply it for real.
			board = move.apply(board);
			//
			return true;
		} else {
			// This move was ignored.
			return false;
		}
	}

	/**
	 * Clock the game for another cycle. This will apply gravity to the board and
	 * check whether or not the active tetromino has landed. If the piece has
	 * landed, then we will remove full rows, etc.
	 */
	public void clock() {//----------------------------------------------------gravity
		ActiveTetromino activeTetromino = board.getActiveTetromino();
		// Check whether it has landed
		if (activeTetromino != null) {
			// apply gravity
			activeTetromino = activeTetromino.translate(0, -1);//////// gravity fall

		 if(!board.canPlaceTetromino(activeTetromino)) {//if the tetromino landed
			 activeTetromino = activeTetromino.translate(0, 1);
			 board.placeTetromino(activeTetromino);
			 activeTetromino = null;
			 checkEntireRows();
		 }
		} else if(nextTetromino!=null && board.canPlaceTetromino(nextTetromino)){
			 // promote next tetromino to be active
			 activeTetromino = nextTetromino;
			 // select the next one in sequence
			 nextTetromino = nextActiveTetromino();
		 } else {
		 	// indicates game over status
		}
		board.setActiveTetromino(activeTetromino);
	}


	/**
	 * Checks each row of the board for filled ones
	 * and remove when the rows are filled.
	 */
	private void checkEntireRows(){
		int count = 0;
		keepLooping:
		for(int y = 0; y < board.getHeight(); y++){
			for(int x = 0; x < board.getWidth(); x++){
				if(board.getPlacedTetrominoAt(x, y) == null){
					continue keepLooping; //will skip if it reaches to an empty place
				}
			}
			deleteEntireRow(y);	//delete the rows when its full
			count++;
			y--;	// we need to recheck the row because we have moved everything one step down
		}
		score += calScore(count);
	}
	/**
	 * Removes a row and then moves by one down of the entire thing above it
	 * @param row  row to delete
	 */
	private void deleteEntireRow(int row){
		lines++;
		board.clearEntireRow(row);
		for(int y = row + 1; y < board.getHeight(); y++){
			for(int x = 0; x < board.getWidth(); x++){
				Tetromino tetromino = board.getPlacedTetrominoAt(x, y);
				board.setPlacedTetrominoAt(x, y - 1, tetromino);		//moves by one down of the entire thing above it
				board.clearTheCell(y, x);	//Clear the previous cell
			}
		}
	}
	/**
	 * The score is calculated by getting the number of rows removed according to the time
	 * @param rows	The number of rows when its removed
	 * @return		The current score
	 */
	private int calScore(int rows){
		switch (rows){
			case 1:
				return 50;
			case 2:
				return 200;
			case 3:
				return 500;
			case 4:
				return 1000;
		}
		return 0;
	}

	// ======================================================================
	// Helper methods
	// ======================================================================


	/**
	 * Determine the next active tetromino for the board.
	 *
	 * @return
	 */
	private ActiveTetromino nextActiveTetromino() {
		// Determine center for next tetromino
		int cx = board.getWidth() / 2;
		int cy = board.getHeight() - 2;
		// set next tetromino
		return new ActiveTetromino(cx, cy, tetrominoSequence.next());
	}
}
