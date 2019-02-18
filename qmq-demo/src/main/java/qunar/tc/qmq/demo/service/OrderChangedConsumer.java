/*
 * Copyright 2018 Qunar, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package qunar.tc.qmq.demo.service;

import org.springframework.stereotype.Service;
import qunar.tc.qmq.Message;
import qunar.tc.qmq.consumer.annotation.QmqConsumer;

@Service
public class OrderChangedConsumer {

    @QmqConsumer(subject = "order.changed", consumerGroup = "ordercenter", executor = "workerExecutor")
    public void onMessage(Message message) {
        long orderId = message.getLongProperty("orderId");
        String name = message.getStringProperty("name");

        //do work
        System.out.println(message);
    }
}
