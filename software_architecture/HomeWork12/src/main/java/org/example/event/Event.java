package org.example.event;

import java.util.ArrayList;
import java.util.List;

// Класс, представляющий событие
public class Event {
    private final String eventType;     // Тип события (например, "DEPOSIT" или "WITHDRAW")
    private final String eventData;     // Данные события (например, сумма операции)

    public Event(String eventType, String eventData) {
        this.eventType = eventType;
        this.eventData = eventData;
    }
    public String getEventType() {
        return eventType;
    }
    public String getEventData() {
        return eventData;
    }
}

