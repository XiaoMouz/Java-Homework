package com.mou.cmdrpggame.user.roles;

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
