package com.merzmostafaei.train.Tries.unDirectedGraph;

import java.util.*;

public class WeightedGraph {
    private class Node{
        String lable;

        List<Edge> edges = new ArrayList<>();


        public String getLable() {
            return lable;
        }

        public Node(String lable) {
            this.lable = lable;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void addEdges(Node to,int weight){
            edges.add(new Edge(this,to,weight));
        }

        @Override
        public String toString() {
            return "Node{" +
                    "lable='" + lable + '\'' +
                    '}';
        }




    }
    private class Edge{

        Node from;
        Node to;
        int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return  from.getLable() +
                    "-->" + to.getLable() +
                    ", weight=" + weight;
        }

    }
    private class NodeEntry{
        private Node node;
        private int priority;


        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }

    }

    private Map<String, Node> nodes = new HashMap<>();



    public void addNode(String lable){

        nodes.putIfAbsent(lable,new Node(lable));


    }
    public void addEdge(String from,String to, int weight){
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null) throw new IllegalArgumentException("Invalid node(s)");


        fromNode.addEdges(toNode,weight);
        toNode.addEdges(fromNode,weight);


    }

    public Path getShortesPath(String from, String to){
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)throw new IllegalArgumentException();

        Map<Node,Integer> distances = new HashMap<>();

        for(var node : nodes.values()){
            distances.put(node,Integer.MAX_VALUE);
        }
        distances.replace(fromNode,0);

        Map<Node,Node> privousNodes = new HashMap<>();
        Set<Node> visited = new HashSet<>();


        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparing(ne -> ne.priority)
        );
        queue.add(new NodeEntry(fromNode,0));

        while (!queue.isEmpty()){
            var current = queue.remove().node;
            visited.add(current);
            for (var edge : current.getEdges()){
                if(visited.contains(edge.to)){
                    continue;
                }
                var newDistance = distances.get(current) + edge.weight;
                if(newDistance < distances.get(edge.to)){
                    distances.replace(edge.to,newDistance);
                    privousNodes.put(edge.to,current);
                    queue.add(new NodeEntry(edge.to,newDistance));
                }
            }
        }


        return buildPath(toNode, privousNodes);

    }

    private static Path buildPath(Node toNode, Map<Node, Node> privousNodes) {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        var previous = privousNodes.get(toNode);

        while (previous != null){
            stack.push(previous);
            previous = privousNodes.get(previous);
        }
        var path = new Path();
        while (!stack.isEmpty()){
            path.add(stack.pop().lable);
        }
        return path;
    }

    public boolean hasCycle(){
        Set<Node> visited = new HashSet<>();

        for(Node node : nodes.values()){
            if (!visited.contains(node) && hasCycle(node,visited,null)){
                return true;
            }
        }
        return false;
    }
    private boolean hasCycle(Node node,Set<Node> visited,Node parent){
        visited.add(node);
        for(var edge : node.getEdges()){
            if(edge.to == parent)continue;
            if(visited.contains(edge.to) || hasCycle(edge.to,visited,node))return true;
        }
        return false;
    }

    public WeightedGraph getMinimumSpaningTree(){
        var tree = new WeightedGraph();
        if(nodes.isEmpty())return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparing(e->e.weight));

        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.lable);

        if(edges.isEmpty())return tree;

        while (tree.nodes.size() < nodes.size()){
            var minEdge = edges.remove();
            var nextNode = minEdge.to;

            if(tree.containNode(nextNode.lable))continue;

            tree.addNode(nextNode.lable);
            tree.addEdge(minEdge.from.lable,nextNode.lable,minEdge.weight);

            for (var edge : nextNode.getEdges()){
                if(!tree.containNode(edge.to.lable))
                    edges.add(edge);
            }
        }
        return tree;

    }

    public boolean containNode(String lable) {
        return nodes.containsKey(lable);
    }


    public void printGraph(){
        for (var source : nodes.values()){
            var edges = source.getEdges();
            if (!edges.isEmpty()){
                System.out.println(source.getLable()+ " is connected " + edges);
            }
        }
    }


}
