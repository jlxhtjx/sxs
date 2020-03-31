package com.example.sxs;

import android.app.ActionBar;
import android.os.AsyncTask;
import android.widget.Toast;

public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {


    @Override
    protected void onPreExecute() {
//        progressDialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
      /*  try {
            while (true) {
                int downloadPercent = doDownload();
                publishProgress(downloadPercent);
                if (downloadPercent >= 100) {
                    break;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;*/
      return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
   /*     progressDialog.setMessage("Downloaded" + values[0] + "%");*/
    }

    @Override
    protected void onPostExecute(Boolean result) {
        /*progressDialog.dismiss();
        if (result) {
            Toast.makeText(context, "Download ok~~", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Download failed", Toast.LENGTH_SHORT).show();
        }*/
    }
}


