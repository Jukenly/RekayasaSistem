<?php

 /*
 
 penulis: Muhammad yusuf
 website: https://www.kodingindonesia.com/
 
 */

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
				
		$noinduk = $_POST['noinduk'];
		$name = $_POST['name'];
		$datebirth = $_POST['tanggallahir'];
		$address = $_POST['alamat'];
		$sex = $_POST['jeniskelamin'];

		$number = $_POST['notelp'];
		$sekolah = $_POST['sekolahasal'];
		$namawali = $_POST['namawali'];
		$tempatlahir = $_POST['tempatlahir'];
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_siswa (noinduk,nama,tanggallahir,alamat,jeniskelamin,notelp,sekolahasal,namawali,tempatlahir) 
		VALUES ('$noinduk','$name','$datebirth','$address','$sex ','$number ','$sekolah','$namawali','$tempatlahir')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Data Siswa';
		}else{
			echo 'Gagal Menambahkan Data Siswa';
		}
		
		mysqli_close($con);
	}
?>