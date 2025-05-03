package practica.mirror;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MirrorTest {

    @Test
    void mirrorEnds_Example1() {
        Mirror mirror = new Mirror();
        assertEquals("ab", mirror.mirrorEnds("abXYZba"));
    }

    @Test
    void mirrorEnds_Example2() {
        Mirror mirror = new Mirror();
        assertEquals("a", mirror.mirrorEnds("abca"));
    }

    @Test
    void mirrorEnds_Example3() {
        Mirror mirror = new Mirror();
        assertEquals("aba", mirror.mirrorEnds("aba"));
    }

    @Test
    void mirrorEnds_EmptyString() {
        Mirror mirror = new Mirror();
        assertEquals("", mirror.mirrorEnds(""));
    }

    @Test
    void mirrorEnds_SingleCharacter() {
        Mirror mirror = new Mirror();
        assertEquals("x", mirror.mirrorEnds("x"));
    }

    @Test
    void mirrorEnds_NoMirror() {
        Mirror mirror = new Mirror();
        assertEquals("", mirror.mirrorEnds("abcd"));
    }

    @Test
    void mirrorEnds_FullMirrorEvenLength() {
        Mirror mirror = new Mirror();
        assertEquals("abba", mirror.mirrorEnds("abba"));
    }

    @Test
    void mirrorEnds_FullMirrorOddLength() {
        Mirror mirror = new Mirror();
        assertEquals("abcba", mirror.mirrorEnds("abcba"));
    }
}