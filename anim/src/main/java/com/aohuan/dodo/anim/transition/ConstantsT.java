package com.aohuan.dodo.anim.transition;

/**
 * Created by dodo_lihao on 2016/12/20.
 * qq: 2390183798
 */
public class ConstantsT {

//    public static final int ANIM_TYPE_STRAIGHT = 0;
//    public static final int ANIM_TYPE_CIRCULAR_REVEAL = 0;
//    public static final int ANIM_TYPE_RECT_REVEAL = 0;

    public enum AnimType{
        ANIM_TYPE_STRAIGHT, ANIM_TYPE_CIRCULAR_REVEAL, ANIM_TYPE_RECT_REVEAL
    }

    public static AnimType ANIM_TYPE = AnimType.ANIM_TYPE_STRAIGHT;

    public static void setAnimType(AnimType animType){
        ANIM_TYPE = animType;
    }

    public static AnimType getAnimType(){
        return ANIM_TYPE;
    }

}
