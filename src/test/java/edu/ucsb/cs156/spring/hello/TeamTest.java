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
        assertEquals("test-team", team.getName());
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    // Test for equals: same object
    @Test
    public void testEquals_sameObject() {
        assertTrue(team.equals(team)); // Same object should return true
    }

    // Test for equals: different class
    @Test
    public void testEquals_differentClass() {
        String notATeam = "I am not a team";
        assertFalse(team.equals(notATeam)); // Different class should return false
    }

    // Test for equals: equal name and members
    @Test
    public void testEquals_equalNameAndMembers() {
        Team team2 = new Team("test-team");
        team2.addMember("Member1");
        team.addMember("Member1");
        assertTrue(team.equals(team2)); // Both name and members are the same
    }

    // Test for equals: same name, different members
    @Test
    public void testEquals_sameNameDifferentMembers() {
        Team team2 = new Team("test-team");
        team2.addMember("Member2");
        team.addMember("Member1");
        assertFalse(team.equals(team2)); // Same name, different members
    }

    // Test for equals: different name, same members
    @Test
    public void testEquals_differentNameSameMembers() {
        Team team2 = new Team("other-team");
        team2.addMember("Member1");
        team.addMember("Member1");
        assertFalse(team.equals(team2)); // Different name, same members
    }

    // Test for equals: different name, different members
    @Test
    public void testEquals_differentNameAndMembers() {
        Team team2 = new Team("other-team");
        team2.addMember("Member2");
        team.addMember("Member1");
        assertFalse(team.equals(team2)); // Different name and members
    }

    // Test for hashCode: equal objects should return the same hashCode
    @Test
    public void testHashCode_equalObjectsSameHashCode() {
        Team team1 = new Team("Team A");
        team1.addMember("Member1");

        Team team2 = new Team("Team A");
        team2.addMember("Member1");

        assertEquals(team1.hashCode(), team2.hashCode()); // Same content, same hash code
    }

    // Test for hashCode: different objects should return different hashCode
    @Test
    public void testHashCode_differentObjectsDifferentHashCode() {
        Team team1 = new Team("Team A");
        team1.addMember("Member1");

        Team team2 = new Team("Team B");
        team2.addMember("Member2");

        assertFalse(team1.hashCode() == team2.hashCode()); // Different content, different hash code
    }
}
