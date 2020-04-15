/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sasabet.commons;

import com.sportradar.unifiedodds.sdk.SDKGlobalEventsListener;
import com.sportradar.unifiedodds.sdk.oddsentities.ProducerDown;
import com.sportradar.unifiedodds.sdk.oddsentities.ProducerStatus;
import com.sportradar.unifiedodds.sdk.oddsentities.ProducerUp;
import com.sportradar.utils.URN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author levi
 */
public class GlobalEventsListener  implements SDKGlobalEventsListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

        /**
         * Invoked when a producer serving messages via the feed is down
         * (the SDK detected an invalid producer state)
         *
         * @param producerDown A {@link ProducerDown} instance
         *        specifying the associated producer and reason
         *
         * @deprecated from v2.0.8 in favour of {@link #onProducerStatusChange(ProducerStatus)}
         */
        @Override
        public void onProducerDown(ProducerDown producerDown) {
            logger.warn("Received producer down, reason: {}. Need to deactivate markets on all sport events currently handled by {}", producerDown.getReason(), producerDown.getProducer());
               }

        /**
         * Invoked when a producer gets reawaken and the SDK gets up in sync with it
         *
         * @param producerUp the object containing information about the producer status update
         *
         * @deprecated from v2.0.8 in favour of {@link #onProducerStatusChange(ProducerStatus)}
         */
        @Override
        public void onProducerUp(ProducerUp producerUp) {
            logger.info("Received producer up, reason: {}. Need to activate/validate/check all available markets currently handled by {}", producerUp.getReason(), producerUp.getProducer());
              }

        /**
         * Invoked when the producer status changes, some examples:
         * <p>
         * <ul>
         * <li>Producer up -> producer down</li>
         * <li>Producer down(processing queue delay) -> producer down(alive interval violation)</li>
         * <li>Producer down -> producer up</li>
         * <li>...</li>
         * </ul>
         * </p>
         *
         * @param producerStatus the new {@link ProducerStatus}
         * @since v2.0.8
         */
         @Override
    public void onProducerStatusChange(ProducerStatus producerStatus) {
         if (producerStatus.getProducer().getId() == 3) {
            if (producerStatus.isDown()) {
                logger.error("Producer is down"); 
            } else {
                logger.error("Producer is up now"); 
            }

        }

    }

        /**
         * Invoked when a connection to the feed is closed
         */
        @Override
        public void onConnectionDown() {
            logger.warn("Lost the connection to Betradar - all markets should be deactivated");

              }

        /**
         * Method invoked when a requested event recovery completes
         *
         * @param eventId the associated event identifier
         * @param requestId the identifier of the recovery request
         */
        @Override
        public void onEventRecoveryCompleted(URN eventId, long requestId) {
            logger.info("Received onEventRecoveryCompleted for event[{}], requestId: {}", eventId, requestId);
                }
}
