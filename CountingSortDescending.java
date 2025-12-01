public class CountingSortDescending {

    public static void countingSortDescending(int[] arr) {
        int max = arr[0];

        // Mencari nilai maksimum
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        // Membuat array count
        int[] count = new int[max + 1];

        // Menghitung kemunculan setiap elemen
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Menyusun ulang array dari terbesar ke terkecil
        int idx = 0;
        for (int i = max; i >= 0; i--) {
            while (count[i] > 0) {
                arr[idx] = i;
                idx++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {10, 3, 15, 7, 8, 23, 17, 5};

        System.out.println("Data sebelum diurutkan:");
        for (int x : data) System.out.print(x + " ");

        countingSortDescending(data);

        System.out.println("\nData setelah Counting Sort (descending):");
        for (int x : data) System.out.print(x + " ");
    }
}
