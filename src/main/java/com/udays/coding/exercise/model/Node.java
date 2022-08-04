package com.udays.coding.exercise.model;

import java.util.List;

public class Node {

    public int val;
    public Node next;
    public List<Node> neighbors;
    Node() {}
    public Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }

}
