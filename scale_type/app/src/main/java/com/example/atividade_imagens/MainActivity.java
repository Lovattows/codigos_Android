package com.example.atividade_imagens;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageOne, imageTwo, imageThree;
    Button btnPrevious, btnNext, btnCenter, btnCenter_Crop, btnCenter_Inside, btnFit_Center, btnFit_End, btnFit_Start, btnFit_XY, btnMatrix;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageOne = findViewById(R.id.imageOne);
        imageTwo = findViewById(R.id.imageTwo);
        imageThree = findViewById(R.id.imageThree);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        btnCenter = findViewById(R.id.btnCenter);
        btnCenter_Crop = findViewById(R.id.btnCenter_Crop);
        btnCenter_Inside = findViewById(R.id.btnCenter_Inside);
        btnFit_Center = findViewById(R.id.btnFit_Center);
        btnFit_End = findViewById(R.id.btnFit_End);
        btnFit_Start = findViewById(R.id.btnFit_Start);
        btnFit_XY = findViewById(R.id.btnFit_XY);
        btnMatrix = findViewById(R.id.btnMatrix);
        viewFlipper = findViewById(R.id.viewFlipper);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);
    }

    public void center(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setScaleType(ImageView.ScaleType.CENTER);
    }

    public void center_Crop(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void center_Inside(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }

    public void fit_Center(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public void fit_End(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setScaleType(ImageView.ScaleType.FIT_END);
    }

    public void fit_Start(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setScaleType(ImageView.ScaleType.FIT_START);
    }

    public void fit_XY(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public void matrix(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setScaleType(ImageView.ScaleType.MATRIX);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setImageAlpha00(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setImageAlpha(0);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setImageAlpha10(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setImageAlpha((int) 25.5);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setImageAlpha20(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setImageAlpha(51);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setImageAlpha30(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setImageAlpha((int) 76.5);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setImageAlpha40(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setImageAlpha(102);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setImageAlpha50(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setImageAlpha((int) 127.5);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setImageAlpha60(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setImageAlpha(153);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setImageAlpha70(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setImageAlpha((int) 178.5);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setImageAlpha80(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setImageAlpha(204);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setImageAlpha90(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setImageAlpha((int) 229.5);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setImageAlpha100(View view) {
        ImageView currentImage = (ImageView) viewFlipper.getCurrentView();
        currentImage.setImageAlpha(255);
    }

    @Override
    public void onClick(View v) {
        if (v == btnNext) {
            viewFlipper.showNext();
        } else if (v == btnPrevious) {
            viewFlipper.showPrevious();
        }
    }
}

