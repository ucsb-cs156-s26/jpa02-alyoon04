package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Alex Y.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("alyoon04", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s26-10", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_Alex() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Alex Y."), "Team should contain Alex Y.");
    }

    @Test
    public void getTeam_returns_team_with_Amit() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Amit K."), "Team should contain Amit K.");
    }

    @Test
    public void getTeam_returns_team_with_Kazu() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Kazu"), "Team should contain Kazu");
    }

    @Test
    public void getTeam_returns_team_with_Om() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Om K."), "Team should contain Om K.");
    }

    @Test
    public void getTeam_returns_team_with_Phill() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Phill C."), "Team should contain Phill C.");
    }

    @Test
    public void getTeam_returns_team_with_Srish() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Srish N."), "Team should contain Srish N.");
    }

    @Test
    public void getTeam_returns_team_with_Yuhang() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Yuhang J."), "Team should contain Yuhang J.");
    }

}
