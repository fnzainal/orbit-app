package id.zainalfahrudin.orbit.model;

/**
 * Wrote by :
 * Zainal Fahrudin
 * fnzainal@gmail.com
 * on 24/09/16 7:07.
 */

public class DataModel {
    private String deskripsi;
    private String nama_os;
    private int icon;

    public String getNama_os() {
        return nama_os;
    }

    public void setNama_os(String nama_os) {
        this.nama_os = nama_os;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }


    public DataModel(String nama_os, String deskripsi, int icon) {
        this.nama_os = nama_os;
        this.deskripsi = deskripsi;
        this.icon = icon;
    }

}
