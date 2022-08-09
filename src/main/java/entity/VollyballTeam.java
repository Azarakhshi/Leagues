package entity;

import java.util.Objects;

public class VollyballTeam extends Team{
    private String PoanDifference;

    public VollyballTeam(String clubName, String poanDifference) {
        super(clubName);
        PoanDifference = poanDifference;
    }

    public String getPoanDifference() {
        return PoanDifference;
    }

    public void setPoanDifference(String poanDifference) {
        PoanDifference = poanDifference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VollyballTeam that = (VollyballTeam) o;
        return Objects.equals(PoanDifference, that.PoanDifference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), PoanDifference);
    }

    @Override
    public String toString() {
        return "VollyballTeam{" +
                "numberOfGames=" + numberOfGames +
                ", Wins=" + Wins +
                ", Losses=" + Losses +
                ", points=" + points +
                ", PoanDifference='" + PoanDifference + '\'' +
                '}';
    }

}
