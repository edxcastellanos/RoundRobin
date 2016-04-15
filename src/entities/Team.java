package entities;

public class Team {
	private String name;
	private int won;
	private int lost;
	private int tied;
	private double pct;
	private int pointsScored;
	private int pointsAgainst;

	public Team() {
	}
	public Team (String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWon() {
		return won;
	}
	public void setWon(int won) {
		this.won = won;
	}
	public int getLost() {
		return lost;
	}
	public void setLost(int lost) {
		this.lost = lost;
	}
	public int getTied() {
		return tied;
	}
	public void setTied(int tied) {
		this.tied = tied;
	}
	public double getPct() {
		return pct;
	}
	public void setPct(double pct) {
		this.pct = pct;
	}
	public int getPointsScored() {
		return pointsScored;
	}
	public void setPointsScored(int pointsScored) {
		this.pointsScored = pointsScored;
	}
	public int getPointsAgainst() {
		return pointsAgainst;
	}
	public void setPointsAgainst(int pointsAgainst) {
		this.pointsAgainst = pointsAgainst;
	}
	
	
}