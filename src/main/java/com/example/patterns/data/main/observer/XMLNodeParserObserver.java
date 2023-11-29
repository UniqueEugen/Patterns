package com.example.patterns.data.main.observer;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLNodeParserObserver implements XMLNodeObserver {
    @Override
    public void onNodeVisited(Node node) {
        String nodeName = node.getNodeName();
        String nodeValue = getNodeValue(node);
        System.out.println("Visited node: " + nodeName + " - " + nodeValue);
    }

    private String getNodeValue(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            return element.getTextContent();
        } else if (node.getNodeType() == Node.ATTRIBUTE_NODE) {
            return node.getNodeValue();
        }
        return "";
    }
}
