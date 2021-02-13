package com.example.cryptit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class Image_Gallery extends AppCompatActivity {

    RecyclerView recyclerView;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image__gallery);

        String ExternalStorageDirectoryPath = Environment
                .getExternalStorageDirectory()
                .getAbsolutePath();
        String targetPath = ExternalStorageDirectoryPath + "/DCIM/Camera";
        ArrayList<String> images = new ArrayList<String>();
        File targetDirector = new File(targetPath);

        File[] files = targetDirector.listFiles();
        for (File file : files) {

            images.add(file.getAbsolutePath());
        }
//        gallerylist =new CameraGalleryAdapter(getActivity().getApplicationContext(),R.layout.giphy_grid,images);
//        gridview.setAdapter(gallerylist);

//        if(ContextCompat.checkSelfPermission(Image_Gallery.this,
//                Manifest.permission.READ_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED)
//            ActivityCompat.requestPermissions(Image_Gallery.this,
//                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
//
//        recyclerView = findViewById(R.id.gallery);

//        recyclerView.addItemDecoration(new MarginDecoration(this));
//        recyclerView.hasFixedSize();
//        ArrayList<imageFolder> folds = getPicturePaths();
//
//        if(folds.isEmpty()){
//            empty.setVisibility(View.VISIBLE);
//        }else{
//            RecyclerView.Adapter folderAdapter = new pictureFolderAdapter(folds,MainActivity.this,this);
//            folderRecycler.setAdapter(folderAdapter);
//        }

    }
}
