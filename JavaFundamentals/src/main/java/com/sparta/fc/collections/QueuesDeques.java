package com.sparta.fc.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueuesDeques {
    public static void main(String[] args) {

    Queue<String> myNameQueue = new LinkedList<>();
        myNameQueue.add("Farah"); // adds to the back of the queue
        myNameQueue.add("Hannah");

        myNameQueue.peek(); // returns the first thing added to the stack
        myNameQueue.remove(); // removes the first thing added to the stack
        myNameQueue.poll(); // returns AND removes the first thing in the queue

        // Deques -- double ended queue, so supports stack and queue operations

        Deque<String> myNameStack = new ArrayDeque<>();
        myNameStack.push("Farah");
        myNameStack.push("Hannah");

        myNameStack.peek(); // returns the last thing added to the stack
        myNameStack.pop(); // removes the last thing added to the stack
    }
}
