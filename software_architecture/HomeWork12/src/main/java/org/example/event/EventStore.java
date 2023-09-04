package org.example.event;

import java.util.ArrayList;
import java.util.List;

// Класс, представляющий хранилище событий
public class EventStore {
    private List<Event> events = new ArrayList<>();     // Список событий

    // Метод для добавления события в хранилище
    public void addEvent(Event event) {
        events.add(event);
    }
    // Метод для получения списка всех событий
    public List<Event> getEvents() {
        return events;
    }
}
