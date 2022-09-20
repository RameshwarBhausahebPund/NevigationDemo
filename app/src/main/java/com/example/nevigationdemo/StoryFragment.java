package com.example.nevigationdemo;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;


public class StoryFragment extends Fragment {

    private static final int REQCODE = 100;
    private static final int REQCODE1 = 101;
    ImageView imgview ;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int h = calendar.get(Calendar.HOUR_OF_DAY);
        final int m = calendar.get(Calendar.MINUTE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story,container,false);
        imgview= view.findViewById(R.id.imgview);
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dailogbox);
                ImageView galImg = dialog.findViewById(R.id.galImg);
                galImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent,REQCODE);
                        dialog.hide();
                    }
                });
                ImageView camImg = dialog.findViewById(R.id.camImg);
                camImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent,REQCODE1);

                        dialog.hide();
                    }
                });
                dialog.show();
            }
        });
        // Inflate the layout for this fragment
return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQCODE){
            Uri uri = data.getData();
            imgview.setImageURI(uri);
        }
        if (requestCode == REQCODE1){
            Bitmap img = (Bitmap) (data.getExtras().get("data"));
            imgview.setImageBitmap(img);
        }
    }
}