package com.sequoia.mvpdemo.bean;

import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/23.
 * @funtion
 */
public class Data {
    public int count;
    public int start;
    public int total;
    public List<Subjects> subjects;

    public static class Subjects {
        public List<String> genres;
        public String title;
        public List<Casts> casts;

        public static class Casts {
            public String alt;
            public Avatars avatars;
            public String name;
            public String id;

            public static class Avatars {
                public String small;
                public String large;
                public String medium;
            }
        }
    }


}
