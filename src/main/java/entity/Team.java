package entity;

import java.util.Objects;

public class Team {

    protected String name;
    protected int numberOfGames;
    protected int Wins;
    protected int Losses;
    protected int points;

    public Team(String name) {
        this.name = name;
    }

    public Team() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public int getWins() {
        return Wins;
    }

    public void setWins(int wins) {
        Wins = wins;
    }

    public int getLosses() {
        return Losses;
    }

    public void setLosses(int losses) {
        Losses = losses;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return numberOfGames == team.numberOfGames && Wins == team.Wins && Losses == team.Losses
                && points == team.points && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfGames, Wins, Losses, points);
    }

    @Override
    public String toString() {
        return "Team { " +
                "name = '" + name + " | " +
                ", numberOfGames = " + numberOfGames +
                ", Wins = " + Wins +
                ", Losses = " + Losses +
                ", points = " + points +
                '}';
    }
}
