package com.example.futureDemo;

/**
 * @author xin.z
 * @date 2020/11/23 5:28 下午
 */
public class FutureDate implements Future {

    RealDate realDate = null;
    boolean isReady = false;

    public synchronized void setRealDate(RealDate realDate){
        if(isReady){
          return;
        }
        this.realDate =realDate;
        isReady = true;
        notifyAll();
    }


    @Override
    public String getResult() {
        while (!isReady){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realDate.getResult();
    }
}
