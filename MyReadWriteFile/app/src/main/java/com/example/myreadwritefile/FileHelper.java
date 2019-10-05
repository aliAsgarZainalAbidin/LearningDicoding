package com.example.myreadwritefile;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileHelper {
    public static final String TAG = FileHelper.class.getName();

    static void writeToFile(FileModel fileModel, Context context){
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(fileModel.getFilename(), Context.MODE_PRIVATE));
            outputStreamWriter.write(fileModel.getData());
            outputStreamWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "writeToFile: ", e );
        }
    }

    static FileModel readFromFile(Context context, String fileName){
        FileModel fileModel = new FileModel();
        try {
            InputStream inputStream = context.openFileInput(fileName);

            if (inputStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString;
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null){
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                fileModel.setData(stringBuilder.toString());
                fileModel.setFilename(fileName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileModel;
    }
}
