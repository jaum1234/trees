package RedBlackTree;

public class RedBlackTree<T extends Comparable<T>>
{
    private Node<T> root;

    public RedBlackTree()
    {
        this.root = null;
    }

    public Node<T> root()
    {
        return this.root;
    }

    public void root(Node<T> node)
    {
        this.root = node;
    }

    public void insert(T value)
    {
        if (this.isEmpty()) {
            this.root = new Node<T>(value);
            this.root.color(Color.BLACK);
            return;
        }

        this.root = this.insert(value, this.root);
    }

    private Node<T> insert(T value, Node<T> current)
    {
        if (current == null) {
            return new Node<T>(value);
        }

        int cmp = value.compareTo(current.value());

        Node<T> newNode;

        if (cmp < 0) {
            newNode = this.insert(value, current.left());
            current.left(newNode);
        } else if (cmp > 0) {
            newNode = this.insert(value, current.right());
            current.right(newNode);
        } else {
            return current;
        }

        newNode.parent(current);

        this.fixViolations(newNode);

        return current;
    }

    public void remove(T value)
    {
        if (this.isEmpty()) return;

        this.remove(value, this.root);
    }

    private void remove(T value, Node<T> current)
    {

    }

    private void fixViolations(Node<T> inserted)
    {
        if (inserted == this.root || inserted.parent().isBlack()) {
            return;
        }

        Node<T> parent = inserted.parent();
        Node<T> grandParent = parent.parent();

        if (parent.isLeftChildOf(grandParent)) {
            Node<T> uncle = grandParent.right();

            if (uncle != null && uncle.isRed()) {
                grandParent.color(Color.RED);
                parent.color(Color.BLACK);
                uncle.color(Color.BLACK);
                inserted = grandParent;

            } else {
                if (inserted.isRightChildOf(parent)) {
                    this.rotateLeft(parent);

                    inserted = parent;
                    parent = inserted.parent();
                }

                parent.color(Color.BLACK);
                grandParent.color(Color.RED);
                this.rotateRight(grandParent);
            }

        } else {
            Node<T> uncle = grandParent.left();

            if (uncle != null && uncle.isRed()) {
                grandParent.color(Color.RED);
                parent.color(Color.BLACK);
                uncle.color(Color.BLACK);
                inserted = grandParent;
            } else {
                if (inserted.isLeftChildOf(parent)) {
                    this.rotateRight(parent);

                    inserted = parent;

                    parent = inserted.parent();
                }

                parent.color(Color.BLACK);
                grandParent.color(Color.RED);
                this.rotateLeft(grandParent);
            }
        }

        this.root.color(Color.BLACK);

        this.fixViolations(inserted);
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
        } else if (current.isRightChildOf(current.parent())) {
            current.parent().right(currentLeft);
        } else {
            current.parent().left(currentLeft);
        }

        currentLeft.right(current);
        current.parent(currentLeft);
    }

    public String traverseInPreOrder()
    {
        return this.traverseInPreOrder("", this.root);
    }

    private String traverseInPreOrder(String tree, Node<T> node)
    {
        tree = "<" + node.value();

        if (node.hasLeft()) {
            tree += this.traverseInPreOrder(tree, node.left());
        }

        if (node.hasRight()) {
            tree += this.traverseInPreOrder(tree, node.right());
        }

        tree += ">";

        return tree;
    }

    public boolean isEmpty()
    {
        return this.root == null;
    }
}



