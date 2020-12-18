package com.example.futureDemo;

/**
 * @author xin.z
 * @date 2020/11/23 5:31 下午
 */
public class Client {
    public Future request(final String queryStr){
        FutureDate futureDate = new FutureDate();
        new Thread(()->{
            RealDate realDate = new RealDate(queryStr);
            futureDate.setRealDate(realDate);

        }).start();
        return  futureDate;
    }

    public static void main(String[] args) {
        Client client = new Client();
        Future data = client.request("name");
        System.out.println("请求完成");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("真实数据："+data.getResult());

    }
}
