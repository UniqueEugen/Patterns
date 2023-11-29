package com.example.patterns.data.main.observer;

import org.w3c.dom.Node;

public interface XMLDocumentSubject {
    void addObserver(XMLNodeObserver observer);
    void removeObserver(XMLNodeObserver observer);
    void notifyObservers(Node node);
}
