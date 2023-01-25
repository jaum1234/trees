package BinarySearchTree;

public class Node<T extends Comparable<T>>
{
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value)
    {
        this.left = null;
        this.right = null;
        this.value = value;
    }

    public T value()
    {
        return this.value;
    }

    public void value(T value)
    {
        this.value = value;
    }

    public Node<T> left()
    {
        return this.left;
    }

    public Node<T> right()
    {
        return this.right;
    }

    public void left(Node<T> left)
    {
        this.left = left;
    }

    public void right(Node<T> right)
    {
        this.right = right;
    }

    public boolean isGreaterThan(T value)
    {
        return this.value.compareTo(value) > 0;
    }

    public boolean isSmallerThan(T value)
    {
        return this.value.compareTo(value) < 0;
    }

    public boolean isEqualTo(T value)
    {
        return this.value.compareTo(value) == 0;
    }

    public boolean isLeaf()
    {
        return this.left == null && this.right == null;
    }

    public boolean hasLeftChild()
    {
        return this.left != null;
    }

    public boolean hasRightChild()
    {
        return this.right != null;
    }
}