/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasabet.commons;
 

/**
 *
 * @author levi
 */
class OutcomeOddsModel {
        String outcomeDescription;
        double odds;
        double oddsprobability;
        String localeName;
        boolean playerOutcome;

    public OutcomeOddsModel() {
    }

    public OutcomeOddsModel(String outcomeDescription, double odds, double oddsprobability, String localeName, boolean playerOutcome) {
        this.outcomeDescription = outcomeDescription;
        this.odds = odds;
        this.oddsprobability = oddsprobability;
        this.localeName = localeName;
        this.playerOutcome = playerOutcome;
    }

    public String getOutcomeDescription() {
        return outcomeDescription;
    }

    public void setOutcomeDescription(String outcomeDescription) {
        this.outcomeDescription = outcomeDescription;
    }

    public double getOdds() {
        return odds;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }

    public double getOddsprobability() {
        return oddsprobability;
    }

    public void setOddsprobability(double oddsprobability) {
        this.oddsprobability = oddsprobability;
    }

    public String getLocaleName() {
        return localeName;
    }

    public void setLocaleName(String localeName) {
        this.localeName = localeName;
    }

    public boolean isPlayerOutcome() {
        return playerOutcome;
    }

    public void setPlayerOutcome(boolean playerOutcome) {
        this.playerOutcome = playerOutcome;
    }

     

    
     
}
