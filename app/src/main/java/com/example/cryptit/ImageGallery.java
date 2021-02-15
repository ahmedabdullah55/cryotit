package com.example.cryptit;


import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

public class ImageGallery {
    public static ArrayList<String> loi(Context context) {
        Uri uri;
        Cursor cursor;
        int cid, cif;
        ArrayList<String> loi = new ArrayList<>();
        String apath;
        uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = new String[]{MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME};
        String orderBy=MediaStore.Video.Media.DATE_TAKEN;

        cursor = context.getContentResolver().query(uri, projection, null, null, null);

        cid = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);


        // cif=cursor.getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);

        while (cursor.moveToNext()){
            apath = cursor.getString(cid);
            loi.add(apath);
        }
        return loi;
    }
}

