package splitwise.expense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseEventManager {
    private static ExpenseEventManager instance;
    private Map<ExpenseEvent, List<ExpenseListener>> listeners;

    private ExpenseEventManager() {
        this.listeners = new HashMap<>();
        for (ExpenseEvent event : ExpenseEvent.values()) {
            listeners.put(event, new ArrayList<>());
        }
    }

    public static synchronized ExpenseEventManager getExpenseEventManager() {
        if (instance == null) {
            instance = new ExpenseEventManager();
        }
        return instance;
    }

    public void addListener(ExpenseEvent event, ExpenseListener listener) {
        List<ExpenseListener> eventListeners = listeners.get(event);
        if (!eventListeners.contains(listener)) {
            eventListeners.add(listener);
        }
    }

    public void removeListener(ExpenseEvent event, ExpenseListener listener) {
        List<ExpenseListener> eventListeners = listeners.get(event);
        if (eventListeners.contains(listener)) {
            eventListeners.remove(listener);
        }
    }

    public void notify(ExpenseEvent event, Expense expense) {
        List<ExpenseListener> eventListeners = listeners.get(event);
        for (ExpenseListener listener : eventListeners) {
            listener.notify(event, expense);
        }
    }
}
