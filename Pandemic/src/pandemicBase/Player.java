package pandemicBase;
import java.util.ArrayList;

import core.AbstractCard;
import core.AbstractGamePieces;

public class Player {
	private int ID;
	private Pawn pawn;
	private ArrayList<AbstractGamePieces> gamePieces = new ArrayList<AbstractGamePieces>(); //?
	private ArrayList<AbstractCard> cardList = new ArrayList<AbstractCard>(); //?
	private BoardNode currentNode;
	public Player(int id,BoardNode currentNode) {
		setID(id);
		setCurrentNode(currentNode);
	}

	public int getID() {
		return ID;
	}

	private void setID(int iD) {
		this.ID = iD;
	}

	public Pawn getPawn() {
		return pawn;
	}

	public void setPawn(Pawn pawn) {
		this.pawn = pawn;
	}

	public ArrayList<AbstractGamePieces> getGamePieces() {
		return gamePieces;
	}

	public BoardNode getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(BoardNode currentNode) {
		this.currentNode = currentNode;
	}

	public ArrayList<AbstractCard> getCardList() {
		return cardList;
	}

	public void setCardList(ArrayList<AbstractCard> cardList) {
		this.cardList = cardList;
	}

	public void setGamePieces(ArrayList<AbstractGamePieces> gamePieces) {
		this.gamePieces = gamePieces;
	}

	public void addCard(AbstractCard card) {
		this.cardList.add(card);
	}

}
