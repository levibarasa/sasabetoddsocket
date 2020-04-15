/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasabet.oddschange;

import com.sasabet.commons.GlobalEventsListener; 
import com.sasabet.commons.MessageListener;
import com.sportradar.unifiedodds.sdk.MessageInterest;
import com.sportradar.unifiedodds.sdk.OddsFeed;
import com.sportradar.unifiedodds.sdk.OddsFeedSessionBuilder;
import com.sportradar.unifiedodds.sdk.ProducerManager;
import com.sportradar.unifiedodds.sdk.SportsInfoManager;
import com.sportradar.unifiedodds.sdk.cfg.OddsFeedConfiguration;
import com.sportradar.unifiedodds.sdk.exceptions.InitException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author levi
 */
public class OddsChange {

    public static final String SDK_ACCESS_TOKEN = "KMxwA1QgAnVnrJUahj";
    public static final int NODE_ID = 700;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName() + "-" + 4.0);

    public static void main(String[] args) throws InitException, IOException, InterruptedException, ParseException {
        OddsFeedConfiguration config = OddsFeed.getOddsFeedConfigurationBuilder()
                .setAccessToken(SDK_ACCESS_TOKEN)
                .selectIntegration()
                .setSdkNodeId(NODE_ID)
                .setDefaultLocale(Locale.ENGLISH)
                .setDesiredLocales(Arrays.asList(Locale.FRENCH, Locale.GERMAN))
                .build();
        // create the new feed
        OddsFeed oddsFeed = new OddsFeed(new GlobalEventsListener(), config);
        ProducerManager producerManager = oddsFeed.getProducerManager();
//        producerManager.setProducerRecoveryFromTimestamp(3, 1580230877767L);


        // With the sportsInfoManager helper you can access various data about the ongoing events
        SportsInfoManager sportsInfoManager = oddsFeed.getSportsInfoManager();


        OddsFeedSessionBuilder sessionBuilder = oddsFeed.getSessionBuilder();
//// 
        MessageListener listener = new MessageListener("AllMessages");
        sessionBuilder.setListener(listener).setMessageInterest(MessageInterest.AllMessages).build();

//	         Open the feed with all the built sessions
        oddsFeed.open();
        
        }

}
