package chain_link_question;

enum Side {NONE, LEFT, RIGHT}

public class ChainLink {
    private ChainLink left, right;

    public void append(ChainLink rightPart) {
        if (this.right != null)
            throw new IllegalStateException("Link is already connected.");

        this.right = rightPart;
        rightPart.left = this;
    }

    public Side longerSide() {
        ChainLink link = this;
        int left = 0;
        while (link.left != null) {
            if (link.left == this)
                return Side.NONE;

            left++;
            link = link.left;
        }

        link = this;
        int right = 0;
        while (link.right != null) {
            right++;
            link = link.right;
        }

        if (left == right)
            return Side.NONE;
        else if (left > right)
            return Side.LEFT;
        else
            return Side.RIGHT;
    }
}
