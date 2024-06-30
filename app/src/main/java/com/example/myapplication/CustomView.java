package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {

    private int numLados = 2; // No mostrar ninguna figura al inicio
    private Paint paint;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(0xFFFFA500); // Color Naranja
        paint.setStyle(Paint.Style.FILL); // Rellenar la figura
        paint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (numLados < 3) return;  // No dibujar nada si no hay al menos un triángulo

        float centerX = getWidth() / 2;
        float centerY = getHeight() / 2;
        float radius = Math.min(centerX, centerY) - 50;

        float angleStep = 2 * (float) Math.PI / numLados;

        float[] points = new float[2 * numLados];
        for (int i = 0; i < numLados; i++) {
            points[2 * i] = centerX + radius * (float) Math.cos(i * angleStep);
            points[2 * i + 1] = centerY + radius * (float) Math.sin(i * angleStep);
        }

        Path path = new Path();
        path.moveTo(points[0], points[1]);
        for (int i = 1; i < numLados; i++) {
            path.lineTo(points[2 * i], points[2 * i + 1]);
        }
        path.close();

        canvas.drawPath(path, paint);
    }

    public void incrementarLados() {
        numLados++;
        invalidate();
    }

    public void reiniciarLados() {
        numLados = 2;  // Reiniciar a sin figura
        invalidate();
    }
}
