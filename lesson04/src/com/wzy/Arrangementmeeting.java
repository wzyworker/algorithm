package com.wzy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wzy
 * @date 2023年02月14日 23:25
 */
public class Arrangementmeeting {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange1(Program[] programs){
        if (programs == null || programs.length == 0){
            return 0;
        }
        return process(programs, 0, 0);
    }

    /**
     * 目前来到 timeLine 的时间点，已经安排了 done 数量的会议，剩下的会议 programs 可以自由安排
     * @param programs 还剩什么会议
     * @param done 之前已经安排好会议的数量
     * @param timeLine 目前来到的时间点
     * @return 能安排最多会议的数量
     */
    public static int process(Program[] programs, int done, int timeLine){
        if (programs.length == 0){
            return done;
        }
        // programs 中还有会议
        int max = done;
        //
        for (int i = 0; i < programs.length; i++) {
            // 当前会议可以安排
            if (programs[i].start >= timeLine){
                Program[] next = copyButExcept(programs, i);
                max = Math.max(max, process(next, done + 1, programs[i].end));
            }
        }
        return max;
    }

    public static Program[] copyButExcept(Program[] programs, int i){
        Program[] ans = new Program[programs.length - 1];
        int index = 0;
        for (int k = 0; k < programs.length; k++) {
            if (k != i){
                ans[index++] = programs[k];
            }
        }
        return ans;
    }

    public static int bestArrange2(Program[] programs){
        Arrays.sort(programs, new ProgramComparator());
        int timeLine = 0;
        int result = 0;
        for (Program program : programs) {
            if (timeLine <= program.start) {
                result++;
                timeLine = program.end;
            }
        }
        return result;
    }

    public static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }
}
