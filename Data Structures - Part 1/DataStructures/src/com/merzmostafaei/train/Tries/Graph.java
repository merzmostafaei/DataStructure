package com.merzmostafaei.train.Tries;

import java.util.*;

public class Graph {
    private class Node{
        private String lable;

        public Node(String lable){
            this.lable = lable;
        }

        @Override
        public String toString() {
            return lable;
        }
    }
    private Map<String,Node> nodes = new HashMap<>();
    private Map<Node, List<Node>>  adjecencyList = new HashMap<>();

    public void addNode(String lable){
        var node = new Node(lable);
        nodes.putIfAbsent(lable,node);
        adjecencyList.putIfAbsent(node,new ArrayList<>());
    }

    public void addEdge(String from, String to){
        var fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        //directecGraph  -- unidirectetGraph is bothWay
        adjecencyList.get(fromNode).add(toNode);
        //adjecencyList.get(toNode).add(fromNode);
    }
    public void removeNode(String lable){
        var node = nodes.get(lable);
        if (node == null) return;

        for (var n : adjecencyList.keySet()){
            adjecencyList.get(n).remove(node);
        }
        adjecencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to){
        var nodeFrom = nodes.get(from);
        var nodeTo = nodes.get(to);
        if (nodeFrom == null || nodeTo == null) return;


        adjecencyList.get(nodeFrom).remove(nodeTo);
    }

    public void traverseDepthFirst(String label){
        var node = nodes.get(label);
        if (node == null) return;

        Set<Node> visited = new HashSet<>();
        traverseDepthFirst(node, visited);

        for (var n : visited) {
            System.out.println(n);
        }

    }
    private void traverseDepthFirst(Node node,Set<Node> visited){
        if (node == null || visited.contains(node))
            return;

        visited.add(node);

        var neighbors = adjecencyList.get(node);
        if (neighbors == null) return;

        for (var neighbor : neighbors) {
            traverseDepthFirst(neighbor, visited);
        }

    }
    public void trversalIterativeDepthFirst(String lable){
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();

        var root = nodes.get(lable);
        if (root == null) return;
        stack.push(root);

        while (!stack.isEmpty()){
            var current = stack.pop();
            if(visited.contains(current))continue;
            visited.add(current);

            System.out.println(current);

            for (var neighbor : adjecencyList.get(current)){
                if (!visited.contains(neighbor)){
                    stack.push(neighbor);
                }
            }

        }
    }

    public void traversalIterativeBreadthFirst(String lable){
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        var root = nodes.get(lable);
        if (root == null) return;
        queue.add(root);

        while (!queue.isEmpty()){
            var current = queue.remove();
            if(visited.contains(current))continue;
            visited.add(current);

            System.out.println(current);

            for (var neighbor : adjecencyList.get(current)){
                if (!visited.contains(neighbor)){
                    queue.add(neighbor);
                }
            }

        }
    }
    public List<String> TopologicalSorting(String lable){
        var root = nodes.get(lable);
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        TopologicalSorting(root,visited,stack);

        List<String> sorted = new ArrayList<>();
        while (!stack.isEmpty()){
            sorted.add(stack.pop().lable);
        }
        return sorted;
    }
    private void TopologicalSorting(Node node,Set<Node> visited,Stack<Node> stack){

        if (visited.contains(node)) return;
        visited.add(node);

        var neighbors = adjecencyList.get(node);
        if (neighbors != null) {
            for( var n : neighbors){
                TopologicalSorting(n,visited,stack);
            }
        }
        stack.push(node);
    }

    public boolean hasCycle() {
        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        Set<Node> all = new HashSet<>(nodes.values()); // initialize with all graph nodes

        while (!all.isEmpty()) {
            var current = all.iterator().next();
            if (hasCycle(current, visiting, visited, all)) {
                return true; // cycle found
            }
        }
        return false; // no cycles in any component
    }

    private boolean hasCycle(Node node, Set<Node> visiting, Set<Node> visited, Set<Node> all) {
        all.remove(node);
        visiting.add(node);

        for (var neighbor : adjecencyList.getOrDefault(node, new ArrayList<>())) {
            if (visited.contains(neighbor)) continue;
            if (visiting.contains(neighbor)) return true; // back edge → cycle

            if (hasCycle(neighbor, visiting, visited, all)) return true;
        }

        visiting.remove(node);
        visited.add(node);
        return false;
    }





    public void print() {
        for (var source : adjecencyList.keySet()) {
            var targets = adjecencyList.get(source);
            if (!targets.isEmpty())
                System.out.println(source + " is connectet to " + targets);
        }
    }

}
