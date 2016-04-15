package entities;

import java.util.ArrayList;

public class Round {
	private int roundNumber;
	private ArrayList<Team> local;
	private ArrayList<Team> visit;
	
	public int getRoundNumber() {
		return roundNumber;
	}
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
	public ArrayList<Team> getLocal() {
		return local;
	}
	public void setLocal(ArrayList<Team> local) {
		this.local = local;
	}
	public ArrayList<Team> getVisit() {
		return visit;
	}
	public void setVisit(ArrayList<Team> visit) {
		this.visit = visit;
	}
	
}
