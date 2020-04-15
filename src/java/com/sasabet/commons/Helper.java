/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasabet.commons;
 
import com.sportradar.unifiedodds.sdk.OddsFeed;
import com.sportradar.unifiedodds.sdk.SportsInfoManager;
import com.sportradar.unifiedodds.sdk.entities.SportEvent;
import com.sportradar.unifiedodds.sdk.oddsentities.OutcomeResult;
import com.sportradar.utils.URN;

import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Pattern;
/**
 *
 * @author levi
 */
public class Helper {
    public static int splitIds(String urn){
        int id = 0;
      try
      {
          if(urn.isEmpty()){
              id = 1;
          }else{
              String[] splited = urn.split(":");
              if(splited.length > 3){
                  id = Integer.parseInt(splited[3]);
              }else{
                  id = Integer.parseInt(splited[2]);
              }

          }

          
      }catch (Exception e){
         e.getMessage();
          System.out.println("Error trying to convert urn to int");
      }
        return id;

    }



//    public static int gameId(){
//        Random random = new Random(System.currentTimeMillis());
//        int id =  ((1 + random.nextInt(2)) * 1000 + random.nextInt(10000));
//
//        return id;
//    }
    
    
    public static int generateRandomIntIntRange(String urn) {
        int id = splitIds(urn);
        return Integer.parseInt(Integer.toString(id).substring(2));
	}
     
    public static boolean startsWithDigit(String s) {
        return Pattern.compile("^[A-Z0-9]").matcher(s).find();
    }



    public static boolean matchStarted(Date scheduledTime) {
        Date now = new Date();
        Date scheduled = scheduledTime;

        if(scheduled.compareTo(now)> 0){
            return true;
        }else{
            return false;
        }


    }

    public static void handleCancelledEvents() {
    }

    public static Timestamp getScheduled(Date scheduled){

        return new java.sql.Timestamp(scheduled.getTime());


    } 
}
