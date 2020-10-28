package com.example.rekayasasistem;

public class konfigurasi {
    //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.100.52/php/tambahPgw.php";
    public static final String URL_GET_ALL = "http://192.168.100.52/php/tampilSemuaPgw.php";
    public static final String URL_GET_EMP = "http://192.168.100.52/php/tampilPgw.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.100.52/php/updatePgw.php";
    public static final String URL_DELETE_EMP = "http://192.168.100.52/php/hapusPgw.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NOINDUK = "noinduk";
    public static final String KEY_EMP_NAMA = "name"; //desg itu variabel untuk posisi
    public static final String KEY_EMP_TANGGALLAHIR = "tanggallahir"; //salary itu variabel untuk gajih
    public static final String KEY_EMP_ALAMAT = "alamat";
    public static final String KEY_EMP_JENISKELAMIN = "jeniskelamin";
    public static final String KEY_EMP_GAMBAR = "gambar";
    public static final String KEY_EMP_NOTELP = "notelp";
    public static final String KEY_EMP_SEKOLAHASAL = "sekolahasal";
    public static final String KEY_EMP_NAMAWALI = "namawali";
    public static final String KEY_EMP_TEMPATLAHIR = "tempatlahir";


    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NOINDUK = "noinduk";
    public static final String TAG_NAMA = "name";
    public static final String TAG_TANGGALLAHIR = "tanggallahir";
    public static final String TAG_ALAMAT = "alamat";
    public static final String TAG_JENISKELAMIN = "jeniskelamin";
    public static final String TAG_GAMBAR = "gambar";
    public static final String TAG_NOTELP = "notelp";
    public static final String TAG_SEKOLAHASAL = "sekolahasal";
    public static final String TAG_NAMAWALI = "namawali";
    public static final String TAG_TEMPATLAHIR = "tempatlahir";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}
