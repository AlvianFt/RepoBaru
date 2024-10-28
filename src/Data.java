/**
 * Kelas Data yang berisi atribut nama dan presence
 */
public class Data {

    public String nama;
    public String presence;

    /**
     * Constructor untuk menginisialisasi nama dan presence siswa.
     * @param nama Nama siswa
     * @param presence Status kehadiran siswa
     */
    public Data(String nama, String presence) {
        this.nama = nama;
        this.presence = presence;
    }
}
