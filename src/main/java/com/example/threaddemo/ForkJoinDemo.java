package com.example.threaddemo;

import org.springframework.cglib.core.TinyBitSet;

import java.util.concurrent.RecursiveTask;

/**
 * @author xin.z
 * @date 2020/11/21 2:56 下午
 */
public class ForkJoinDemo {

    class CountTask extends RecursiveTask<Integer> {

        private static final int THREDHOLD = 2;
        private int start;
        private int end;

        public CountTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            boolean flag = (end - start) <= THREDHOLD;
            if (flag) {
                for (int i = start; i <= end; i++)
                    sum += i;
            }else {
                //
                int middle = (start+end)/2;
                CountTask countTask = new CountTask(start, middle);
                CountTask countTask1 = new CountTask(middle+1, end);

            }


            return null;
        }
    }
}
