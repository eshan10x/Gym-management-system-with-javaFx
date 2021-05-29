package sample;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyGymManagerTest extends MyGymManager {

    @Test (expected = IllegalArgumentException.class)
    public void testAddDefaultMem() {
    }

    @Test
    public void testAddStudentMem() {
    }

    @Test
    public void testAddOver60() {
    }

    @Test
    public void testDeleteDefaultMem() {
        deleteDefaultMem("5487");
        assertEquals("Member successfully deleted","Member successfully deleted");
    }
}