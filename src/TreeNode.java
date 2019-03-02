public class TreeNode
{
    private int name, rank;
    private TreeNode parent;

    public TreeNode(int n, int r)
    {
        name = n;
        rank = r;
        parent = this;
    }

    public int getRank()
    {
        return rank;
    }

    public void incRank()
    {
        this.rank++;
    }

    public int getName()
    {
        return name;
    }

    public void setName(int name)
    {
        this.name = name;
    }

    public TreeNode getParent()
    {
        return parent;
    }

    public void setParent(TreeNode parent)
    {
        this.parent = parent;
    }

}