import java.util.LinkedList;

public class DeklarasiVariabel {
    public static void main(String[] args) {
        
        // 1. Deklarasi variabel integer bernama 'StrukturBaris'
        int StrukturBaris = 0;
        
        // 2. Deklarasi variabel String bernama 'KataBaru'
        String KataBaru = "Deklarasi tipe data String";
        
        // 3. Deklarasi array satu dimensi bernama 'empatAngka'
        int[] empatAngka = {7, 10, 20, 23};
        
        // 4. Deklarasi array dua dimensi bernama 'Angka'
        String[][] Angka = {
            {"1", "3", "5"},
            {"14", "19", "20"},
            {"22", "27", "29"}
        };
        
        // 5. Deklarasi LinkedList bernama 'listAngka'
        LinkedList<Integer> listAngka = new LinkedList<>();
        listAngka.add(22);
        listAngka.add(19);
        listAngka.add(44);
        listAngka.add(60);
        listAngka.add(72);
        
        // Menampilkan hasil deklarasi
        System.out.println("=== HASIL DEKLARASI ===\n");
        
        System.out.println("1. StrukturBaris (integer): " + StrukturBaris);
        
        System.out.println("\n2. KataBaru (String): " + KataBaru);
        
        System.out.println("\n3. empatAngka (array 1D):");
        for (int i = 0; i < empatAngka.length; i++) {
            System.out.println("   Index " + i + ": " + empatAngka[i]);
        }
        
        System.out.println("\n4. Angka (array 2D - 3x3):");
        for (int i = 0; i < Angka.length; i++) {
            System.out.print("   Baris " + i + ": ");
            for (int j = 0; j < Angka[i].length; j++) {
                System.out.print(Angka[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("\n5. listAngka (LinkedList):");
        System.out.println("   " + listAngka);
    }
}