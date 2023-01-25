package AVLTree;

public class AVLTree<T extends Comparable<T>>
{
    private Node<T> root;

    public AVLTree()
    {
        this.root = null;
    }

    public Node<T> root()
    {
        return this.root;
    }

    public void root(Node<T> root)
    {
        this.root = root;
    }

    public void insert(T value)
    {
        if (this.isEmpty()) {
            this.root = new Node<T>(value);
            return;
        }

        this.insert(value, this.root);
    }

    public Node<T> insert(T value, Node<T> current)
    {
        if (current == null) {
            return new Node<T>(value);
        }

        Node<T> inserted;

        if (current.isGreaterThan(value)) {
            inserted = this.insert(value, current.left());
            current.left(inserted);
        } else if (current.isSmallerThan(value)) {
            inserted = this.insert(value, current.right());
            current.right(inserted);
        } else {
            return current;
        }

        inserted.parent(current);

        int newHeight = height(current) + Math.max(height(current.left()), height(current.right()));
        current.height(newHeight);

        int balanceFactor = this.balanceFactor(current);

        if (balanceFactor > 1) {
            if (current.left().isSmallerThan(value)) {
                this.rotateLeft(current.left());
                this.rotateRight(current);
            } else if (current.left().isGreaterThan(value)) {
                this.rotateRight(current);
            }
        }



        return current;
    }



    public int balanceFactor(Node<T> current)
    {
        if (current == null) {
            return 0;
        }

        return height(current.left()) - height(current.right());
    }

    public int height(Node<T> current)
    {
        if (current == null) {
            return 0;
        }

        return current.height();
    }

    public String traverseInPreOrder()
    {
        return this.traverseInPreOrder("", this.root);
    }

    private String traverseInPreOrder(String tree, Node<T> current)
    {
        tree = "<" + current.value();

        if (current.hasLeftChild()) {
            tree += this.traverseInPreOrder(tree, current.left());
        }

        if (current.hasRightChild()) {
            tree += this.traverseInPreOrder(tree, current.right());
        }

        tree += ">";

        return tree;
    }

    public void rotateLeft(Node<T> current)
    {
        Node<T> currentRight = current.right();

        current.right(currentRight.left());

        if (currentRight.left() != null) {
            currentRight.left().parent(current);
        }

        currentRight.parent(current.parent());

        if (current.parent() == null) {
            this.root = currentRight;
        } else if (current.isLeftChildOf(current.parent())) {
            current.parent().left(currentRight);
        } else {
            current.parent().right(currentRight);

        }

        currentRight.left(current);
        current.parent(currentRight);
    }

    public void rotateRight(Node<T> current)
    {
        Node<T> currentLeft = current.left();

        current.left(currentLeft.right());

        if (currentLeft.right() != null) {
            currentLeft.right().parent(current);
        }

        currentLeft.parent(current.parent());

        if (current.parent() == null) {
            this.root = currentLeft;
        } else if (current.isLeftChildOf(current.parent())) {
            current.parent().left(currentLeft);
        } else {
            current.parent().right(currentLeft);

        }

        currentLeft.right(current);
        current.parent(currentLeft);
    }

    private boolean isEmpty()
    {
        return this.root == null;
    }
}
