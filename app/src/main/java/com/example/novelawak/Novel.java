package com.example.novelawak;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Novel {
    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result {

        private String judul, penerbit, penulis, url_gambar, url_file,
                kategori,sinopsis,tahun_terbit,ISBN,jml_halaman;

        @SerializedName("body")
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getJudul() {
            return judul;
        }

        public void setJudul(String judul) {
            this.judul = judul;
        }

        public String getPenerbit() {
            return penerbit;
        }

        public void setPenerbit(String penerbit) {
            this.penerbit = penerbit;
        }

        public String getPenulis() {
            return penulis;
        }

        public void setPenulis(String penulis) {
            this.penulis = penulis;
        }

        public String getUrl_gambar() {
            return url_gambar;
        }

        public void setUrl_gambar(String url_gambar) {
            this.url_gambar = url_gambar;
        }

        public String getKategori() {
            return kategori;
        }

        public void setKategori(String kategori) {
            this.kategori = kategori;
        }

        public String getSinopsis() {
            return sinopsis;
        }

        public void setSinopsis(String sinopsis) {
            this.sinopsis = sinopsis;
        }

        public String getTahun_terbit() {
            return tahun_terbit;
        }

        public void setTahun_terbit(String tahun_terbit) {
            this.tahun_terbit = tahun_terbit;
        }

        public String getISBN() {
            return ISBN;
        }

        public void setISBN(String ISBN) {
            this.ISBN = ISBN;
        }

        public String getJml_halaman() {
            return jml_halaman;
        }

        public void setJml_halaman(String jml_halaman) {
            this.jml_halaman = jml_halaman;
        }

        public String getUrl_file() {
            return url_file;
        }

        public void setUrl_file(String url_file) {
            this.url_file = url_file;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "judul='" + judul + '\'' +
                    ", penerbit='" + penerbit + '\'' +
                    ", penulis='" + penulis + '\'' +
                    ", url_gambar='" + url_gambar + '\'' +
                    ", url_file='" + url_file + '\'' +
                    ", kategori='" + kategori + '\'' +
                    ", sinopsis='" + sinopsis + '\'' +
                    ", tahun_terbit='" + tahun_terbit + '\'' +
                    ", ISBN='" + ISBN + '\'' +
                    ", jml_halaman='" + jml_halaman + '\'' +
                    '}';
        }
    }
}
