package secondObligatoryHomework;

import java.util.ArrayList;

import secondObligatoryHomework.Match.Result;

public class ListOfMatches implements WorkWithMatches {
	private ArrayList<Match> matches;

	public ListOfMatches() {
		this.setMatches(new ArrayList<>());
	}

	public void addMatch(Match inputMatch) {
		this.getMatches().add(inputMatch);
		System.out.printf("Match with first team %s and second team %s with result %s added to list of matches.%n",
				inputMatch.getFirstTeamName(), inputMatch.getSecondTeamName(), inputMatch.getResult());
	}

	public void removeMatch(Match inputMatch) {
		String firstTeamName = inputMatch.getFirstTeamName();
		String secondTeamName = inputMatch.getSecondTeamName();

		if (findMatch(firstTeamName, secondTeamName, false) == -1) {
			System.out.printf(
					"Error: The match between %s and %s you are trying to remove is not in the list of matches!%n",
					firstTeamName, secondTeamName);
		} else {
			this.getMatches().remove(inputMatch);
			System.out.printf("Match between %s and %s removed from list of matches.%n", firstTeamName, secondTeamName);
		}
	}

	public int findMatch(String inputFirstTeamName, String inputSecondTeamName) {
		return findMatch(inputFirstTeamName, inputSecondTeamName, true);
	}

	public int findMatch(String inputFirstTeamName, String inputSecondTeamName, Boolean printConsoleMessage) {
		for (int i = 0; i < this.getMatches().size(); i++) {
			String firstTeamName = this.getMatches().get(i).getFirstTeamName();
			String secondTeamName = this.getMatches().get(i).getSecondTeamName();
			if (firstTeamName.equals(inputFirstTeamName) && secondTeamName.equals(inputSecondTeamName)) {
				if (printConsoleMessage)
					System.out.printf("Match between %s and %s is in the list of matches on position %d.%n",
							inputFirstTeamName, inputSecondTeamName, i + 1);
				return i;
			}
		}
		if (printConsoleMessage)
			System.out.printf("Match between %s and %s is not in the list of matches.%n", inputFirstTeamName,
					inputSecondTeamName);
		return -1;
	}

	public void calculateScores(ListOfMatches matches, ListOfTeams teams) {
		for (int i = 0; i < matches.getMatches().size(); i++) {
			Match match = matches.getMatches().get(i);
			String firstTeamName = match.getFirstTeamName();
			String secondTeamName = match.getSecondTeamName();
			Result result = match.getResult();

			switch (result) {
			case FIRST_WON:
				updateScore(teams, firstTeamName, 3);
				break;
			case SECOND_WON:
				updateScore(teams, secondTeamName, 3);
				break;
			case TIED:
				updateScore(teams, firstTeamName, 1);
				updateScore(teams, secondTeamName, 1);
				break;
			default:
				break;
			}
		}
	}

	private void updateScore(ListOfTeams teams, String teamName, int scoreToAdd) {
		int index = teams.findTeam(teamName, false);
		Team foundTeam = teams.getTeams().get(index);
		foundTeam.setScore(foundTeam.getScore() + scoreToAdd);
	}

	public ArrayList<Match> getMatches() {
		return matches;
	}

	public void setMatches(ArrayList<Match> matches) {
		this.matches = matches;
	}

}