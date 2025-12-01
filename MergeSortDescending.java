public class MergeSortDescending {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Rekursif untuk membagi dua bagian
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Menggabungkan kembali
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data ke array L dan R
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;

        // Penggabungan (DESCENDING → terbesar ke terkecil)
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Sisa elemen L (jika masih ada)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Sisa elemen R (jika masih ada)
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] data = {45, 12, 78, 34, 56, 90, 11, 67};

        System.out.println("Data sebelum diurutkan:");
        for (int x : data) System.out.print(x + " ");

        mergeSort(data, 0, data.length - 1);

        System.out.println("\nData setelah Merge Sort (descending):");
        for (int x : data) System.out.print(x + " ");
    }
}
