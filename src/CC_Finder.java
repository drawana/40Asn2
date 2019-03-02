import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CC_Finder
{
    public static void main(String[] args)
    {
        int[][] img = new int[71][71];
        String str;
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("girl.txt"));
            int n = 26;
            for (int i = 0; i < 71; i++)
            {
                str = in.readLine();
                System.out.println(str);
                for (int j = 0; j < 71; j++)
                {
                    if (str.charAt(j) == '+')
                        img[i][j] = n++;
                }
            }
            in.close();
        }
        catch (IOException e)
        {
            System.out.println("File not found.");
        }


        uandf unionFind = new uandf(5041);
        for (int i = 0; i < 71; i++)
        {
            for (int j = 0; j < 71; j++)
            {
                if (img[i][j] != 0)
                {
                    if (i > 0 && img[i - 1][j] != 0)
                    {
                        unionFind.union_sets(unionFind.find_set(img[i][j]), unionFind.find_set(img[i - 1][j]));
                    }
                    if (j > 0 && img[i][j - 1] != 0)
                    {
                        unionFind.union_sets(unionFind.find_set(img[i][j]), unionFind.find_set(img[i][j - 1]));
                    }
                }

            }
        }

        unionFind.final_sets();
        char[][] imgComponents = new char[71][71];
        final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 71; i++)
        {
            for (int j = 0; j < 71; j++)
            {
                if (img[i][j] != 0)
                {
                    imgComponents[i][j] = ALPHABET.charAt(unionFind.find_set(img[i][j]).getName() - 26);
                }
                else
                {
                    imgComponents[i][j] = ' ';
                }

                System.out.print(imgComponents[i][j]);

            }
            System.out.println();

        }

        int[] counts = new int[26];
        for (int i = 0; i < 71; i++)
            for (int j = 0; j < 71; j++)
                if (imgComponents[i][j] != ' ')
                    counts[imgComponents[i][j] - 'A']++;

        System.out.println("Label : size");
        for (int i = 0; i < 26; i++)
        {
            if (counts[i] != 0)
            {
                System.out.printf("%c : %d\n", ALPHABET.charAt(i), counts[i]);
            }
        }

        for (int i = 0; i < 71; i++)
        {
            for (int j = 0; j < 71; j++)
            {
                if (img[i][j] != 0)
                {
                    imgComponents[i][j] = ALPHABET.charAt(unionFind.find_set(img[i][j]).getName() - 26);
                }
                else
                {
                    imgComponents[i][j] = ' ';
                }

                if (imgComponents[i][j] == ' ' || counts[imgComponents[i][j] - 'A'] > 2)
                    System.out.print(imgComponents[i][j]);

            }
            System.out.println();

        }

    }


}
