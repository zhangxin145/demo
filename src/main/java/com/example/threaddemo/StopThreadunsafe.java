package com.example.threaddemo;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xin.z
 * @date 2020/11/19 9:40 下午
 */
public class StopThreadunsafe {
    private static final User lock = new User();

   public static class User{
        private Integer id;
        private String userName;
        public User(){
           id=0;
           userName="0";
        }

       public String getUserName() {
           return userName;
       }

       public void setUserName(String userName) {
           this.userName = userName;
       }

       public Integer getId() {
           return id;
       }

       public void setId(Integer id) {
           this.id = id;
       }

   }

       public static void main(String[] args) throws InterruptedException {



           CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
           strings.add("a");
           //read
           new Thread(()->{
               while (true){
                   synchronized (lock){
                       if(lock.id!=Integer.parseInt(lock.getUserName())){
                           System.out.println("------>"+lock.getId()+"==="+lock.getUserName());
                       }
                   }
                   Thread.yield();
               }


           }).start();

           //write
           while (true){
               new Thread(()->{
                   while (true){
                       synchronized (lock){
                           int id =(int)(System.currentTimeMillis()/1000);
                           lock.setId(id);
                           try {
                               Thread.sleep(1000);
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                           lock.setUserName(String.valueOf(id));
                       }
                       Thread.yield();
                   }
               }).start();
               Thread.sleep(100);


           }

       }





}
