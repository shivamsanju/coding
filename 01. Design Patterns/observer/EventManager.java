package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventManager {
    private Map<String, ArrayList<EventListener>> listeners = new HashMap<>();

    public EventManager(String... events) {
        for (String event : events) {
            listeners.put(event, new ArrayList<EventListener>());
        }
    }

    public void subscribe(String event, EventListener listener) {
        var eventListeners = listeners.get(event);
        if (!eventListeners.contains(listener)) {
            eventListeners.add(listener);
        }
    }

    public void unsubscribe(String event, EventListener listener) {
        var eventListeners = listeners.get(event);
        if (eventListeners.contains(listener)) {
            eventListeners.remove(listener);
        }
    }

    public void notifyListener(String event, String state) {
        var eventListeners = listeners.get(event);
        for (EventListener sub : eventListeners) {
            sub.update(event, state);
        }
    }
}
