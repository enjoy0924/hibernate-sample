package com.allere.hibernate.paper;

/**
 * 常量定义
 *
 * Created by G_dragon on 2015/8/4.
 */
public class CONST {

    //作业发布类型
    public static final int TEST_TYPE_SEATWORK  = 1;       //课堂练习
    public static final int TEST_TYPE_HOMEWORK  = 2;       //家庭作业
    public static final int TEST_TYPE_EXAM      = 3;       //考试

    //学生作业状态
    public static final int STUDENT_WORK_STATUS_NOTSTARTED = 1; //作业还没开始
    public static final int STUDENT_WORK_STATUS_INPROGRESS = 2; //作业部分完成，未提交的问题可以修改
    public static final int STUDENT_WORK_STATUS_COMPLETED  = 3; //作业所有问题已提交，不能进行修改
    public static final int STUDENT_WORK_STATUS_GRADINGCOMPLETED  = 4; //作业所有问题已批改

    //题目状态
    public static final int QUESTION_STATUS_SUBMITTED  = 1;  //已提交，不能进行修改
    public static final int QUESTION_STATUS_INPROGRESS = 2;  //正在完成，可以修改
    public static final int QUESTION_STATUS_GRADED     = 3;  //批改完成

    //题目批改类型
    public static final int QUESTION_AUTO_GRADING   = 1; //自动批改
    public static final int QUESTION_MANUAL_GRADING = 2; //手动批改

    //评价方式
    public static final int APPRAISE_TYPE_COMMENT    = 1; //评语
    public static final int APPRAISE_TYPE_GOLDMEDAL  = 2; //金牌
    public static final int APPRAISE_TYPE_VOICE      = 3; //声音
    public static final int APPRAISE_TYPE_LIKE       = 4; //点赞

    //得分规则
//    public static final int SCORE_RULE_EXCLUSIVE = 1;  //答案互斥，所有得分点的答案是一个集合，集合中的元素互斥
//    public static final int SCORE_RULE_SEQUENCE  = 2;  //得分点之间答案有顺序，使用的时候顺序有个作用范围 [0 1 2] 3 4 [5 6]
//    public static final int SCORE_RULE_FULL      = 3;  //

}
