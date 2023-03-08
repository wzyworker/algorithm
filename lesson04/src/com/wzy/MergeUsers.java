package com.wzy;

/**
 * @author wzy
 * @date 2023年02月19日 0:45
 */
public class MergeUsers {

    public static class User{
        public String id;
        public String biliId;
        public String gitId;

        public User(String id, String biliId, String gitId) {
            this.id = id;
            this.biliId = biliId;
            this.gitId = gitId;
        }
    }


    // 如果两个user有一个属性一致则认为是一个人
    public static int mergeUsers(User[] users) {

        return 100;
    }

}
