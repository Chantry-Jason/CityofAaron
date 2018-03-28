/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.cityofaaron.model;
import java.io.Serializable;

/**
 *
 * @author kenpc
 */
public class CropData implements Serializable{
    
    // CropData integers 
    private static int year; 
    private static int population;
    private static int acresOwned; 
    private static int cropYield; 
    private static int wheatInStore; 
    private static int numberWhoDied;
    private static int newPeople;
    private static int harvest;
    private static int harvestAfterOffering;
    private static int offering;
    private static int offeringBushels;
    private static int peopleFed;
    private static int acresPlanted;
    private static int numStarved;
    private static int eatenByRats;
    private static int wheatForPeople;
    private static int costOfLandThisRound;

    public int getCostOfLandThisRound() {
        return costOfLandThisRound;
    }

    public void setCostOfLandThisRound(int costOfLandThisRound) {
        this.costOfLandThisRound = costOfLandThisRound;
    }

    //getters and setters
    public int getYear() {
        return year;
    }

    public int getPopulation() {
        return population;
    }

    public int getAcresOwned() {
        return acresOwned;
    }

    public int getCropYield() {
        return cropYield;
    }

    public int getWheatInStore() {
        return wheatInStore;
    }

    public int getNumberWhoDied() {
        return numberWhoDied;
    }

    public int getNewPeople() {
        return newPeople;
    }

    public int getHarvest() {
        return harvest;
    }

    public int getHarvestAfterOffering() {
        return harvestAfterOffering;
    }

    public int getOffering() {
        return offering;
    }

    public int getOfferingBushels() {
        return offeringBushels;
    }

    public int getPeopleFed() {
        return peopleFed;
    }

    public int getAcresPlanted() {
        return acresPlanted;
    }

    public int getNumStarved() {
        return numStarved;
    }

    public int getEatenByRats() {
        return eatenByRats;
    }

    public int getWheatForPeople() {
        return wheatForPeople;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setAcresOwned(int acresOwned) {
        this.acresOwned = acresOwned;
    }

    public void setCropYield(int cropYield) {
        this.cropYield = cropYield;
    }

    public void setWheatInStore(int wheatInStore) {
        this.wheatInStore = wheatInStore;
    }

    public void setNumberWhoDied(int numberWhoDied) {
        this.numberWhoDied = numberWhoDied;
    }

    public void setNewPeople(int newPeople) {
        this.newPeople = newPeople;
    }

    public void setHarvest(int harvest) {
        this.harvest = harvest;
    }

    public void setHarvestAfterOffering(int harvestAfterOffering) {
        this.harvestAfterOffering = harvestAfterOffering;
    }

    public void setOffering(int offering) {
        this.offering = offering;
    }

    public void setOfferingBushels(int offeringBushels) {
        this.offeringBushels = offeringBushels;
    }

    public void setPeopleFed(int peopleFed) {
        this.peopleFed = peopleFed;
    }

    public void setAcresPlanted(int acresPlanted) {
        this.acresPlanted = acresPlanted;
    }

    public void setNumStarved(int numStarved) {
        this.numStarved = numStarved;
    }

    public void setEatenByRats(int eatenByRats) {
        this.eatenByRats = eatenByRats;
    }

    public void setWheatForPeople(int wheatForPeople) {
        this.wheatForPeople = wheatForPeople;
    }
    
  
}
