package org.osmdroid.mercury;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sto on 9/7/17.
 */

public class MessageBus {
    private static HashMap<Object, Set<MessageHandler>> messageHandlerMap = new HashMap<Object, Set<MessageHandler>>();

    public static void broadcast(Object key, Object value) {
        Set<MessageHandler> messageHandlers = messageHandlerMap.get(key);
        for (MessageHandler h : messageHandlers) {
            h.handleMessage(value);
        }
    }

    public static void registerMessageHandler(Object key, MessageHandler messageHandler) {
        Set<MessageHandler> messageHandlers = messageHandlerMap.get(key);
        if (messageHandlers == null) {
            messageHandlers = new HashSet<MessageHandler>();
            messageHandlerMap.put(key, messageHandlers);
        }

        messageHandlers.add(messageHandler);
    }

    public static void unregisterMessageHandler(MessageHandler messageHandler) {
        Set<Map.Entry<Object, Set<MessageHandler>>> entries = messageHandlerMap.entrySet();

        for (Map.Entry<Object, Set<MessageHandler>> entry : entries) {
            Set<MessageHandler> messageHandlers = entry.getValue();
            if (messageHandlers.contains(messageHandler)) {
                messageHandlers.remove(messageHandler);
            }
        }
    }
}

