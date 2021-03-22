public class problem2 {

    public static void main(String[] args)
    {
        /*
        int[] a = {4, 5, -8, 10, -11, 0, 7};
        int[] b = {-4, 6, -3, -1, 5, 0, 7};
        int[] c = {4, 7, -5, -8, -9, -1, 2};

        int[] A = secondMaxProduct(a);
        System.out.println(A[0] + " " + A[1]);
        int[] B = secondMaxProduct(b);
        System.out.println(B[0] + " " + B[1]);
        int[] C = secondMaxProduct(c);
        System.out.println(C[0] + " " + C[1]);
        */

        int[] d = {10, 11, 15, 2, 5, 6, 8, 9};
        int[] e = {17, 20, 25, 29, 1, 5};
        int[] f = {20, 30, 40, 100, 105, 200};
        System.out.println(findShift(d, 0, d.length - 1));
        System.out.println(findShift(e, 0, e.length - 1));
        System.out.println(findShift(f, 0, f.length - 1));
    }

    public static int[] secondMaxProduct(int[] a)
    {
        int[] pos = new int[3];
        int[] neg = new int[3];
        int[] result = new int[2];

        for (int i = 0; i < a.length; i++) {    //array filling
            if (a[i] >= 0) { // positive
                if (Math.abs(a[i]) > Math.abs(pos[0])) {
                    pos[2] = pos[1];
                    pos[1] = pos[0];
                    pos[0] = a[i];
                } else if (Math.abs(a[i]) <= Math.abs(pos[0]) && Math.abs(a[i]) > Math.abs(pos[1])) {
                    pos[2] = pos[1];
                    pos[1] = a[i];
                } else if (Math.abs(a[i]) <= Math.abs(pos[1]) && Math.abs(a[i]) > Math.abs(pos[2])) {
                    pos[2] = a[i];
                }
            } else { // negative
                if (Math.abs(a[i]) > Math.abs(neg[0])) {
                    neg[2] = neg[1];
                    neg[1] = neg[0];
                    neg[0] = a[i];
                } else if (Math.abs(a[i]) <= Math.abs(neg[0]) && Math.abs(a[i]) > Math.abs(neg[1])) {
                    neg[2] = neg[1];
                    neg[1] = a[i];
                } else if (Math.abs(a[i]) <= Math.abs(neg[1]) && Math.abs(a[i]) > Math.abs(neg[2])) {
                    neg[2] = a[i];
                }
            }
        }

        int posMax = pos[0] * pos[1];
        int posSecMax = pos[0] * pos[2];
        int negMax = neg[0] * neg[1];
        int negSecMax = neg[0] * neg[2];

        if (posMax > negMax) {
            if (posSecMax > negMax) {
                result[0] = pos[0];
                result[1] = pos[2];
            } else {
                result[0] = neg[0];
                result[1] = neg[1];
            }
        } else if (negMax > posMax) {
            if (negSecMax > posMax) {
                result[0] = neg[0];
                result[1] = neg[2];
            } else {
                result[0] = pos[0];
                result[1] = pos[1];
            }
        }

        return result;
    }

    public static int findShift(int[] a, int low, int high) {
        if (low == high) {
            if (high == 0)  //no numbers shifted
                return 0;
            return high;
        }

        int mid = (low + high) / 2;
        int min = high;
        int temp;

        if (a[low] < a[min] || a[mid] < a[min])
            temp = findShift(a, low, mid);
        else
            temp = findShift(a, mid + 1, high);

        if (a[temp] < a[min])
            return temp;

        return min;
    }
}
