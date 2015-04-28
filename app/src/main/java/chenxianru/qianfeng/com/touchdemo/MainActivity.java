package chenxianru.qianfeng.com.touchdemo;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends ActionBarActivity implements View.OnTouchListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private RelativeLayout relativeLayout;
    private ImageView imageView;
    private float x;
    private float y;
    private GestureDetector detector;
    private static final String TAG = "------->GestureDetector";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_test);

        View view = findViewById(R.id.layout);
        imageView = (ImageView) findViewById(R.id.image);
        view.setOnTouchListener(this);
        detector = new GestureDetector(this, this);
        detector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

    /*    switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
               //TODO 本方法API 11 以后使用
               //  imageView.setTranslationX(event.getX()-x);
                ViewCompat.setTranslationX(imageView, event.getX() - x + ViewCompat.getTranslationX(imageView));
                ViewCompat.setTranslationY(imageView, event.getY() - y + ViewCompat.getTranslationY(imageView));

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        x = event.getX();
        y = event.getY();*/


        return detector.onTouchEvent(event);
    }
//TODO 手势监听

    /**
     * 按下事件！
     *
     * @param e
     * @return
     */
    @Override
    public boolean onDown(MotionEvent e) {
        Log.d(TAG, "onDown");
        return true;
    }

    /**
     * 短按事件！(在按下110毫秒触发)
     *
     * @param e
     */
    @Override
    public void onShowPress(MotionEvent e) {
        Log.d(TAG, "onShowPress");

    }

    /**
     * 等同于Click事件
     * 单击事件！！
     *
     * @param e
     * @return
     */
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.d(TAG, "onSingleTapUp");

        return false;
    }

    /**
     * 滚动事件监听！
     *
     * @param e1        开始的点
     * @param e2        结束的点
     * @param distanceX X轴上的位移
     * @param distanceY Y轴上的位移
     * @return
     */
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d(TAG, "onScroll" + distanceX + "\n" + distanceY);
        ViewCompat.setTranslationX(imageView, -distanceX + ViewCompat.getTranslationX(imageView));
        ViewCompat.setTranslationY(imageView, -distanceY + ViewCompat.getTranslationY(imageView));

        return false;
    }

    /**
     * 长按（在短按后500毫秒后触发），触发该方法后不会触发onSingleTapUp
     *
     * @param e
     */
    @Override
    public void onLongPress(MotionEvent e) {
        Log.d(TAG, "onLongPress");

    }

    /**z
     * 抛动事件监听
     *
     * @param e1        开始的点
     * @param e2        结束的点
     * @param velocityX X轴上的速度
     * @param velocityY Y轴上的速度
     * @return
     */
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d(TAG, "onFling" + velocityX + "\n" + velocityY);
        if (Math.abs(velocityX) > Math.abs(velocityY)) {
            ViewCompat.animate(imageView).translationXBy(velocityX / 10).setDuration(1000).start();
        } else {
            ViewCompat.animate(imageView).translationYBy(velocityY / 10).setDuration(1000).start();
        }
        return false;
    }

    //TODO 双击事件监听

    /**
     * 单击完成（在单击后，没有马上再次点击时触发）
     *
     * @param e
     * @return
     */
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Log.d(TAG, "onSingleTapConfirmed");
        return false;
    }

    /**
     * 双击按下（一次双击中只调用一次）
     *
     * @param e
     * @return
     */
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d(TAG, "onDoubleTap");
        return false;
    }

    /**
     * 双击事件（一次双击事件中会被调用两次）
     *
     * @param e
     * @return
     */
    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Log.d(TAG, "onDoubleTapEvent");
        return false;
    }
}
