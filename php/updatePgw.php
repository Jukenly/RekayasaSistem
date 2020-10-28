<?php 

 /*
 
 penulis: Muhammad yusuf
 website: https://www.kodingindonesia.com/
 
 */
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable 
		$id = $_POST['id'];
		$noinduk = $_POST['noinduk'];
		$name = $_POST['name'];
		$datebirth = $_POST['tanggallahir'];
		$address = $_POST['alamat'];
		$sex = $_POST['jeniskelamin'];
		
		$number = $_POST['notelp'];
		$sekolah = $_POST['sekolahasal'];
		$namawali = $_POST['namawali'];
		$tempatlahir = $_POST['tempatlahir'];
		
		//import file koneksi database 
		require_once('koneksi.php');

		//Membuat SQL Query
		$sql = "UPDATE tb_siswa SET noinduk='$noinduk',nama='$name',tanggallahir='$datebirth',alamat='$address',jeniskelamin='$sex',notelp='$number',sekolahasal='$sekolah',namawali='$namawali',tempatlahir='$tempatlahir' WHERE id=$id;";
		
		//Meng-update Database 
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Update Data Siswa';
		}else{
			echo 'Gagal Update Data Siswa';
		}
		
		mysqli_close($con);
	}
?>