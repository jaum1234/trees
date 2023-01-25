package BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>>
{
    private Node<T> root;

    public BinarySearchTree()
    {
        this.root = null;
    }

    /*
        Time complexity: O(log n)
     */
    public void insert(T value)
    {
        if (this.isEmpty()) {
            this.root = new Node<T>(value);
            return;
        }

        this.root = this.insert(value, this.root);
    }

    private Node<T> insert(T value, Node<T> current)
    {
        if (current == null) return new Node<T>(value);

        if (current.isGreaterThan(value)) {
            current.left(this.insert(value, current.left()));
        } else if (current.isSmallerThan(value)) {
            current.right(this.insert(value, current.right()));
        }

        return current;
    }

    /*
        Time complexity: O(log n)
     */
    public Comparable<T> search(T value)
    {
        if (this.isEmpty()) return null;

        return this.search(value, this.root);
    }

    private Comparable<T> search(T value, Node<T> current)
    {
        if (current.isEqualTo(value)) return current.value();

        if (current.isGreaterThan(value)) {
            return this.search(value, current.left());
        } else if (current.isSmallerThan(value)) {
            return this.search(value, current.right());
        }

        return null;
    }

    public void remove(T value) throws Exception
    {
        if (this.isEmpty()) throw new Exception("Cannot remove a node from a empty tree.");

        this.remove(value, this.root);
    }

    private Node<T> remove(T value, Node<T> current) throws Exception
    {
        if (current == null) return null;

        if (current.isGreaterThan(value)) {
            current.left(this.remove(value, current.left()));

        } else if (current.isSmallerThan(value)) {
            current.right(this.remove(value, current.right()));

        } else {
            if (current.isLeaf()) return null;
            if (!current.hasLeftChild()) return current.right();
            if (!current.hasRightChild()) return current.left();

            Node<T> minRightSubTree = this.min(current.right());
            this.remove(minRightSubTree.value(), current);

            minRightSubTree.left(current.left());
            minRightSubTree.right(current.right());

            return minRightSubTree;
        }

        return current;
    }

    public boolean isEmpty()
    {
        return this.root == null;
    }

    public String traverseInPreOrder()
    {
        return this.traverseInPreOrder(this.root);
    }

    private String traverseInPreOrder(Node<T> currentNode)
    {
        String tree = "<" + currentNode.value();

        if (currentNode.hasLeftChild()) {
            tree += this.traverseInPreOrder(currentNode.left());
        }

        if (currentNode.hasRightChild()) {
            tree += this.traverseInPreOrder(currentNode.right());
        }

        tree += ">";

        return tree;
    }

    public Node<T> min()
    {
        return this.min(this.root);
    }

    private Node<T> min(Node<T> currentNode)
    {
        if (!currentNode.hasLeftChild()) {
            return currentNode;
        }

        return this.min(currentNode.left());
    }
}