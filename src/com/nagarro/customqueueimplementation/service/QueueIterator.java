package com.nagarro.customqueueimplementation.service;

import java.util.Iterator;

import com.nagarro.customqueueimplementation.exception.IllegalStateException;
import com.nagarro.customqueueimplementation.model.Node;

public class QueueIterator implements Iterator {
    private static final String NO_SUCH_ELEMENT = "No such Element";
    private Node currentNode = null;
    private Node front = null;

    public QueueIterator(Node front) {
        this.front = front;
    }

    @Override
    public boolean hasNext() {
        if (currentNode == null && front != null) {
            return true;
        } else if (currentNode != null) {
            return currentNode.getNext() != null;
        }
        return false;
    }

    @Override
    public Object next() {
        if (currentNode == null) {
            currentNode = front;
            return front.getValue();
        } else if (currentNode != null) {
            currentNode = currentNode.getNext();
            return currentNode.getValue();
        }
        throw new IllegalStateException(NO_SUCH_ELEMENT);
    }
}
