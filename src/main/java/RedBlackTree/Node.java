package RedBlackTree;

enum Color {
    RED, BLACK
}

public class Node<T>
{
    private T value;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;
    private Color color;

    public Node(T value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
        this.color = Color.RED;
    }

    public T value()
    {
        return this.value;
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

    public Color color()
    {
       return this.color;
    }

    public void value(T value)
    {
        this.value = value;
    }

    public void left(Node<T> left)
    {
        this.left = left;
    }

    public void right(Node<T> right)
    {
        this.right = right;
    }

    public void parent(Node<T> parent)
    {
        this.parent = parent;
    }

    public void color(Color color)
    {
        this.color = color;
    }

    public boolean isLeftChildOf(Node<T> node)
    {
        return this.left == node;
    }

    public boolean isRightChildOf(Node<T> node)
    {
        return this.right == node;
    }

    public boolean hasLeft()
    {
        return this.left != null;
    }

    public boolean hasRight()
    {
        return this.right != null;
    }

    public boolean isLeaf()
    {
        return this.left == null && this.right == null;
    }

    public boolean hasParent()
    {
        return this.parent != null;
    }

    public boolean isRed()
    {
        return this.color == Color.RED;
    }

    public boolean isBlack()
    {
        return this.color == Color.BLACK;
    }
}
