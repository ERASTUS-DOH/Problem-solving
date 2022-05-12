package binaryTree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.Stack;

public class SimpleBinaryTree implements BinaryTree<K, V>{
    protected BinaryTreeNode<K, V> root;


    @Override
    public void put(K key, V value) {
        if(root == null){
            root = new BinaryTreeNode<K, V>(key, value);
        }else{
            put(key, value, root);
        }
    }

    public void put(K key, V value, BinaryTreeNode<K,V> node){
        if(((Comparable) key).compareTo(node.getKey()) == 0){
            node.setKey(key);
            node.setValue(value);
        }else if(((Comparable) key).compareTo(node.getKey()) < 0){
            if(node.getLeft().isPresent()){
                put(key, value, node.getLeft().get());
            }else{
                node.setLeft(new BinaryTreeNode<>(key, value));
            }
        }else {
            if(node.getRight().isPresent()){
                put(key, value, node.getRight().get());
            }else {
                node.setRight(new BinaryTreeNode<>(key, value));
            }
        }
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.ofNullable(root).flatMap(n->get(key, n));
    }

    public Optional<V> get(K key, BinaryTreeNode<K,V> node){
        if(((Comparable) key).compareTo(node.getKey()) == 0){
            return Optional.of(node.getValue());
        }else if(((Comparable) key).compareTo(node.getKey()) < 0){
            return node.getLeft().flatMap(n->get(key, n));
        }else{
            return node.getRight().flatMap(n->get(key, n));
        }
    }

    public Optional<K> minKey(){
        return Optional.ofNullable(root).map(this::minKey);
    }

    public void printDfs(){
        Optional.ofNullable(this.root).ifPresent(this::printDfs);
    }

    public void printDfs(BinaryTreeNode<K, V> node){
        System.out.println(" PRE-ORDER " + node.getKey());
        node.getLeft().ifPresent(this::printDfs);
        System.out.println("INORDER " + node.getKey());
        node.getRight().ifPresent(this::printDfs);
        System.out.println("POST " + node.getKey());
    }

    public void printBfs(){
        Optional.ofNullable(this.root).ifPresent(r->{
            Queue<BinaryTreeNode<K,V>> queue = new LinkedList<>();
            queue.add(r);
            while (!queue.isEmpty()){
                BinaryTreeNode<K, V> node = queue.remove();
                System.out.println(node.getKey());
                node.getLeft().ifPresent(queue::add);
                node.getRight().ifPresent(queue::add);
            }
        });
    }

    public void printNonRecursiveDfs(){
        Optional.ofNullable(this.root).ifPresent(r->{
            Stack<BinaryTreeNode<K,V>> stack = new Stack<>();
            stack.push(r);
            while (!stack.isEmpty()){
                BinaryTreeNode<K, V> node = stack.pop();
                System.out.println(node.getKey());
                node.getLeft().ifPresent(stack::push);
                node.getRight().ifPresent(stack::push);
            }
        });
    }

    private K minKey(BinaryTreeNode<K, V> node){
        return node.getLeft().map(this::minKey).orElse(node.getKey());
    }

    public void leftRotate(BinaryTreeNode<K, V> nodeX, BinaryTreeNode<K,V> parentNode){
        BinaryTreeNode<K, V> nodeY = nodeX.getRight().get();
        nodeX.setRight(nodeY.getLeft().orElse(null));
        if(parentNode == null){
            this.root = nodeY;
        } else if (parentNode.getLeft().filter(n -> n == nodeX).isPresent()) {
            parentNode.setLeft(nodeY);
        }else {
            parentNode.setRight(nodeY);
            nodeY.setLeft(nodeX);
        }
    }

    public void rightRotate(BinaryTreeNode<K,V> nodeX, BinaryTreeNode<K, V> parentNode){
        BinaryTreeNode<K,V> nodeY = nodeX.getLeft().get();
        nodeX.setLeft(nodeY.getRight().orElse(null));
        if(parentNode == null){
            this.root = nodeY;
        } else if (parentNode.getRight().filter(node -> node == nodeX).isPresent()) {
            parentNode.setRight(nodeY);
        }else{
            parentNode.setRight(nodeX);
            parentNode.setLeft(nodeY);
        }
    }
}
