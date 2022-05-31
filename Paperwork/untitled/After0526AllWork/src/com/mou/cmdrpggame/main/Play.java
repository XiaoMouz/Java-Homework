package com.mou.cmdrpggame.main;

import com.mou.cmdrpggame.match.Team;
import com.mou.cmdrpggame.user.roles.Master;
import com.mou.cmdrpggame.user.roles.Soldier;

public class Play {
    public static void main(String[] args) {
        Master luogan = new Master("罗刚",4);
        Master A1 = new Master("A1",5);
        Soldier S1 = new Soldier("S1"); S1.setAge(20);
        Soldier L4 = new Soldier("L4");

        Team teamA = new Team("队伍A",luogan);
        teamA.addMember(A1);
        teamA.addMember(S1);
        teamA.addMember(L4);
        System.out.println(teamA.addMember(S1));
        System.out.println(teamA.addMember(L4));
        System.out.println(teamA.addMember(A1));

        luogan.printInfo();
        S1.printInfo();

        teamA.printTeamInfo();

    }
}
