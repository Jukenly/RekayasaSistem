<?php
 /*
 penulis: Muhammad yusuf
 website: https://www.kodingindonesia.com/

 Nama Database yang telah dibuat bernama "db_android" 
 Jika database yang kalian buat tidak sama dengan yang dibuat oleh penulis maka ganti nama database 
 sesuai dengan nama database yang kalian buat
 */
 
 //Mendefinisikan Konstanta
 define('HOST','localhost');
 define('USER','id15259235_root');
 define('PASS','Sistemrekayasa123!@#');
 define('DB','id15259235_db_rekayasasistem');
 
 //membuat koneksi dengan database
 $con = mysqli_connect(HOST,USER,PASS,DB) or die('Unable to Connect');
 ?>
