package org.example;

public class Player {
    private int id;
    private String name;
    private int age;
    private Integer goalNb;
    private PlayerPositionEnum position;
    private Team team;

    public Player(int id, String name, int age, PlayerPositionEnum position, Team team, Integer goalNb) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.team = team;
        this.goalNb = goalNb;

    }


    public String getTeamName() {
        return team != null ? team.getName() : null;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public PlayerPositionEnum getPosition() {
        return position;
    }

    public Team getTeam() {
        return team;
    }

    public Integer getGoalNb() {
        return goalNb;
    }

    public void setGoalNb(Integer goalNb) {
        this.goalNb = goalNb;
    }
}

