package com.example.myrecycler;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MyItemDecoration extends RecyclerView.ItemDecoration {
    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        // RecyclerView 사이즈
        int width = parent.getWidth();
        int height = parent.getHeight();

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        c.drawRect(0, 0, width, height, paint);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        // 항목의 index값 가져오기
        int index = parent.getChildAdapterPosition(view) + 1;
        if (index % 3 == 0)
            outRect.set(20, 20, 20, 50);
        else
            outRect.set(20, 20, 20, 20);

        view.setBackgroundColor(0xFFECE9E9);
        // 버전 : API 21부터
//        view.setElevation(20.0f);
        ViewCompat.setElevation(view,20.0f);
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        // RecyclerView 사이즈
        int width = parent.getWidth();
        int height = parent.getHeight();
        // 이미지 사이즈
        Drawable drawable = ResourcesCompat.getDrawable(parent.getResources(), R.drawable.android, null);
        int drWidth = drawable.getIntrinsicWidth();
        int drHeight = drawable.getIntrinsicHeight();

        // 화면의 중간 위치 계산
        int left = width / 2 - drWidth / 2;
        int top = height / 2 - drHeight / 2;

        // 캔버스에 이미지 보여주기
        c.drawBitmap(BitmapFactory.decodeResource(parent.getResources(), R.drawable.android), left, top, null);
    }
}