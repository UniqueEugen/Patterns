package com.example.patterns.data.main.observer;

interface XMLSubject {
    void addObserver(XMLNodeObserver observer);
    void removeObserver(XMLNodeObserver observer);
    void notifyObservers(String elementName, String elementValue);
}
