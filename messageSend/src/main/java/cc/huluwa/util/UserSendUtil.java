package cc.huluwa.util;

import org.springframework.stereotype.Component;

@Component
public class UserSendUtil {

    private static final String before = "您的验证码是：";

    private static final String end = "，请在10分钟内完成验证，如非本人操作请忽略。";

    private static final String adminchkMsg = "用户您好，您提交的实名认证申请已通过，前往www.fangxinqian.cn查看详情。";

    private static final String adminchkUnPass = "用户您好，您提交的实名认证申请未通过，前往www.fangxinqian.cn查看详情。";

    private static final String countLess10 = "温馨提示：您的账户可用合同份数已低于10份，为避免影响您的正常使用，请您立即前往充值。地址：www.fangxinqian.cn";

    private static final String conbefore = "您本次签署合同的验证码是：";

    private static final String conend = "，如非本人操作请立即前往用户中心修改密码。";

    public static boolean SendMsg(String phone,Integer type,String code) {

        switch (type) {
            case 1:
                MessageSend.pastDue(phone,before+code+end);
                return  true;
            case 2:
                MessageSend.pastDue(phone,before+code+end);
                return true;
            case 3:
                MessageSend.pastDue(phone,adminchkMsg);
                return true;
            case 4:
                MessageSend.pastDue(phone,adminchkUnPass);
                return true;
            case 5:
                //System.out.println(code);
                MessageSend.pastDue(phone,conbefore+code+conend);
                return true;
            case 13:
                MessageSend.pastDue(phone,countLess10);
                break;
            default:
                return false;
        }
        return false;

    }
}
