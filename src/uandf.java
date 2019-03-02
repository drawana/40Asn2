import java.util.ArrayList;

public class uandf
{


    private ArrayList<TreeNode> sets;
    boolean finalized;

    public uandf(int n)
    {
        finalized = false;
        sets = new ArrayList<>();
        for (int i = 0; i < n; i++)
            sets.add(new TreeNode(i, 0));

    }

    public void make_set(int i)
    {
        if (!finalized)
            sets.add(new TreeNode(i, 0));
    }

    private void link(TreeNode x, TreeNode y)
    {
        if (x.getRank() > y.getRank())
            y.setParent(x);
        else if (x.getRank() < y.getRank())
            x.setParent(y);
        else if (!x.equals(y))
        {
            y.setParent(x);
            x.incRank();
        }


    }

    public TreeNode find_set(int i)
    {
        TreeNode x = sets.get(i);
        return find_set(x);

    }

    public TreeNode find_set(TreeNode x)
    {
        if (!x.equals(x.getParent()))
            x.setParent(find_set(x.getParent()));
        return x.getParent();
    }

    public void union_sets(TreeNode x, TreeNode y)
    {
        if (!finalized)
        {
            link(find_set(x.getName()), find_set(y.getName()));
        }
    }

    public int final_sets()
    {
        int n = 1;
        for (int i = 0; i < sets.size() - 1; i++)
        {
            TreeNode set = sets.get(i);
            if (set.getParent().equals(set))
                set.setParent(new TreeNode(n++, set.getRank()));
        }
        finalized = true;
        return n;
    }


}
