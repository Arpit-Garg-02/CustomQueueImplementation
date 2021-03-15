/*
* Class name: CustomQueue
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 13/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 13/Mar/2021
*
* Description: Queue class for creating queue and do operations
*/
package com.nagarro.customqueueimplementation.service;

import com.nagarro.customqueueimplementation.exception.IllegalStateException;
import com.nagarro.customqueueimplementation.model.Node;

public class CustomQueue {
    private static final String QUEUE_IS_EMPTY = "Queue is Empty!";
    private int length;
    private Node front, rear;

    public CustomQueue() {
        length = 0;
        front = rear = null;
    }

    /**
     * check queue is empty or not
     * 
     * @return
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Inserting/Enqueue value in queue
     * 
     * @param value
     */
    public void enqueue(int value) {
        Node node = new Node();
        node.setValue(value);
        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }
        rear = node;
        length++;
    }

    /**
     * Delete/Dequeue value from queue
     * 
     * @return
     */
    public int dequeue() {
        if (isEmpty())
            new IllegalStateException(QUEUE_IS_EMPTY);
        int dequeueValue = front.getValue();
        front = front.getNext();
        length--;
        if (isEmpty())
            rear = null;
        return dequeueValue;
    }

    /**
     * return peek value from queue
     * 
     * @return
     */
    public int peek() {
        if (isEmpty()) {
            new IllegalStateException(QUEUE_IS_EMPTY);
        }
        return front.getValue();
    }

    /**
     * search value in queue
     * 
     * @param searchValue
     * @return
     */
    public boolean contains(int searchValue) {
        if (isEmpty()) {
            new IllegalStateException(QUEUE_IS_EMPTY);
        }
        Node node = front;
        while (node != null) {
            if (node.getValue() == searchValue)
                return true;
            node = node.getNext();
        }
        return false;
    }

    /**
     * return the size of queue
     * 
     * @return
     */
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return length;
    }

    /**
     * calculate the value for a node
     * 
     * @param index
     * @return
     */
    private Node getNode(int index) {
        int s = length - 1;
        Node temp = front;
        while (s != index) {
            temp = temp.getNext();
            s--;
        }
        return temp;
    }

    /**
     * Reverse the queue
     */
    public void reverse() {
        int left = 0;
        int right = length - 1;
        while (left < right) {
            Node leftNode = getNode(left);
            Node rightNode = getNode(right);
            int temp = leftNode.getValue();
            leftNode.setValue(rightNode.getValue());
            rightNode.setValue(temp);
            left++;
            right--;
        }
    }

    /**
     * Iterator for queue
     */
    public String toString() {
        String output = "";
        Node node = front;
        while (node != null) {
            output += ", " + node.getValue();
            node = node.getNext();
        }
        return "[" + output.substring(1) + " ]";
    }

    /**
     * Queue Traversal
     */
    public void traverse() {
        if (isEmpty()) {
            new IllegalStateException(QUEUE_IS_EMPTY);
        }
        Node node = front;
        while (node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
