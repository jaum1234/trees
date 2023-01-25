package AVLTree;

public class Node<T extends Comparable<T>>
{
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;
    private T value;
    private int height;

    public Node(T value)
    {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.value = value;
        this.height = 1;
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

    public Node<T> parent()
    {
        return this.parent;
    }

    public void parent(Node<T> parent)
    {
        this.parent = parent;
    }

    public void left(Node<T> left)
    {
        this.left = left;
    }

    public void right(Node<T> right)
    {
        this.right = right;
    }

    public int height()
    {
        return this.height;
    }

    public void height(int height)
    {
        this.height = height;
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

    public boolean isLeftChildOf(Node<T> node)
    {
        return node.left == this;
    }

    public boolean isRightChildOf(Node<T> node)
    {
        return node.right == node;
    }
}
