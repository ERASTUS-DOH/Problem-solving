package binaryTree;

import java.util.Optional;

public class BinaryTreeNode<K, V> {
    private BinaryTreeNode<K, V> left;
    private BinaryTreeNode<K, V> right;
    private K key;
    private V value;

    public BinaryTreeNode(K key, V value){
        this.key =  key;
        this.value = value;
    }

    public Optional<BinaryTreeNode<K,V>> getLeft(){
        return Optional.ofNullable(this.left);
    }

    public Optional<BinaryTreeNode<K,V>> getRight(){
        return Optional.ofNullable(this.right);
    }

    public void setLeft(BinaryTreeNode<K, V> left){
        this.left =  left;
    }

    public void setRight(BinaryTreeNode<K, V> right){
        this.right = right;
    }

    public K getKey(){
        return this.key;
    }

    public void setKey(K key){
        this.key = key;
    }

    public V getValue(){
        return this.value;
    }

    public void setValue(V value){
        this.value = value;
    }
}
