package com.pl.premier_zone.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_statistics")
public class Player {
    @Id
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "player_name")
    private String name;

    @Column(name = "nation")
    private String nation;

    @Column(name = "position")
    private String position;

    @Column(name = "age")
    private Integer age;

    @Column(name = "matches_played")
    private Integer matchesPlayed;

    @Column(name = "starts")
    private Integer gamesStarted;

    @Column(name = "minutes_played")
    private Double minutesPlayed;

    @Column(name = "goals")
    private Double goalsScored;

    @Column(name = "assists")
    private Double assists;

    @Column(name = "expected_goals")
    private Double expectedGoals;

    @Column(name = "expected_assisted_goals")
    private Double expectedAssists;

    @Column(name = "team_name")
    private String team;

    public Player(Integer id, String name, String nation, String position, Integer age, Integer matchesPlayed, Integer gamesStarted, Double minutesPlayed, Double goalsScored, Double assists, Double expectedGoals, Double expectedAssists, String team) {
        this.id = id;
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.age = age;
        this.matchesPlayed = matchesPlayed;
        this.gamesStarted = gamesStarted;
        this.minutesPlayed = minutesPlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.expectedGoals = expectedGoals;
        this.expectedAssists = expectedAssists;
        this.team = team;
    }

    // Default Constructor
    public Player() {

    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Double getExpectedAssists() {
        return expectedAssists;
    }

    public void setExpectedAssists(Double expectedAssists) {
        this.expectedAssists = expectedAssists;
    }

    public Double getExpectedGoals() {
        return expectedGoals;
    }

    public void setExpectedGoals(Double expectedGoals) {
        this.expectedGoals = expectedGoals;
    }

    public Double getAssists() {
        return assists;
    }

    public void setAssists(Double assists) {
        this.assists = assists;
    }

    public Double getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(Double goalsScored) {
        this.goalsScored = goalsScored;
    }

    public Double getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(Double minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public Integer getGamesStarted() {
        return gamesStarted;
    }

    public void setGamesStarted(Integer gamesStarted) {
        this.gamesStarted = gamesStarted;
    }

    public Integer getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(Integer matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
