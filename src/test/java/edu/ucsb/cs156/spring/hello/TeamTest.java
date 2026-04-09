package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_non_team_object() {
        assertFalse(team.equals("not a team"));
    }

    @Test
    public void equals_returns_true_for_equal_teams() {
        Team other = new Team("test-team");
        assertTrue(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_name() {
        Team other = new Team("other-team");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team other = new Team("test-team");
        other.addMember("Alice");
        assertFalse(team.equals(other));
    }

    @Test
    public void hashCode_returns_same_for_equal_teams() {
        Team t1 = new Team("foo");
        t1.addMember("bar");
        Team t2 = new Team("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_returns_expected_value() {
        // new Team() has name="" (hashCode 0) and members=[] (hashCode 1)
        // 0 | 1 = 1, while 0 & 1 = 0, so this distinguishes | from &
        Team t = new Team();
        assertEquals(1, t.hashCode());
    }

}
