package com.example.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Custom View that draws a star rating bar using Canvas.
 * Demonstrates a Java-based custom View with custom XML attributes (R.styleable from this module)
 * and usage of the android_library rule.
 */
public class RatingBarView extends View {

    private static final int DEFAULT_MAX_STARS = 5;
    private static final int DEFAULT_STAR_COLOR = Color.parseColor("#FFC107");
    private static final float DEFAULT_RATING = 0f;

    private int maxStars;
    private int starColor;
    private float rating;
    private float starSpacing;

    private final Paint filledPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint emptyPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public RatingBarView(Context context) {
        super(context);
        init(context, null);
    }

    public RatingBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RatingBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        maxStars = DEFAULT_MAX_STARS;
        starColor = DEFAULT_STAR_COLOR;
        rating = DEFAULT_RATING;
        starSpacing = context.getResources().getDimension(R.dimen.star_spacing);

        if (attrs != null) {
            // Reading custom XML attributes — accesses R.styleable from this module's own resources
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RatingBarView);
            try {
                starColor = a.getColor(R.styleable.RatingBarView_starColor, DEFAULT_STAR_COLOR);
                maxStars = a.getInteger(R.styleable.RatingBarView_maxStars, DEFAULT_MAX_STARS);
                rating = a.getFloat(R.styleable.RatingBarView_rating, DEFAULT_RATING);
                starSpacing = a.getDimension(R.styleable.RatingBarView_starSpacing, starSpacing);
            } finally {
                a.recycle();
            }
        }

        filledPaint.setColor(starColor);
        filledPaint.setStyle(Paint.Style.FILL);

        emptyPaint.setColor(starColor);
        emptyPaint.setStyle(Paint.Style.STROKE);
        emptyPaint.setStrokeWidth(3f);
        emptyPaint.setAlpha(100);
    }

    public void setRating(float rating) {
        this.rating = Math.max(0, Math.min(rating, maxStars));
        invalidate();
    }

    public float getRating() {
        return rating;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        float starSize = getStarSize();
        int width = (int) (maxStars * starSize + (maxStars - 1) * starSpacing + getPaddingLeft() + getPaddingRight());
        int height = (int) (starSize + getPaddingTop() + getPaddingBottom());
        setMeasuredDimension(
            resolveSize(width, widthMeasureSpec),
            resolveSize(height, heightMeasureSpec)
        );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float starSize = getStarSize();
        float x = getPaddingLeft() + starSize / 2f;
        float y = getPaddingTop() + starSize / 2f;

        for (int i = 0; i < maxStars; i++) {
            boolean filled = i < (int) rating;
            drawStar(canvas, x, y, starSize / 2f, filled ? filledPaint : emptyPaint);
            x += starSize + starSpacing;
        }
    }

    private void drawStar(Canvas canvas, float cx, float cy, float radius, Paint paint) {
        Path path = new Path();
        float innerRadius = radius * 0.4f;
        int points = 5;
        double step = Math.PI / points;
        double start = -Math.PI / 2;

        path.moveTo(
            cx + (float) (radius * Math.cos(start)),
            cy + (float) (radius * Math.sin(start))
        );

        for (int i = 1; i <= points * 2; i++) {
            double r = (i % 2 == 0) ? radius : innerRadius;
            double angle = start + i * step;
            path.lineTo(
                cx + (float) (r * Math.cos(angle)),
                cy + (float) (r * Math.sin(angle))
            );
        }
        path.close();
        canvas.drawPath(path, paint);
    }

    private float getStarSize() {
        int height = getHeight();
        if (height <= 0) {
            return getResources().getDimensionPixelSize(android.R.dimen.app_icon_size);
        }
        return height - getPaddingTop() - getPaddingBottom();
    }
}
