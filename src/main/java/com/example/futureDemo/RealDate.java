package com.example.futureDemo;

/**
 * @author xin.z
 * @date 2020/11/23 5:24 下午
 */
public class RealDate implements Future {

    private final String result;

    public RealDate(String p) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(p);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = sb.toString();

    }

    @Override
    public String getResult() {
        return result;
    }
}
