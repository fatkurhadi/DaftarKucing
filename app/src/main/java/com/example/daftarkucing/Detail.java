package com.example.daftarkucing;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class Detail extends AppCompatActivity {
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_REMARKS = "extra_remarks";
    public static final String EXTRA_DETAIL = "extra_detail";

    CircleImageView imgReceived;
    TextView nameReceived;
    TextView remarksReceived;
    TextView detailReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgReceived = findViewById(R.id.img_received);
        nameReceived = findViewById(R.id.name_received);
        remarksReceived = findViewById(R.id.remarks_received);
        detailReceived = findViewById(R.id.detail_received);

        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String remarks = getIntent().getStringExtra(EXTRA_REMARKS);
        String detail = getIntent().getStringExtra(EXTRA_DETAIL);

        Glide.with(imgReceived)
                .load(photo)
                .apply(new RequestOptions().override(150,150))
                .into(imgReceived);
        nameReceived.setText(name);
        remarksReceived.setText(remarks);
        detailReceived.setText(detail);
    }
}
