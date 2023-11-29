package com.example.patterns.data.main.observer;

class XMLParsingNodeObserver implements XMLNodeObserver {
    @Override
    public void onElementParsed(String elementName, String elementValue) {
        System.out.println("Parsed element: " + elementName + " - " + elementValue);
    }
}
