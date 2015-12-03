package util;

public class Constant {

    //Role TYPE
    public static final int ROLE_TYPE_CIVVY    = 1;
    public static final int ROLE_TYPE_SOLDIER = 2;

    //ROLE
    public static final String ROLE_CIVVY = "普通人";
    public static final String ROLE_SOLDIER = "战士";

    //WEPON
    public static final String WEAPON_STICKS = "优质木棍";
    public static final String WEAPON_HAMMER = "锤";
    public static final String WEAPON_SWORD  = "剑";


    //ARMOR
    public static final String ARMOR_DUN      = "盾";
    public static final String ARMOR_GOLDSOFT = "金丝软甲";


    //FEATURE TYPE
    public static final String FEATURE_TYPE_DEFAULT      = "";
    public static final String FEATURE_TYPE_POISON       = "毒性伤害";
    public static final String FEATURE_TYPE_FIRE         = "火焰伤害";
    public static final String FEATURE_TYPE_ICE          = "冰冻伤害";
    public static final String FEATURE_TYPE_DIZZY        = "眩晕伤害";
    public static final String FEATURE_TYPE_ALL_EFFORT   = "全力一击";


    //FEATURE
    public static final String FEATURE_POISON      = "毒";
    public static final String FEATURE_FIRE        = "火";
    public static final String FEATURE_ICE         = "冰雪";
    public static final String FEATURE_DIZZY       = "晕";
    public static final String FEATURE_ALL_EFFORT  = "";

    //FEATURE DAMAGE POINT
    public static final int FEATURE_DAMAGE_POISON               = 2;
    public static final int FEATURE_DAMAGE_FIRE                 = 3;
    public static final int FEATURE_DAMAGE_CAN_NOT_ATTACK_TWICE = 2;
    public static final int FEATURE_DAMAGE_CAN_NOT_ATTACK_ONCE  = 1;

    //FEATURE DAMAGE TIMES
    public static final int FEATURE_DAMAGE_TIMES_POISON      = 2;
    public static final int FEATURE_DAMAGE_TIMES_FIRE        = 3;
    public static final int FEATURE_DAMAGE_TIMES_ICE         = 4;
    public static final int FEATURE_DAMAGE_TIMES_DIZZY       = 5;
    public static final int FEATURE_DAMAGE_TIMES_ALL_EFFORT  = 1;
    public static final int FEATURE_DAMAGE_TIMES_DEFAULT     = 0;

    //DAMAGE TYPE
    public static final int DAMAGE_TYPE_NO_DAMAGE                  = 0;
    public static final int DAMAGE_TYPE_LOSE_BLEED                 = 1;
    public static final int DAMAGE_TYPE_TWICE_CAN_NOT_ATTACK_ONCE  = 2;
    public static final int DAMAGE_TYPE_CAN_NOT_ATTACK_TWICE       = 3;
    public static final int DAMAGE_TYPE_TRIPLE_DAMAGE              = 4;


    //ATTACK STATE
    public static final boolean ATTACK_STATE_ON  = true;
    public static final boolean ATTACK_STATE_OFF = false;


    //RANDOM MAX
    public static final int  RANDOM_MAX = 10;

}
