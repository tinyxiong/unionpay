package com.xuebang.platform.unionpay.shell.constants;

/**
 * author: xyb
 * Date: 2017/11/24 17:46
 * desc: 支付状态
 */
public enum PaidStatus {

    UNPAID("UNPAID", "未支付"),
    PAYING("PAYING", "支付中"),
    PAID("PAID", "已支付"),
    FAILED("FAILED", "支付失败")
    ;
    private String value;
    private String name;

    private PaidStatus(String value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getName() {//FIXME better to named: key, label ;
        return name;
    }

    public String getValue() {
        return value;
    }

    public static PaidStatus fromName(String name) {
        for (PaidStatus e : PaidStatus.values()) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }
}