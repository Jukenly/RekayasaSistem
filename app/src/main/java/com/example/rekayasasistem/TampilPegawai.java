

package com.example.rekayasasistem;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by muhammadyusuf on 01/19/2017.
 * kodingindonesia
 */

public class TampilPegawai extends AppCompatActivity implements View.OnClickListener {
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


    private Button buttonUpdate;
    private Button buttonDelete;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_pegawai);

        Intent intent = getIntent();

        id = intent.getStringExtra(konfigurasi.EMP_ID);

        editTextid = (EditText) findViewById(R.id.editTextID);
        editTextnoinduk = (EditText) findViewById(R.id.editTextNOINDUK);
        editTextname = (EditText) findViewById(R.id.editTextNAME);
        editTextjeniskelamin = (EditText) findViewById(R.id.editTextJK);
        editTextalamat = (EditText) findViewById(R.id.editTextALAMAT);
        editTextnamawali = (EditText) findViewById(R.id.editTextNAMAWALI);
        editTextnotelp = (EditText) findViewById(R.id.editTextNOTELP);
        editTextsekolahasal = (EditText) findViewById(R.id.editTextSEKOLAHASAL);
        editTexttanggal = (EditText) findViewById(R.id.editTextTANGGALLAHIR);
        editTexttempatlahir = (EditText) findViewById(R.id.editTextTEMPATLAHIR);


        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);

        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        editTextid.setText(id);

        getEmployee();
    }

    private void getEmployee() {
        class GetEmployee extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilPegawai.this, "Fetching...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_EMP, id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String noinduk = c.getString(konfigurasi.TAG_NOINDUK);
            String name = c.getString(konfigurasi.TAG_NAMA);
            String tanggallahir = c.getString(konfigurasi.TAG_TANGGALLAHIR);
            String alamat = c.getString(konfigurasi.TAG_ALAMAT);
            String jeniskelamin = c.getString(konfigurasi.TAG_JENISKELAMIN);
            String notelp = c.getString(konfigurasi.TAG_NOTELP);
            String sekolahasal = c.getString(konfigurasi.TAG_SEKOLAHASAL);
            String namawali = c.getString(konfigurasi.TAG_NAMAWALI);
            String tempatlahir = c.getString(konfigurasi.TAG_TEMPATLAHIR);

            editTextname.setText(name);
            editTextnoinduk.setText(noinduk);
            editTextid.setText(id);
            editTextalamat.setText(alamat);
            editTextjeniskelamin.setText(jeniskelamin);
            editTextnotelp.setText(notelp);
            editTexttanggal.setText(tanggallahir);
            editTextsekolahasal.setText(sekolahasal);
            editTextnamawali.setText(namawali);
            editTexttempatlahir.setText(tempatlahir);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateEmployee() {
        final String id = editTextid.getText().toString().trim();
        final String name = editTextname.getText().toString().trim();
        final String noinduk = editTextnoinduk.getText().toString().trim();
        final String alamat = editTextalamat.getText().toString().trim();
        final String jk = editTextjeniskelamin.getText().toString().trim();
        final String namawali = editTextnamawali.getText().toString().trim();
        final String notelp = editTextnotelp.getText().toString().trim();
        final String sekolahasal = editTextsekolahasal.getText().toString().trim();
        final String tanggal = editTexttanggal.getText().toString().trim();
        final String tempatlahir = editTexttempatlahir.getText().toString().trim();


        class UpdateEmployee extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilPegawai.this, "Updating...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TampilPegawai.this, s, Toast.LENGTH_LONG).show();
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected String doInBackground(Void... params) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(konfigurasi.KEY_EMP_ID, id);
                hashMap.put(konfigurasi.KEY_EMP_NOINDUK, noinduk);
                hashMap.put(konfigurasi.KEY_EMP_NAMA, name);
                hashMap.put(konfigurasi.KEY_EMP_TANGGALLAHIR, tanggal);
                hashMap.put(konfigurasi.KEY_EMP_ALAMAT, alamat);
                hashMap.put(konfigurasi.KEY_EMP_JENISKELAMIN, jk);
                hashMap.put(konfigurasi.KEY_EMP_NOTELP, notelp);
                hashMap.put(konfigurasi.KEY_EMP_SEKOLAHASAL, sekolahasal);
                hashMap.put(konfigurasi.KEY_EMP_TEMPATLAHIR, tempatlahir);
                hashMap.put(konfigurasi.KEY_EMP_NAMAWALI, namawali);
                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(konfigurasi.URL_UPDATE_EMP, hashMap);

                return s;
            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }

    private void deleteEmployee() {
        class DeleteEmployee extends AsyncTask<Void, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilPegawai.this, "Updating...", "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TampilPegawai.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_DELETE_EMP, id);
                return s;
            }
        }

        DeleteEmployee de = new DeleteEmployee();
        de.execute();

    }

    private void confirmDeleteEmployee() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Kamu Yakin Ingin Menghapus Data ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteEmployee();
                        startActivity(new Intent(TampilPegawai.this,TampilSemuaPgw.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v == buttonUpdate) {
            updateEmployee();
        }

        if (v == buttonDelete) {
            confirmDeleteEmployee();


        }
    }

    public void pindah(View view) {
        Intent intent = new Intent(TampilPegawai.this, TampilSemuaPgw.class);
        startActivity(intent);
    }
}