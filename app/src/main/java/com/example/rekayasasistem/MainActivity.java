package com.example.rekayasasistem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


    public class MainActivity extends AppCompatActivity implements View.OnClickListener{

        //Dibawah ini merupakan perintah untuk mendefinikan View
        private EditText editTextid;
        private EditText editTextnoinduk;
        private EditText editTextname;
        private EditText editTextjeniskelamin;
        private EditText editTextalamat;
        private EditText editTextnamawali;
        private EditText editTextnotelp;
        private EditText editTextsekolahasal;
        private EditText editTexttanggal;
        private EditText editTexttempatlahir;



        private Button buttonsave;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Inisialisasi dari View
            // editTextid = (EditText) findViewById(R.id.editTextID);
            editTextnoinduk = (EditText) findViewById(R.id.editTextNOINDUK);
            editTextname = (EditText) findViewById(R.id.editTextNAME);
            editTextjeniskelamin = (EditText) findViewById(R.id.editTextJK);
            editTextalamat = (EditText) findViewById(R.id.editTextALAMAT);
            editTextnamawali = (EditText) findViewById(R.id.editTextNAMAWALI);
            editTextnotelp = (EditText) findViewById(R.id.editTextNOTELP);
            editTextsekolahasal = (EditText) findViewById(R.id.editTextSEKOLAHASAL);
            editTexttanggal = (EditText) findViewById(R.id.editTextTANGGALLAHIR);
            editTexttempatlahir = (EditText) findViewById(R.id.editTextTEMPATLAHIR);

            buttonsave = (Button) findViewById(R.id.buttonsave);


            //Setting listeners to button
            buttonsave.setOnClickListener(this);



        }


        //Dibawah ini merupakan perintah untuk Menambahkan Pegawai (CREATE)
        private void addEmployee(){

            final String name = editTextname.getText().toString().trim();
            final String noinduk = editTextnoinduk.getText().toString().trim();
            final String alamat = editTextalamat.getText().toString().trim();
            final String jk = editTextjeniskelamin.getText().toString().trim();
            final String namawali = editTextnamawali.getText().toString().trim();
            final String notelp = editTextnotelp.getText().toString().trim();
            final String sekolahasal = editTextsekolahasal.getText().toString().trim();
            final String tanggal = editTexttanggal.getText().toString().trim();
            final String tempatlahir = editTexttempatlahir.getText().toString().trim();


            class AddEmployee extends AsyncTask<Void,Void,String> {

                ProgressDialog loading;

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    loading = ProgressDialog.show(com.example.rekayasasistem.MainActivity.this,"Menambahkan...","Tunggu...",false,false);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    loading.dismiss();
                    Toast.makeText(com.example.rekayasasistem.MainActivity.this,s,Toast.LENGTH_LONG).show();
                }

                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                protected String doInBackground(Void... v) {
                    HashMap<String,String> params = new HashMap<>();
                    params.put(konfigurasi.KEY_EMP_NOINDUK, noinduk);
                    params.put(konfigurasi.KEY_EMP_NAMA, name);
                    params.put(konfigurasi.KEY_EMP_TANGGALLAHIR, tanggal);
                    params.put(konfigurasi.KEY_EMP_ALAMAT, alamat);
                    params.put(konfigurasi.KEY_EMP_JENISKELAMIN, jk);
                    params.put(konfigurasi.KEY_EMP_NOTELP, notelp);
                    params.put(konfigurasi.KEY_EMP_SEKOLAHASAL, sekolahasal);
                    params.put(konfigurasi.KEY_EMP_TEMPATLAHIR, tempatlahir);
                    params.put(konfigurasi.KEY_EMP_NAMAWALI, namawali);

                    RequestHandler rh = new RequestHandler();
                    String res = rh.sendPostRequest(konfigurasi.URL_ADD, params);
                    return res;
                }
            }

            AddEmployee ae = new AddEmployee();
            ae.execute();
        }

        @Override
        public void onClick(View v) {
            if (v == buttonsave) {
                addEmployee();
            }
            startActivity(new Intent(MainActivity.this,TampilSemuaPgw.class));

        }

    }


