package com.allere.hibernate.paper;

/**
 * ��������
 *
 * Created by G_dragon on 2015/8/4.
 */
public class CONST {

    //��ҵ��������
    public static final int TEST_TYPE_SEATWORK  = 1;       //������ϰ
    public static final int TEST_TYPE_HOMEWORK  = 2;       //��ͥ��ҵ
    public static final int TEST_TYPE_EXAM      = 3;       //����

    //ѧ����ҵ״̬
    public static final int STUDENT_WORK_STATUS_NOTSTARTED = 1; //��ҵ��û��ʼ
    public static final int STUDENT_WORK_STATUS_INPROGRESS = 2; //��ҵ������ɣ�δ�ύ����������޸�
    public static final int STUDENT_WORK_STATUS_COMPLETED  = 3; //��ҵ�����������ύ�����ܽ����޸�
    public static final int STUDENT_WORK_STATUS_GRADINGCOMPLETED  = 4; //��ҵ��������������

    //��Ŀ״̬
    public static final int QUESTION_STATUS_SUBMITTED  = 1;  //���ύ�����ܽ����޸�
    public static final int QUESTION_STATUS_INPROGRESS = 2;  //������ɣ������޸�
    public static final int QUESTION_STATUS_GRADED     = 3;  //�������

    //��Ŀ��������
    public static final int QUESTION_AUTO_GRADING   = 1; //�Զ�����
    public static final int QUESTION_MANUAL_GRADING = 2; //�ֶ�����

    //���۷�ʽ
    public static final int APPRAISE_TYPE_COMMENT    = 1; //����
    public static final int APPRAISE_TYPE_GOLDMEDAL  = 2; //����
    public static final int APPRAISE_TYPE_VOICE      = 3; //����
    public static final int APPRAISE_TYPE_LIKE       = 4; //����

    //�÷ֹ���
//    public static final int SCORE_RULE_EXCLUSIVE = 1;  //�𰸻��⣬���е÷ֵ�Ĵ���һ�����ϣ������е�Ԫ�ػ���
//    public static final int SCORE_RULE_SEQUENCE  = 2;  //�÷ֵ�֮�����˳��ʹ�õ�ʱ��˳���и����÷�Χ [0 1 2] 3 4 [5 6]
//    public static final int SCORE_RULE_FULL      = 3;  //

}
