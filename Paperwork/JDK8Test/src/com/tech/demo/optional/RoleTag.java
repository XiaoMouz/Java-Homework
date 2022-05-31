package com.tech.demo.optional;

public enum RoleTag {
    MASTER{
        @Override
        public String toString() {
            return "法师";
        }
    }
    ,SOLDIER{
        @Override
        public String toString() {
            return "战士";
        }
    }


}
