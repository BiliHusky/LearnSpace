package search;

/**
 * Created by yjw on 18-7-4.
 */
public class KMP {
    public static void main(String[] args) {
        char[] p = {'A', 'B', 'C', 'D', 'A', 'B', 'D'};
        String str = "BBC ABCDAB ABCDABCDABDE ABCDABDE";
        char[] s = str.toCharArray();
        int[] next=getNext(p);
        for (int elem : next) {
            System.out.print(elem+" ");
        }
        System.out.println();
        kmpSearch2(s, p);
    }


   public static void kmpSearch(char[] s, char[] p) {
       int i=0;
       int j=0;
       int sLen=s.length;
       int pLen=p.length;
       int[] next = getNext(p);
       while (i < sLen && j < pLen) {
           if (j == -1 || s[i] == p[j]) {
               i++;
               j++;
           } else {
               j = next[j];
           }
       }

       if (j == pLen) {
           System.out.println("find at location :" + (i-j));
       } else {
           System.out.println("not found");
       }
   }

    public static void kmpSearch2(char[] s, char[] p) {
        int i=0;
        int j=0;
        int[] next = getNext(p);
        int sLen = s.length;
        int pLen = p.length;
        while (i < sLen) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }

            if (j == pLen) {
                System.out.println("find location :" + (i-j));
                j = next[j-1];
            }
        }
    }

    public static int[] getNext(char[] p) {
        int pLen = p.length;
        int[] next = new int[pLen];
        next[0]=-1;
        int k = -1;
        int j = 0;
        while (j < pLen-1) {
            if (k == -1 || p[j] == p[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }


}
