package com.example.cryptit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Image_Gallery extends AppCompatActivity {

        /** The images. */
        List<String> images;
        RecyclerView recyclerView;
        MyAdapter myAdapter;
        TextView textView;

        private static final int mrpc=101;


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_image__gallery);

            textView=findViewById(R.id.txt);
            recyclerView=findViewById(R.id.recycler);


            if (ContextCompat.checkSelfPermission(Image_Gallery.this , Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(Image_Gallery.this , new String[] {
                        Manifest.permission.READ_EXTERNAL_STORAGE}, mrpc);
            }

            else
            {
                loadImages();
            }
        }

        private void loadImages() {
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(this,4));
            images = ImageGallery.loi(this);
            myAdapter = new MyAdapter(this, images, new MyAdapter.PhotoListener() {
                @Override
                public void onPhotoClick(String path) {

                    Toast.makeText(Image_Gallery.this,"AAA", Toast.LENGTH_SHORT).show();


                }
            });
            recyclerView.setAdapter(myAdapter);
            textView.setText("Photos("+images.size()+")");
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);

            if (requestCode == mrpc) {
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"RE", Toast.LENGTH_SHORT).show();
                    loadImages();

                }
                else{
                    Toast.makeText(this,"NRE", Toast.LENGTH_SHORT).show();
                }

            }
        }


    }

