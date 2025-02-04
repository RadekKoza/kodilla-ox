import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StatusCheckerTestSuite {

    private StatusChecker statusChecker = new StatusChecker();

    @Test
    void oWinHorizontally() {
        //given
        char[][] oHorizontally = new char[][] {
                {' ', 'x', 'x', 'o'},
                {'o', 'o', 'o', 'o'},
                {'x', 'o', 'x', ' '},
                {'x', 'o', 'x', ' '}
        };
        //when
        statusChecker.check(oHorizontally);
        //then
        assertTrue(statusChecker.check(oHorizontally));
        assertEquals("o", statusChecker.getTheWinner());
    }

    @Test
    void oWinVertically() {
        //given
        char[][] oVertically = new char[][] {
                {' ', 'o', 'x', 'o'},
                {'x', 'o', 'o', 'o'},
                {'x', 'o', 'x', ' '},
                {'x', 'o', 'x', ' '}
        };
        //when
        statusChecker.check(oVertically);
        //then
        assertTrue(statusChecker.check(oVertically));
        assertEquals("o", statusChecker.getTheWinner());
    }

    @Test
    void oWinDiagonally() {
        //given
        char[][] oDiagonally = new char[][] {
                {' ', 'o', 'x', 'o'},
                {'x', 'o', 'o', 'o'},
                {'x', 'o', 'x', 'x'},
                {'o', 'o', 'x', ' '}
        };
        //when
        statusChecker.check(oDiagonally);
        //then
        assertTrue(statusChecker.check(oDiagonally));
        assertEquals("o", statusChecker.getTheWinner());
    }

    @Test
    void xWinHorizontally() {
        //given
        char[][] xHorizontally = new char[][] {
                {'o', 'o', ' ', 'o'},
                {'x', 'o', 'o', 'o'},
                {'x', 'x', 'x', 'x'},
                {'x', ' ', 'x', 'o'}
        };
        //when
        statusChecker.check(xHorizontally);
        //then
        assertTrue(statusChecker.check(xHorizontally));
        assertEquals("x", statusChecker.getTheWinner());
    }

    @Test
    void xWinVertically() {
        //given
        char[][] xVertically = new char[][] {
                {'x', 'o', ' ', 'o'},
                {'x', 'o', 'o', 'o'},
                {'x', 'x', 'o', 'x'},
                {'x', ' ', 'x', 'o'}
        };
        //when
        statusChecker.check(xVertically);
        //then
        assertTrue(statusChecker.check(xVertically));
        assertEquals("x", statusChecker.getTheWinner());
    }

    @Test
    void xWinDiagonally() {
        //given
        char[][] xDiagonally = new char[][] {
                {'x', 'o', ' ', 'o'},
                {'o', 'x', 'o', 'o'},
                {'o', 'x', 'x', 'x'},
                {'o', ' ', 'x', 'x'}
        };
        //when
        statusChecker.check(xDiagonally);
        //then
        assertTrue(statusChecker.check(xDiagonally));
        assertEquals("x", statusChecker.getTheWinner());
    }

    @Test
    void oxDraw() {
        //given
        char[][] oxDrawTable = new char[][] {
                {'x', 'o', 'x', 'o'},
                {'o', 'x', 'o', 'o'},
                {'o', 'x', 'x', 'x'},
                {'o', 'o', 'x', 'o'}
        };
        //when
        statusChecker.check(oxDrawTable);
        //then
        assertTrue(statusChecker.check(oxDrawTable));
        assertEquals("no winner", statusChecker.getTheWinner());
    }

}