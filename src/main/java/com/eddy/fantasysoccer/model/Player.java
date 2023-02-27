package com.eddy.fantasysoccer.model;

public class Player {

    private String name;
    private String team;
    private double xG;
    private double xA;

    private String position;

    private double totalPoints;

    public Player(String name, String team, double xG, double xA, double totalPoints, String position) {
        this.name = name;
        this.team = team;
        this.xG = xG;
        this.xA = xA;
        this.totalPoints = totalPoints;
        this.position= position;
    }

    public Player(){

    }

    public String getPosition(){
        return this.position;
    }

    public void setPosition(String position){
        this.position=position;
    }
    public double getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getxG() {
        return xG;
    }

    public void setxG(double xG) {
        this.xG = xG;
    }

    public double getxA() {
        return xA;
    }

    public void setxA(double xA) {
        this.xA = xA;
    }

}
