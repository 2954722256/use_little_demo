package com.aohuan.dodo.dispatchevent_about.dispatch_group.tools;

import android.util.Log;
import android.view.MotionEvent;

public class TouchEventUtil {

    public static void logActionMsg(Class cls, String functionName, MotionEvent ev) {
        logActionMsg(cls, functionName, ev, "noMsg");
    }

    enum LogType {
        Down, Up, Move, All
    }

    static LogType mLogType = LogType.All;


    public static void logActionMsg(Class cls, String functionName, MotionEvent ev, String msg) {
        if(ev == null){
            doPrint(cls, functionName,ev, msg);
            return;
        }
        switch (mLogType) {
            case Down:
                if (ev.getAction() == MotionEvent.ACTION_DOWN)
                    doPrint(cls, functionName, ev, msg);
                break;
            case Up:
                if (ev.getAction() == MotionEvent.ACTION_UP)
                    doPrint(cls, functionName, ev, msg);
                break;
            case Move:
                if (ev.getAction() == MotionEvent.ACTION_MOVE)
                    doPrint(cls, functionName, ev, msg);
                break;
            case All:
                doPrint(cls, functionName, ev, msg);
                break;
            default:
                break;
        }
    }

    private static void doPrint(Class cls, String functionName, MotionEvent ev, String msg) {
        String eventStr = "nullEvent";
        if(ev!=null){
            eventStr = getTouchAction(ev.getAction());
        }
        Log.e("touch", cls.getSimpleName() + "\t----\t" + functionName + "\t---->\t" + eventStr + "\t---->\t" + msg);
    }

    private static String getTouchAction(int actionId) {
        String actionName = "Unknow:id=" + actionId;
        switch (actionId) {
            case MotionEvent.ACTION_DOWN:
                actionName = "ACTION_DOWN";
                break;
            case MotionEvent.ACTION_MOVE:
                actionName = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                actionName = "ACTION_UP";
                break;
            case MotionEvent.ACTION_CANCEL:
                actionName = "ACTION_CANCEL";
                break;
            case MotionEvent.ACTION_OUTSIDE:
                actionName = "ACTION_OUTSIDE";
                break;
        }
        return actionName;
    }

    public static void doClick(Class cls){
        Log.e("【click】", cls.getSimpleName() + " is  clicked!!");
    }


}
