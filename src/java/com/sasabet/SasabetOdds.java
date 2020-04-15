/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasabet;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author levi
 */
@ServerEndpoint("/endpoint")
public class SasabetOdds {

    @OnMessage
    public String onMessage(String message) {
        return null;
    }
    
}
