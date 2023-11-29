package com.example.patterns.data.main.observer;

import org.w3c.dom.Node;

public interface XMLNodeObserver {
    void onNodeVisited(Node node);
}
