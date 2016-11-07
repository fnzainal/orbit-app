package id.zainalfahrudin.orbit.model;

/**
 * Wrote by :
 * Zainal Fahrudin
 * fnzainal@gmail.com
 * on 24/09/16 7:07.
 */

public class DataModel {
    public String getDeskripsi() {
        return deskripsi;
    }

    public String getNama_os() {
        return nama_os;
    }

    public int getIcon() {
        return icon;
    }

    private String deskripsi;
    private String nama_os;
    private int icon;


    public DataModel(String nama_os, String deskripsi, int icon) {
        this.nama_os = nama_os;
        this.deskripsi = deskripsi;
        this.icon = icon;
    }

}
