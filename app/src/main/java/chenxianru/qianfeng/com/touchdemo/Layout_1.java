package chenxianru.qianfeng.com.touchdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by aaa on 15-4-21.
 * 只有父控件打断子控件的处理，自己是不能打断自己的时间处理的。
 *
 */
public class Layout_1 extends FrameLayout {
    private static final String TAG="-------->Layout_1";
    private float x;
    private float y;

    public Layout_1(Context context) {
        super(context);
    }

    public Layout_1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout_1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 触摸事件分发，
     * @param ev
     * TODO @return 是否完成事件分发，返回值不能改动，除非自定义分发规则！！
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG,"dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    /**
     * 打断触摸事件
     * @param ev
     * @return 是否终止本次事件的分发，由本控件去处理触摸事件
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG,"onInterceptTouchEvent");
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = ev.getX();
                y = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(ev.getY()-y)>10){
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onInterceptTouchEvent(ev);

    }

    /**
     * 触摸事件的处理
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG,"onTouchEvent");

        return super.onTouchEvent(event);
    }
}
