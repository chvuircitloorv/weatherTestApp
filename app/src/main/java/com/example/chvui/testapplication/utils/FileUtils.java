package com.example.chvui.testapplication.utils;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by chvui on 06.12.2017.
 */

public final class FileUtils {

    public static final String CITIES_FILE_NAME = "data.json";

    public static final String KEY_FILE_NAME = "key.txt";

    public static String getAssetsFileData(AssetManager assetManager, String fileName) throws IOException {

        InputStream inputStream = assetManager.open(fileName);

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder out = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            out.append(line);
        }
        br.close();

        return out.toString();
    }
}
