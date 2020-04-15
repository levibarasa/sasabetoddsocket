/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasabet.commons;

//import com.sasabetSDK.client.CancelledEvent;
//import com.sasabetSDK.client.ResultVoidedBet;
//import com.sasabetSDK.client.Resulting;
//import com.sasabetSDK.models.DatabaseFactory;
import com.sasabet.commons.Helper;

import com.sportradar.unifiedodds.sdk.OddsFeedListener;
import com.sportradar.unifiedodds.sdk.OddsFeedSession;
import com.sportradar.unifiedodds.sdk.entities.*;
import com.sportradar.unifiedodds.sdk.oddsentities.*;
import com.sportradar.unifiedodds.sdk.oddsentities.FixtureChange;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 *
 *  
 */
public class MessageListener  implements OddsFeedListener {
   
    private final Logger logger;

    public MessageListener(String listener_version) {
        this.logger = LoggerFactory.getLogger(this.getClass().getName() + "-" + listener_version);
    }
    
     public List<OddChangeModel> getChangedOdds(OddsFeedSession ofs,OddsChange<SportEvent> oddsChanges){
        List<OddChangeModel> oddchanges = new ArrayList<OddChangeModel> ();
        List<OutcomeOddsModel> ocom = new ArrayList<OutcomeOddsModel> ();
        OddChangeModel ocm = new OddChangeModel();
        
        for (MarketWithOdds marketOdds : oddsChanges.getMarkets()) {
            if (marketOdds.getStatus() == MarketStatus.Active && marketOdds.getOutcomeOdds().get(0).getOdds() > 1.01) {
            OutcomeOddsModel outcomeOddsModel = new OutcomeOddsModel();
        ocm.setGameid(Helper.splitIds(oddsChanges.getEvent().getId().toString()));
        ocm.setMarketDescription(marketOdds.getName());
        ocm.setFrenchname(marketOdds.getName(Locale.FRENCH));
        ocm.setMarketid(marketOdds.getId());
        ocm.setMarketname(marketOdds.getName());
        ocm.setMarketstatus(marketOdds.getStatus().toString());
            System.out.println("gameid: "+Helper.splitIds(oddsChanges.getEvent().getId().toString()));
        for (OutcomeOdds outcomeOdds : marketOdds.getOutcomeOdds()) {
             System.out.println("odds: "+outcomeOdds.getOdds());
            outcomeOddsModel.setLocaleName(outcomeOdds.getName(Locale.FRENCH));
            outcomeOddsModel.setOdds(outcomeOdds.getOdds());
            outcomeOddsModel.setOddsprobability(outcomeOdds.getProbability());
            outcomeOddsModel.setOutcomeDescription(outcomeOdds.getName());
            outcomeOddsModel.setPlayerOutcome(outcomeOdds.isPlayerOutcome()); 
             ocom.add(outcomeOddsModel);
        }
        ocm.setOutcomeOddsModel(ocom);
        oddchanges.add(ocm);
        }
        }
    
    return oddchanges;
    }
    
    @Override
    public void onOddsChange(OddsFeedSession ofs, OddsChange<SportEvent> oddsChanges) {
          getChangedOdds(ofs,oddsChanges);
       }

    @Override
    public void onBetStop(OddsFeedSession ofs, BetStop<SportEvent> bs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onBetSettlement(OddsFeedSession ofs, BetSettlement<SportEvent> bs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRollbackBetSettlement(OddsFeedSession ofs, RollbackBetSettlement<SportEvent> rbs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onBetCancel(OddsFeedSession ofs, BetCancel<SportEvent> bc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRollbackBetCancel(OddsFeedSession ofs, RollbackBetCancel<SportEvent> rbc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onFixtureChange(OddsFeedSession ofs, FixtureChange<SportEvent> fc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onUnparseableMessage(OddsFeedSession ofs, byte[] bytes, SportEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
