/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasabet.commons;

import java.util.List;

/**
 *
 * @author levi
 */
public class OddChangeModel {

    int gameid;
    int marketid;
    String marketDescription;
    String marketstatus;
    String marketname;
    String frenchname;
    List <OutcomeOddsModel> outcomeOddsModel;

    public OddChangeModel() {
    }

    public OddChangeModel(int gameid, int marketid, String marketDescription, String marketstatus, String marketname, String frenchname, List<OutcomeOddsModel> outcomeOddsModel) {
        this.gameid = gameid;
        this.marketid = marketid;
        this.marketDescription = marketDescription;
        this.marketstatus = marketstatus;
        this.marketname = marketname;
        this.frenchname = frenchname;
        this.outcomeOddsModel = outcomeOddsModel;
    }

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public int getMarketid() {
        return marketid;
    }

    public void setMarketid(int marketid) {
        this.marketid = marketid;
    }

    public String getMarketDescription() {
        return marketDescription;
    }

    public void setMarketDescription(String marketDescription) {
        this.marketDescription = marketDescription;
    }

    public String getMarketstatus() {
        return marketstatus;
    }

    public void setMarketstatus(String marketstatus) {
        this.marketstatus = marketstatus;
    }

    public String getMarketname() {
        return marketname;
    }

    public void setMarketname(String marketname) {
        this.marketname = marketname;
    }

    public String getFrenchname() {
        return frenchname;
    }

    public void setFrenchname(String frenchname) {
        this.frenchname = frenchname;
    }

    public List<OutcomeOddsModel> getOutcomeOddsModel() {
        return outcomeOddsModel;
    }

    public void setOutcomeOddsModel(List<OutcomeOddsModel> outcomeOddsModel) {
        this.outcomeOddsModel = outcomeOddsModel;
    }

   
    

}
