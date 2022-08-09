package entity;

import java.util.Objects;

public class SoccerTeam extends Team{
    private String GoalDifference;

    public SoccerTeam(String clubName, String goalDifference) {
        super(clubName);
        GoalDifference = goalDifference;
    }

    public String getGoalDifference() {
        return GoalDifference;
    }

    public void setGoalDifference(String goalDifference) {
        GoalDifference = goalDifference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SoccerTeam that = (SoccerTeam) o;
        return Objects.equals(GoalDifference, that.GoalDifference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), GoalDifference);
    }

    @Override
    public String toString() {
        return "SoccerTeam{" +
                "GoalDifference='" + GoalDifference + '\'' +
                ", numberOfGames=" + numberOfGames +
                ", Wins=" + Wins +
                ", Losses=" + Losses +
                ", points=" + points +
                '}';
    }
}
