import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas utama untuk program presensi digital.
 */
public class Main {

    static ArrayList<Data> dataSiswa = new ArrayList<Data>();

    /**
     * Method utama yang menginisialisasi sistem presensi digital.
     * @param args Argumen
     */
    public static void main(String[] args) {
        addData();

        Scanner input = new Scanner(System.in);

        System.out.println("Selamat Datang di Sistem Presensi Digital.");

        boolean exit = false;
        while(!exit) {
            System.out.println("Daftar siswa dalam presensi saat ini:\n=================================================");
            for (int i = 0; i < dataSiswa.size(); i++) {
                System.out.println(i + 1 + ". " + dataSiswa.get(i).nama + " - [" + dataSiswa.get(i).presence + "]");
            }
            System.out.print("=================================================\nPilih nomor yang ingin anda presensi (99 untuk keluar): ");
            try {
                int nomor = input.nextInt();
                if (nomor == 99) {
                    System.out.println("Sedang proses keluar...");
                    System.out.println("Berhasil keluar dari sistem presensi.");
                    exit = true;
                } else if (nomor < 0 || nomor > dataSiswa.size()) {
                    System.out.println("-> Nomor pilihan tidak ditemukan.\n");
                } else {
                    cekPresensi(nomor);
                }
            } catch (Exception e) {
                System.out.println("-> Nomor pilihan tidak ditemukan.\n");
            }
        }
    }

    /**
     * Memeriksa dan mengubah status kehadiran siswa berdasarkan nomor indeks pilihan.
     * @param nomor index yang dipilih
     */
    private static void cekPresensi(int nomor) {
        if (dataSiswa.get(nomor - 1).presence.equals("Hadir")) {
            absensi(nomor, "Absen", "' menjadi Absen.\n");
        } else {
            absensi(nomor, "Hadir", "' menjadi Hadir.\n");
        }
    }

    /**
     * Memperbarui status kehadiran siswa yang dipilih.
     * @param nomor index yang dipilih
     * @param Absen jenis kehadiran
     * @param x Text tambahan
     */
    private static void absensi(int nomor, String Absen, String x) {
        dataSiswa.get(nomor - 1).presence = Absen;
        System.out.println("-> Mengubah presensi '" + dataSiswa.get(nomor - 1).nama + x);
    }

    /**
     * Menambahkan data siswa ke dalam daftar presensi.
     */
    private static void addData() {
        dataSiswa.add(new Data("Alvian Farhat", "Absen"));
        dataSiswa.add(new Data("Rima Marsya Sabrina Putri", "Absen"));
        dataSiswa.add(new Data("Alfito Afdhan Nugraha", "Absen"));
        dataSiswa.add(new Data("Muhammad Shaumi Rayyanullah", "Absen"));
    }
}
