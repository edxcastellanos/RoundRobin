import java.util.ArrayList;
import entities.Team;
import entities.Round;

public class MainActivity {
	private ArrayList<Team> teams;
	private ArrayList<Round> singleRounds;
	private ArrayList<Round> doubleRounds;

	public static void main(String[] args) {
		MainActivity m = new MainActivity();
		m.teams = new ArrayList<Team>();
		m.singleRounds = new ArrayList<Round>();
		m.doubleRounds = new ArrayList<Round>();
		m.teams.add(new Team("México"));
		m.teams.add(new Team("USA"));
		m.teams.add(new Team("Canadá"));
		m.teams.add(new Team("Costa Rica"));
		m.teams.add(new Team("Jamaica"));
		m.teams.add(new Team("Trinidad y Tobago"));

		m.fixBye(m.teams);
		m.imprimeEquipos(m.teams);
		m.creaJornadas(m.teams);

		m.singleRounds = m.creaJornadas(m.teams);
		m.doubleRounds = m.creaJornadasDobles(m.teams);

		m.imprimeJornadas(m.singleRounds);
		m.imprimeJornadas(m.doubleRounds);
	}

	private ArrayList<Round> creaJornadasDobles(ArrayList<Team> teams) {
		ArrayList<Round> rounds = new ArrayList<Round>();
		for (int i = 0; i < teams.size() * 2 - 2; i++) {
			Round round = new Round();
			round.setRoundNumber(i + 1);

			int lastTeam = teams.size() - 1;
			
			ArrayList<Team> local = new ArrayList<>();
			ArrayList<Team> visit = new ArrayList<>();

			for (int j = 0; j < teams.size() / 2; j++) {
				local.add(teams.get(j));

				visit.add(teams.get(lastTeam--));
			}

			round.setLocal(local);
			round.setVisit(visit);
			rounds.add(round);

			rotateTeams(teams);

			System.out.println();
		}
		return rounds;
	}

	private void fixBye(ArrayList<Team> teams) {
		if (teams.size() % 2 == 1) {
			teams.add(new Team("bye"));
		}
	}

	private ArrayList<Round> creaJornadas(ArrayList<Team> teams) {
		ArrayList<Round> rounds = new ArrayList<Round>();
		for (int i = 0; i < teams.size() - 1; i++) {
			Round round = new Round();
			round.setRoundNumber(i + 1);

			int lastTeam = teams.size() - 1;

			ArrayList<Team> local = new ArrayList<>();
			ArrayList<Team> visit = new ArrayList<>();

			for (int j = 0; j < teams.size() / 2; j++) {
				local.add(teams.get(j));

				visit.add(teams.get(lastTeam--));
			}

			round.setLocal(local);
			round.setVisit(visit);
			rounds.add(round);

			rotateTeams(teams);
			System.out.println();
		}
		return rounds;
	}

	private void rotateTeams(ArrayList<Team> teams) {
		int lastTeamIndex = teams.size() - 1;
		Team tempLast = teams.get(lastTeamIndex);
		for (int i = lastTeamIndex; i > 1; i--) {
			teams.set(i, teams.get(i - 1));
		}
		teams.set(1, tempLast);
	}

	public void imprimeEquipos(ArrayList<Team> teams) {
		System.out.println("Equipos Participantes");
		for (Team team : teams) {
			System.out.println(team.getName());
		}
	}

	private void imprimeJornadas(ArrayList<Round> singleRounds) {
		for (Round round : singleRounds) {
			ArrayList<Team> local = round.getLocal();
			ArrayList<Team> visit = round.getVisit();

			System.out.println("Round " + round.getRoundNumber());
			for (int i = 0; i < local.size(); i++) {
				System.out.print("local: " + local.get(i).getName());
				System.out.print(" vs ");
				System.out.print("visitante: " + visit.get(i).getName());
				System.out.println();
			}
		}
	}
}
