package com.example.week3day3_threads;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Arrays;
import java.util.Random;

public class Async extends AsyncTask<String, String, String> {

    public Async(AsyncCallback asyncCallback) {
        this.asyncCallback = asyncCallback;
    }
    AsyncCallback asyncCallback;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        Random rand = new Random();
        int[] nums = new int[1000];
        int totalNums = 0;
        for(int i = 0; i < 1000; i++) {
            totalNums = i + 1;
            nums[i] = rand.nextInt(1000);
        }

        // show the log that all 1000 numbers have been generated
        strings[0] = "Finished generating " + totalNums + " numbers";
        publishProgress(strings);

        // sort the array from descending to ascending
        Arrays.sort(nums);

        // a new string to hold our sorted array
        String str = "";

        for (int i = 0; i < nums.length; i++) {
            str += nums[i] + " ";
        }
        return str;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Log.d("TAG", "onProgressUpdate: " + values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        asyncCallback.returnString(s);
    }

    interface AsyncCallback{
        // return our string of 1000 numbers
        void returnString(String string);
    }
}
