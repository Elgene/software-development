package swen221.tests;

import java.util.List;

import org.junit.jupiter.api.Test;
import swen221.chessview.Board;
import swen221.chessview.ChessGame;
import swen221.chessview.Position;
import swen221.chessview.Round;
import swen221.chessview.moves.PawnPromotion;
import swen221.chessview.moves.SinglePieceMove;
import swen221.chessview.moves.SinglePieceTake;
import swen221.chessview.pieces.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChessViewTests {

	// ================================================
	// Valid Tests
	// ================================================

	@org.junit.jupiter.api.Test
	public void testValid_01() {
		String input =
			"a2-a3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_02() {
		String input =
			"a2-a3 b7-b6\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|p|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_03() {
		String input =
			"a2-a4 b7-b5\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|p|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_04() {
		String input =
			"d2-d4 d7-d5\n" +
			"e2-e4 d5xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|P|p|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_05() {
		String input =
			"d2-d3 d7-d5\n" +
			"e2-e4 d5xe4\n" +
			"d3xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_06() {
		String input =
			"Nb1-c3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|N|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_07() {
		String input =
			"Nb1-a3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|N|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_08() {
		String input =
			"d2-d4 Nb8-c6\n" +
			"e2-e4 Nc6xd4\n" +
			"";
		String output =
			"8|r|_|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|n|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_09() {
		String input =
			"Nb1-c3 e7-e5\n" +
			"e2-e3 e5-e4\n" +
			"Nc3xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|N|_|_|_|\n" +
			"3|_|_|_|_|P|_|_|_|\n" +
			"2|P|P|P|P|_|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_10() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|B|_|\n" +
			"4|_|_|_|_|_|_|b|_|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_11() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"Bg5-h4\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|b|B|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_12() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"Bg5xe7\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|B|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|b|_|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_13() {
		String input =
			"e2-e4 e7-e5\n" +
			"Qd1-g4 Qd8-h4\n" +
			"Qg4-f4 Qh4-h6\n" +
			"Qf4-f6 Qh6xh2\n" +
			"";
		String output =
			"8|r|n|b|_|k|b|n|r|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|_|_|Q|_|_|\n" +
			"5|_|_|_|_|p|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|_|P|P|q|\n" +
			"1|R|N|B|_|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_14() {
		String input =
			"a2-a4 h7-h5\n" +
			"Ra1-a3 Rh8-h6\n" +
			"Ra3-d3 Rh6-g6\n" +
			"Rd3xd7\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|_|\n" +
			"7|p|p|p|R|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|r|_|\n" +
			"5|_|_|_|_|_|_|_|p|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|_|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}

	// ================================================
	// Invalid Tests
	// ================================================

	@Test public void testInvalid_01() {
		String input =
			"a2-a4 a7-a4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);//****************************************************
	}
	@org.junit.jupiter.api.Test
	public void test15(){
		String input = "a2-a5\n";

		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test16(){
		//Check knight movement
		String input = "Ng1-h3";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|N|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|_|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test17(){
		String input = "g2-g4 a7-a6\n" +
				"Bf1-h3\n" +
				"";

		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|p|p|p|p|p|p|p|\n" +
						"6|p|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|P|_|\n" +
						"3|_|_|_|_|_|_|_|B|\n" +
						"2|P|P|P|P|P|P|_|P|\n" +
						"1|R|N|B|Q|K|_|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test18(){
		//Checks king vertical movement
		String input = "e2-e3 b7-b6\n" +
				"Ke1-e2\n" +
				"";


		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|p|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|P|_|_|_|\n" +
						"2|P|P|P|P|K|P|P|P|\n" +
						"1|R|N|B|Q|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);

	}

	@org.junit.jupiter.api.Test
	public void test19(){
		//Checks queen movement and king horizontal movement
		String input = "e2-e4 e7-e6\n" +
				"Qd1-h5 Ke8-e7\n" +
				"Ke1-d1\n";

		String output =
				        "8|r|n|b|q|_|b|n|r|\n" +
						"7|p|p|p|p|k|p|p|p|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|Q|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|K|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@SuppressWarnings("Duplicates")
	@org.junit.jupiter.api.Test
	public void test20(){
		//Checks the pieceChar method

		assertEquals("a1-a2", new SinglePieceMove(new Pawn(true), new Position(1,1), new Position(2, 1)).toString());
		assertEquals("Na1-a2", new SinglePieceMove(new Knight(true), new Position(1,1), new Position(2, 1)).toString());
		assertEquals("Ba1-a2", new SinglePieceMove(new Bishop(true), new Position(1,1), new Position(2, 1)).toString());
		assertEquals("Ra1-a2", new SinglePieceMove(new Rook(true), new Position(1,1), new Position(2, 1)).toString());
		assertEquals("Qa1-a2", new SinglePieceMove(new Queen(true), new Position(1,1), new Position(2, 1)).toString());
		assertEquals("Ka1-a2", new SinglePieceMove(new King(true), new Position(1,1), new Position(2, 1)).toString());

		assertEquals("a1xa2", new SinglePieceTake(new Pawn(true), new Pawn(false), new Position(1,1), new Position(2, 1)).toString());
	}

	@org.junit.jupiter.api.Test
	public void test21(){
		//Tests the rook movement boolean queensSide, white piece
		String input = "a2-a3 a7-a5\n" +
				"Ra1-a2\n";

		Board board = getLastBoard(input);
		assertTrue(board.rookMoved(true, false));
	}

	@org.junit.jupiter.api.Test
	public void test22(){
		//Tests the rook movement boolean queensSide, black piece
		String input = "a2-a3 a7-a5\n" +
				"Ra1-a2 Ra8-a7\n";

		Board board = getLastBoard(input);
		assertTrue(board.rookMoved(false, false));
	}

	@org.junit.jupiter.api.Test
	public void test23(){
		//Tests the rook movement boolean kingSide, white piece
		String input = "h2-h4 h7-h6\n" +
				"Rh1-h3 Rh8-h7\n";

		Board board = getLastBoard(input);
		assertTrue(board.rookMoved(true, true));
	}

	@org.junit.jupiter.api.Test
	public void test24(){
		//Tests the rook movement boolean kingSide, black piece
		String input = "h2-h4 h7-h6\n" +
				"Rh1-h3 Rh8-h7\n";

		Board board = getLastBoard(input);
		assertTrue(board.rookMoved(false, true));
	}

	@org.junit.jupiter.api.Test
	public void test25(){
		//Checks pawn promotion rule

		String input = "a2-a4 b7-b5\n" +
				      "a4xb5 Nb8-c6\n" +
				"Nb1-a3 Nc6-e5\n" +
				"b5-b6 Ne5-g4\n" +
				"b6-b7 Ng4xh2\n" +
				"b7-b8=N\n";

		String output =
				"8|r|N|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|N|_|_|_|_|_|_|_|\n" +
						"2|_|P|P|P|P|P|P|n|\n" +
						"1|R|_|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@org.junit.jupiter.api.Test
	public void test26(){
		//Checks en-passant rule
		String input = "a2-a4 Ng8-f6\n" +
				"a4-a5 b7-b5\n" +
				"a5xb6ep\n";

		String output =
				        "8|r|n|b|q|k|b|_|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|P|_|_|_|n|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@org.junit.jupiter.api.Test
	public void test27(){
		//Checks check rule
		String input = "e2-e4 d7-d5\n" +
				"Bf1-c4 e7-e6\n" +
				"Bc4-b5+\n";

		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|_|_|p|p|p|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|B|_|p|_|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|_|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@org.junit.jupiter.api.Test
	public void test28(){
		//Checks castling rule kingSide

		String input = "e2-e4 e7-e5\n" +
				"f2-f4 f7-f5\n" +
				"g2-g4 g7-g5\n" +
				"Bf1-h3 Bf8-h6\n" +
				"Ng1-f3 Ng8-f6\n" +
				"O-O O-O\n";

		String output =
				"8|r|n|b|q|_|r|k|_|\n" +
						"7|p|p|p|p|_|_|_|p|\n" +
						"6|_|_|_|_|_|n|_|b|\n" +
						"5|_|_|_|_|p|p|p|_|\n" +
						"4|_|_|_|_|P|P|P|_|\n" +
						"3|_|_|_|_|_|N|_|B|\n" +
						"2|P|P|P|P|_|_|_|P|\n" +
						"1|R|N|B|Q|_|R|K|_|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@org.junit.jupiter.api.Test
	public void test29(){
		//Checks castling rule queenSide
		String input = "b2-b4 b7-b5\n" +
				"c2-c4 c7-c5\n" +
				"d2-d4 d7-d5\n" +
				"Nb1-a3 Nb8-a6\n" +
				"Bc1-h6 Bc8-h3\n" +
				"Qd1-d3 Qd8-d6\n" +
				"O-O-O O-O-O";

		String output =
				"8|_|_|k|r|_|b|n|r|\n" +
						"7|p|_|_|_|p|p|p|p|\n" +
						"6|n|_|_|q|_|_|_|B|\n" +
						"5|_|p|p|p|_|_|_|_|\n" +
						"4|_|P|P|P|_|_|_|_|\n" +
						"3|N|_|_|Q|_|_|_|b|\n" +
						"2|P|_|_|_|P|P|P|P|\n" +
						"1|_|_|K|R|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@org.junit.jupiter.api.Test
	public void test30(){
		//Testing king invalid move
		String input = "e2-e4 a7-a6\n" +
				"Ke1-e3\n";

		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|p|p|p|p|p|p|p|\n" +
						"6|p|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@org.junit.jupiter.api.Test
	public void test31(){
		//Testing PawnPromotion toString
		assertEquals("a7-a8=R", new PawnPromotion(new SinglePieceMove(new Pawn(true),
				new Position(7, 1), new Position(8, 1)), new Rook(true)).toString());
	}

	@org.junit.jupiter.api.Test
	public void test32(){
		//Testing En-Passant with piece in the way
		String input = "b2-b4 h7-h5\n" +
				"b4-b5 Rh8-h6\n" +
				"a2-a3 a7-a5\n" +
				"h2-h4 Rh6-a6\n" +
				"b5xa6ep\n";

		String output =
				"8|r|n|b|q|k|b|n|_|\n" +
						"7|_|p|p|p|p|p|p|_|\n" +
						"6|r|_|_|_|_|_|_|_|\n" +
						"5|p|P|_|_|_|_|_|p|\n" +
						"4|_|_|_|_|_|_|_|P|\n" +
						"3|P|_|_|_|_|_|_|_|\n" +
						"2|_|_|P|P|P|P|P|_|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	@org.junit.jupiter.api.Test
	public void test33(){
		//Check En-Passant for null target
		String input = "a2xb3ep\n";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test34(){
		String input = "e2-e4 e7-e6\nNg1-f3 d7-d6\nBf1-c4 f7-f6\nO-O";
		String output ="8|r|n|b|q|k|b|n|r|\n"+
				"7|p|p|p|_|_|_|p|p|\n"+
				"6|_|_|_|p|p|p|_|_|\n"+
				"5|_|_|_|_|_|_|_|_|\n"+
				"4|_|_|B|_|P|_|_|_|\n"+
				"3|_|_|_|_|_|N|_|_|\n"+
				"2|P|P|P|P|_|P|P|P|\n"+
				"1|R|N|B|Q|_|R|K|_|\n"+
				"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test35(){
		String input = "a2-a4 a7-a5\nRa1-a3 Ra8-a6\nRa3-h3 Ra6-e6\nRh3xh7 Re6xe2+\nBf1xRe2";
		String output =
				"8|_|n|b|q|k|b|n|r|\n"+
						"7|_|p|p|p|p|p|p|R|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|p|_|_|_|_|_|_|_|\n"+
						"4|P|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|_|P|P|P|B|P|P|P|\n"+
						"1|_|N|B|Q|K|_|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);

	}
	@org.junit.jupiter.api.Test
	public void test36(){//testPawnPromotions
		String input ="a2-a4 b7-b5\na4xb5 Nb8-c6\nb5-b6 a7-a6\nb6-b7 a6-a5\nb7-b8=N";
		String output =
				"8|r|N|b|q|k|b|n|r|\n"+
						"7|_|_|p|p|p|p|p|p|\n"+
						"6|_|_|n|_|_|_|_|_|\n"+
						"5|p|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|_|P|P|P|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test37(){
		String input ="d2-d3 d7-d6\nBc1-e3";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|_|p|p|p|p|\n"+
						"6|_|_|_|p|_|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|P|B|_|_|_|\n"+
						"2|P|P|P|_|P|P|P|P|\n"+
						"1|R|N|_|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test38(){
		String input ="e2-e3 e7-e6\nBf1-d3";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|p|_|p|p|p|\n"+
						"6|_|_|_|_|p|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|B|P|_|_|_|\n"+
						"2|P|P|P|P|_|P|P|P|\n"+
						"1|R|N|B|Q|K|_|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test39(){
		String input ="e2-e3 e7-e6\nBf1-d3 Bf8-d6";
		String output =
				"8|r|n|b|q|k|_|n|r|\n"+
						"7|p|p|p|p|_|p|p|p|\n"+
						"6|_|_|_|b|p|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|B|P|_|_|_|\n"+
						"2|P|P|P|P|_|P|P|P|\n"+
						"1|R|N|B|Q|K|_|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test40(){
		String input ="d2-d3 d7-d6\nBc1-e3 Bc8-e6";
		String output =
				"8|r|n|_|q|k|b|n|r|\n"+
						"7|p|p|p|_|p|p|p|p|\n"+
						"6|_|_|_|p|b|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|P|B|_|_|_|\n"+
						"2|P|P|P|_|P|P|P|P|\n"+
						"1|R|N|_|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test41(){
		String input ="d2-d3 d7-d6\nBc1-e3 Bc8-e6\nBe3-c5 Be6-c4\nBc5-b4 Bc4-b5\nBb4-d2 Bb5-d7";
		String output =
				"8|r|n|_|q|k|b|n|r|\n"+
						"7|p|p|p|b|p|p|p|p|\n"+
						"6|_|_|_|p|_|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|P|_|_|_|_|\n"+
						"2|P|P|P|B|P|P|P|P|\n"+
						"1|R|N|_|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test42(){
		String input ="e2-e3 f7-f5\nBf1-d3 g7-g6\nBd3xf5";
		String output =
				 "8|r|n|b|q|k|b|n|r|\n"+
		         "7|p|p|p|p|p|_|_|p|\n"+
				"6|_|_|_|_|_|_|p|_|\n"+
				"5|_|_|_|_|_|B|_|_|\n"+
				"4|_|_|_|_|_|_|_|_|\n"+
				"3|_|_|_|_|P|_|_|_|\n"+
				"2|P|P|P|P|_|P|P|P|\n"+
				"1|R|N|B|Q|K|_|N|R|\n"+
				"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test43(){
		String input ="e2-e3 f7-f5\nBf1-d3 g7-g6\nBd3xf5";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|p|p|_|_|p|\n"+
						"6|_|_|_|_|_|_|p|_|\n"+
						"5|_|_|_|_|_|B|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|P|_|_|_|\n"+
						"2|P|P|P|P|_|P|P|P|\n"+
						"1|R|N|B|Q|K|_|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test44(){
		String input ="c2-c4 e7-e5\nc4-c5 Bf8xc5";
		String output =
				"8|r|n|b|q|k|_|n|r|\n"+
						"7|p|p|p|p|_|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|b|_|p|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|_|P|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test45(){
		String input ="f2-f4 e7-e5\ng2-g3 Bf8-c5\nNb1-c3 Bc5xNg1";
		String output =
				"8|r|n|b|q|k|_|n|r|\n"+
						"7|p|p|p|p|_|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|p|_|_|_|\n"+
						"4|_|_|_|_|_|P|_|_|\n"+
						"3|_|_|N|_|_|_|P|_|\n"+
						"2|P|P|P|P|P|_|_|P|\n"+
						"1|R|_|B|Q|K|B|b|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test46(){
		String input ="e2-e4 e7-e5\nBf1-a6 Bf8-a3\nBa6xb7 Ba3xb2";
		String output =
				"8|r|n|b|q|k|_|n|r|\n"+
						"7|p|B|p|p|_|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|p|_|_|_|\n"+
						"4|_|_|_|_|P|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|b|P|P|_|P|P|P|\n"+
						"1|R|N|B|Q|K|_|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test47(){
		String input ="e2-e4 d7-d5\nKe1-e2";
		String output =
						"8|r|n|b|q|k|b|n|r|\n"+
								"7|p|p|p|_|p|p|p|p|\n"+
								"6|_|_|_|_|_|_|_|_|\n"+
								"5|_|_|_|p|_|_|_|_|\n"+
								"4|_|_|_|_|P|_|_|_|\n"+
								"3|_|_|_|_|_|_|_|_|\n"+
								"2|P|P|P|P|K|P|P|P|\n"+
								"1|R|N|B|Q|_|B|N|R|\n"+
								"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test48(){
		String input ="e2-e4 d7-d5\nBf1-d3 d5xe4\nKe1-f1";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|_|p|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|p|_|_|_|\n"+
						"3|_|_|_|B|_|_|_|_|\n"+
						"2|P|P|P|P|_|P|P|P|\n"+
						"1|R|N|B|Q|_|K|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test49(){
		String input ="e2-e4 d7-d5\nBf1-d3 Qd8-d6\ne4xd5 Ke8-d8";
		String output =
				"8|r|n|b|k|_|b|n|r|\n"+
						"7|p|p|p|_|p|p|p|p|\n"+
						"6|_|_|_|q|_|_|_|_|\n"+
						"5|_|_|_|P|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|B|_|_|_|_|\n"+
						"2|P|P|P|P|_|P|P|P|\n"+
						"1|R|N|B|Q|K|_|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test50(){
		String input ="Nb1-c3";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|p|p|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|N|_|_|_|_|_|\n"+
						"2|P|P|P|P|P|P|P|P|\n"+
						"1|R|_|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test51(){
		String input ="Nb1-c3 Ng8-f6";
		String output =
				"8|r|n|b|q|k|b|_|r|\n"+
						"7|p|p|p|p|p|p|p|p|\n"+
						"6|_|_|_|_|_|n|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|N|_|_|_|_|_|\n"+
						"2|P|P|P|P|P|P|P|P|\n"+
						"1|R|_|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test52(){
		String input ="Ng1-f3 Ng8-f6\nNf3-d4";
		String output =
				"8|r|n|b|q|k|b|_|r|\n"+
						"7|p|p|p|p|p|p|p|p|\n"+
						"6|_|_|_|_|_|n|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|N|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|P|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|_|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test53(){
		String input ="Ng1-f3 Ng8-f6\nc2-c3 Nf6-e4";
		String output =
				"8|r|n|b|q|k|b|_|r|\n"+
						"7|p|p|p|p|p|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|n|_|_|_|\n"+
						"3|_|_|P|_|_|N|_|_|\n"+
						"2|P|P|_|P|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|_|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test54(){
		String input ="Nb1-c3 d7-d5\nNc3xd5";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|_|p|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|N|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|P|P|P|P|P|\n"+
						"1|R|_|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test55(){
		String input ="d2-d4 Nb8-c6\nNg1-f3 Nc6xd4";
		String output =
				"8|r|_|b|q|k|b|n|r|\n"+
						"7|p|p|p|p|p|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|n|_|_|_|_|\n"+
						"3|_|_|_|_|_|N|_|_|\n"+
						"2|P|P|P|_|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|_|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test56(){
		String input ="d2-d4 Nb8-c6\nNg1-f3 Nc6-e5\nNf3xNe5";
		String output =
				"8|r|_|b|q|k|b|n|r|\n"+
						"7|p|p|p|p|p|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|N|_|_|_|\n"+
						"4|_|_|_|P|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|_|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|_|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test57(){
		String input ="Nb1-c3 a7-a6\nNc3-d5 a6-a5\nNd5xe7";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|_|p|p|p|N|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|p|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|P|P|P|P|P|\n"+
						"1|R|_|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test58(){
		String input ="h2-h3 e7-e6";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|p|_|p|p|p|\n"+
						"6|_|_|_|_|p|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|P|\n"+
						"2|P|P|P|P|P|P|P|_|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test59(){
		String input ="h2-h4 e7-e5";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|p|_|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|p|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|P|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|P|P|P|P|_|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test60(){
		String input ="d2-d4 e7-e5\ne2-e3 d7-d5\nc2-c4";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|_|_|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|p|p|_|_|_|\n"+
						"4|_|_|P|P|_|_|_|_|\n"+
						"3|_|_|_|_|P|_|_|_|\n"+
						"2|P|P|_|_|_|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test61(){
		String input ="d2-d4 e7-e5\nd4xe5";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|p|_|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|P|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|_|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test62(){
		String input ="d2-d4 c7-c5\nd4xc5";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|_|p|p|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|P|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|_|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test63(){
		String input ="d2-d3 e7-e5\nd3-d4 e5xd4";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|p|_|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|p|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|_|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test64(){
		String input ="d2-d3 c7-c5\nd3-d4 c5xd4";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|_|p|p|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|p|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|_|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";
		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test65(){
		String input ="e2-e4 d7-d5\nQd1-g4";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|p|p|_|p|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|p|_|_|_|_|\n"+
						"4|_|_|_|_|P|_|Q|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|P|_|P|P|P|\n"+
						"1|R|N|B|_|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test66(){
		String input ="e2-e4 d7-d5\nQd1-g4 Qd8-d6";
		String output =
				"8|r|n|b|_|k|b|n|r|\n"+
						"7|p|p|p|_|p|p|p|p|\n"+
						"6|_|_|_|q|_|_|_|_|\n"+
						"5|_|_|_|p|_|_|_|_|\n"+
						"4|_|_|_|_|P|_|Q|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|P|_|P|P|P|\n"+
						"1|R|N|B|_|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test67(){
		String input ="e2-e4 d7-d5\nQd1-g4 Qd8-d6\nQg4-e6";
		String output =
				"8|r|n|b|_|k|b|n|r|\n"+
						"7|p|p|p|_|p|p|p|p|\n"+
						"6|_|_|_|q|Q|_|_|_|\n"+
						"5|_|_|_|p|_|_|_|_|\n"+
						"4|_|_|_|_|P|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|P|_|P|P|P|\n"+
						"1|R|N|B|_|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test68(){
		String input ="d2-d4 e7-e5\nQd1-d3 Qd8-f6\nQd3-h3";
		String output =
				"8|r|n|b|_|k|b|n|r|\n"+
						"7|p|p|p|p|_|p|p|p|\n"+
						"6|_|_|_|_|_|q|_|_|\n"+
						"5|_|_|_|_|p|_|_|_|\n"+
						"4|_|_|_|P|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|Q|\n"+
						"2|P|P|P|_|P|P|P|P|\n"+
						"1|R|N|B|_|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test69(){
		String input ="e2-e4 d7-d5\nQd1-g4 Qd8-d6\nQg4xg7";
		String output =
				"8|r|n|b|_|k|b|n|r|\n"+
						"7|p|p|p|_|p|p|Q|p|\n"+
						"6|_|_|_|q|_|_|_|_|\n"+
						"5|_|_|_|p|_|_|_|_|\n"+
						"4|_|_|_|_|P|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|P|_|P|P|P|\n"+
						"1|R|N|B|_|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test70(){
		String input ="e2-e4 d7-d5\nQd1-g4 Qd8-d6\nQg4xg7 Qd6-a3\nQg7xRh8";
		String output =
				"8|r|n|b|_|k|b|n|Q|\n"+
						"7|p|p|p|_|p|p|_|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|p|_|_|_|_|\n"+
						"4|_|_|_|_|P|_|_|_|\n"+
						"3|q|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|P|_|P|P|P|\n"+
						"1|R|N|B|_|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test71(){
		String input ="e2-e4 d7-d5\nQd1-g4 Qd8-d6\nQg4xg7 Qd6-a3\nQg7xRh8 Qa3xa2";
		String output =
				"8|r|n|b|_|k|b|n|Q|\n"+
						"7|p|p|p|_|p|p|_|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|p|_|_|_|_|\n"+
						"4|_|_|_|_|P|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|q|P|P|P|_|P|P|P|\n"+
						"1|R|N|B|_|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test72(){
		String input ="a2-a4 a7-a5\nRa1-a3 Ra8-a6\nRa3-h3 Ra6-e6";
		String output =
				"8|_|n|b|q|k|b|n|r|\n"+
						"7|_|p|p|p|p|p|p|p|\n"+
						"6|_|_|_|_|r|_|_|_|\n"+
						"5|p|_|_|_|_|_|_|_|\n"+
						"4|P|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|R|\n"+
						"2|_|P|P|P|P|P|P|P|\n"+
						"1|_|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test73(){
		String input ="h2-h4 h7-h5\nRh1-h3 Rh8-h6\nRh3-a3 Rh6-e6";
		String output =
				"8|r|n|b|q|k|b|n|_|\n"+
						"7|p|p|p|p|p|p|p|_|\n"+
						"6|_|_|_|_|r|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|p|\n"+
						"4|_|_|_|_|_|_|_|P|\n"+
						"3|R|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|P|P|P|P|_|\n"+
						"1|R|N|B|Q|K|B|N|_|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test74(){
		String input ="a2-a4 a7-a5\nRa1-a3 Ra8-a6\nRa3-h3 Ra6-e6\nRh3xh7";
		String output =
				"8|_|n|b|q|k|b|n|r|\n"+
						"7|_|p|p|p|p|p|p|R|\n"+
						"6|_|_|_|_|r|_|_|_|\n"+
						"5|p|_|_|_|_|_|_|_|\n"+
						"4|P|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|_|P|P|P|P|P|P|P|\n"+
						"1|_|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test75(){
		String input ="a2-a4 a7-a5\nRa1-a3 Ra8-a6\nRa3-h3 Ra6-d6\nRh3xh7 Rd6xd2";
		String output =
				"8|_|n|b|q|k|b|n|r|\n"+
						"7|_|p|p|p|p|p|p|R|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|p|_|_|_|_|_|_|_|\n"+
						"4|P|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|_|P|P|r|P|P|P|P|\n"+
						"1|_|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test76(){//testValidCastling
		String input ="e2-e3 e7-e6\nd2-d3 Ng8-f6\nc2-c3 Bf8-c5\na2-a3 O-O";
		String output =
				"8|r|n|b|q|_|r|k|_|\n"+
						"7|p|p|p|p|_|p|p|p|\n"+
						"6|_|_|_|_|p|n|_|_|\n"+
						"5|_|_|b|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|P|_|P|P|P|_|_|_|\n"+
						"2|_|P|_|_|_|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test77(){//testValidCastling
		String input ="d2-d4 a7-a6\nQd1-d3 b7-b6\nBc1-e3 c7-c6\nNb1-a3 d7-d6\nO-O-O";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|_|_|_|_|p|p|p|p|\n"+
						"6|p|p|p|p|_|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|P|_|_|_|_|\n"+
						"3|N|_|_|Q|B|_|_|_|\n"+
						"2|P|P|P|_|P|P|P|P|\n"+
						"1|_|_|K|R|_|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test78(){//testValidCastling
		String input ="a2-a3 d7-d5\nb2-b3 Qd8-d6\nc2-c3 Bc8-e6\nd2-d3 Nb8-a6\ne2-e3 O-O-O";
		String output =
				"8|_|_|k|r|_|b|n|r|\n"+
						"7|p|p|p|_|p|p|p|p|\n"+
						"6|n|_|_|q|b|_|_|_|\n"+
						"5|_|_|_|p|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|P|P|P|P|P|_|_|_|\n"+
						"2|_|_|_|_|_|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test79(){//testValidChecks
		String input ="Nb1-c3 e7-e6\nNc3-d5 e6-e5\nNd5xc7+ Ke8-e7\nNc7xRa8";
		String output =
				"8|N|n|b|q|_|b|n|r|\n"+
						"7|p|p|_|p|k|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|p|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|P|P|P|P|P|\n"+
						"1|R|_|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test80(){//testValidChecks
		String input ="d2-d4 e7-e5\nd4-d5 Ke8-e7\nd5-d6+ c7xd6";
		String output =
				"8|r|n|b|q|_|b|n|r|\n"+
						"7|p|p|_|p|k|p|p|p|\n"+
						"6|_|_|_|p|_|_|_|_|\n"+
						"5|_|_|_|_|p|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|P|P|P|_|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test81(){//testEnPassant
		String input ="h2-h3 b7-b5\ng2-g3 b5-b4\na2-a4 b4xa3ep";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|_|p|p|p|p|p|p|\n"+
						"6|_|_|_|_|_|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|p|_|_|_|_|_|P|P|\n"+
						"2|_|P|P|P|P|P|_|_|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test82(){//testEnPassant
		String input ="a2-a4 h7-h6\na4-a5 b7-b5\na5xb6ep";
		String output =
				"8|r|n|b|q|k|b|n|r|\n"+
						"7|p|_|p|p|p|p|p|_|\n"+
						"6|_|P|_|_|_|_|_|p|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|_|P|P|P|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test83(){//testPawnPromotion
		String input ="a2-a4 b7-b5\na4xb5 Nb8-c6\nb5-b6 a7-a6\nb6-b7 a6-a5\nb7-b8=Q a5-a4\nQb8xRa8";
		String output =
				"8|Q|_|b|q|k|b|n|r|\n"+
						"7|_|_|p|p|p|p|p|p|\n"+
						"6|_|_|n|_|_|_|_|_|\n"+
						"5|_|_|_|_|_|_|_|_|\n"+
						"4|p|_|_|_|_|_|_|_|\n"+
						"3|_|_|_|_|_|_|_|_|\n"+
						"2|_|P|P|P|P|P|P|P|\n"+
						"1|R|N|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test84(){//testPawnPromotion
		String input ="a2-a4 b7-b5\na4xb5 Nb8-c6\nb5-b6 a7-a5\nNb1-c3 Bc8-a6\nNg1-f3 e7-e6\nb6-b7 Qd8-h4\nb7-b8=Q+ Ke8-e7";
		String output =
				"8|r|Q|_|_|_|b|n|r|\n"+
						"7|_|_|p|p|k|p|p|p|\n"+
						"6|b|_|n|_|p|_|_|_|\n"+
						"5|p|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|q|\n"+
						"3|_|_|N|_|_|N|_|_|\n"+
						"2|_|P|P|P|P|P|P|P|\n"+
						"1|R|_|B|Q|K|B|_|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}
	@org.junit.jupiter.api.Test
	public void test85(){//testPawnPromotion
		String input ="a2-a4 b7-b5\na4xb5 Nb8-c6\nb5-b6 a7-a5\nNb1-c3 Bc8-a6\nb6-b7 Qd8-c8\nb7xQc8=Q+";
		String output =
				"8|r|_|Q|_|k|b|n|r|\n"+
						"7|_|_|p|p|p|p|p|p|\n"+
						"6|b|_|n|_|_|_|_|_|\n"+
						"5|p|_|_|_|_|_|_|_|\n"+
						"4|_|_|_|_|_|_|_|_|\n"+
						"3|_|_|N|_|_|_|_|_|\n"+
						"2|_|P|P|P|P|P|P|P|\n"+
						"1|R|_|B|Q|K|B|N|R|\n"+
						"  a b c d e f g h";

		check(input, output);
	}




	public static Board getLastBoard(String input){
		try {
			ChessGame game = new ChessGame(input);
			List<Board> boards = game.boards();
			if (boards.isEmpty()) {
				fail("test failed with insufficient boards on input: " + input);
			}
			return boards.get(boards.size() - 1);
		} catch (Exception e) {
			fail("test failed because of exception on input: " + input);
		}

		return null;
	}

	 //The following provides a simple helper method for all tests.
	public static void check(String input, String expectedOutput) {
		try {
			String actualOutput = getLastBoard(input).toString();
			assertEquals(expectedOutput, actualOutput);
		} catch (Exception e) {
			fail("test failed because of exception on input: " + input);
		}
	}

}
