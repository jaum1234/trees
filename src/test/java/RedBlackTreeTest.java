import RedBlackTree.RedBlackTree;
import RedBlackTree.Node;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RedBlackTreeTest
{
    private RedBlackTree<Integer> tree;

    @BeforeEach
    void setUp()
    {
        this.tree = new RedBlackTree<Integer>();
    }

    @Test
    @DisplayName("Should traverse tree in pre order.")
    void shouldTraverseTreeInPreOrder()
    {
        Node<Integer> parent = new Node<Integer>(7);
        Node<Integer> left = new Node<Integer>(5);
        Node<Integer> right = new Node<Integer>(9);

        this.tree.root(parent);
        parent.left(left);
        parent.right(right);

        String preOrderTree = this.tree.traverseInPreOrder();
        String expectedPreOrderTree = "<7<5><9>>";

        assertEquals(expectedPreOrderTree, preOrderTree);
    }

    @Test
    @DisplayName("Should rotate node to left.")
    void shouldRotateNodeToLeft()
    {
        Node<Integer> parent = new Node<Integer>(7);
        Node<Integer> right = new Node<Integer>(8);
        Node<Integer> rightOfRight = new Node<Integer>(9);

        this.tree.root(parent);

        right.parent(parent);

        parent.right(right);

        right.right(rightOfRight);

        rightOfRight.parent(right);

        this.tree.rotateLeft(right);

        String tree = this.tree.traverseInPreOrder();
        String expectedTree = "<7<9<8>>>";

        assertEquals(expectedTree, tree);
    }

    @Test
    @DisplayName("Should rotate node to right.")
    void shouldRotateNodeToRight()
    {
        Node<Integer> parent = new Node<Integer>(7);
        Node<Integer> left = new Node<Integer>(6);
        Node<Integer> leftOfLeft = new Node<Integer>(5);

        this.tree.root(parent);

        left.parent(parent);

        parent.left(left);

        left.left(leftOfLeft);

        leftOfLeft.parent(left);

        this.tree.rotateRight(left);

        String tree = this.tree.traverseInPreOrder();
        String expectedTree = "<7<5<6>>>";

        assertEquals(expectedTree, tree);
    }

    @Test
    @DisplayName("Should insert nodes correctly.")
    void shouldInsertNodesCorrectly()
    {
        this.tree.insert(10);
        this.tree.insert(7);
        this.tree.insert(11);
        this.tree.insert(4);
        this.tree.insert(8);

        String tree = this.tree.traverseInPreOrder();
        String expectedTree = "<10<7<4><8>><11>>";

        assertEquals(expectedTree, tree);
    }
}
