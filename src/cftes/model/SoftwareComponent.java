/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cftes.model;

/**
 *
 * @author 
 * Name: Sudan Suwal
 * Student ID: 12199888
 */
public class SoftwareComponent {
    private String id;
    private String component; 
    private double energy;
    private double emissionFactor;
    private double embodiedEmissions;
    private double score;

    public SoftwareComponent(String component, double energy, double emissionFactor, double embodiedEmissions) {
        this.component = component;
        this.energy = energy;
        this.emissionFactor = emissionFactor;
        this.embodiedEmissions = embodiedEmissions;
    }
    
    public double getScore() {
        score = (energy * emissionFactor) + embodiedEmissions;
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getEmissionFactor() {
        return emissionFactor;
    }

    public void setEmissionFactor(double emissionFactor) {
        this.emissionFactor = emissionFactor;
    }

    public double getEmbodiedEmissions() {
        return embodiedEmissions;
    }

    public void setEmbodiedEmissions(double embodiedEmissions) {
        this.embodiedEmissions = embodiedEmissions;
    }

    @Override
    public String toString() {
        return "id: " + id + "\nName: " + component + "\nEnergy: " + energy + "\nEmission Factor: " + "\nEmbodied Emissions: " + embodiedEmissions + "\nScore: " + score + "\n\n"; 
    }

    
}
