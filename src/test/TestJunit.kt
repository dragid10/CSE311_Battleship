package test

import controller.Controller
import controller.ControllerImpl
import model.Coordinates
import model.Game
import model.Grid
import org.junit.jupiter.api.Test

class TestJunit {

    /**
     * Tests the win conditions for a row.
     * Three moves are made within the first row on the grid.
     * Player X is then given ownership to each cell in the row.
     * The tester then asserts if Player X has won.
     */
    @Test
    fun testRowWin() {

        val firstTestCoord = Coordinates(1, 1)
        val secondTestCoord = Coordinates(1, 2)
        val thirdTestCoord = Coordinates(1, 3)

        val testGrid = Grid()

        testGrid.setCellStatus(firstTestCoord, 1)
        testGrid.setCellStatus(secondTestCoord, 1)
        testGrid.setCellStatus(thirdTestCoord, 1)

        val testGame = Game(testGrid)

        assert(testGame.hasWon(1, thirdTestCoord))
    }

    /**
     * Tests the win conditions for a column.
     * Three moves are made within the first column on the grid.
     * Player X is then given ownership to each cell in the column.
     * The tester then asserts if Player X has won.
     */
    @Test
    fun testColWin() {

        val firstTestCoord = Coordinates(1, 1)
        val secondTestCoord = Coordinates(2, 1)
        val thirdTestCoord = Coordinates(3, 1)

        val testGrid = Grid()

        testGrid.setCellStatus(firstTestCoord, 1)
        testGrid.setCellStatus(secondTestCoord, 1)
        testGrid.setCellStatus(thirdTestCoord, 1)

        val testGame = Game(testGrid)

        assert(testGame.hasWon(1, thirdTestCoord))
    }

    /**
     * Tests the win conditions for a diagonal.
     * Three moves are made within the (1,1), (2,2), and (3,3) diagonal.
     * Player X is then given ownership to each cell in the row.
     * The tester then asserts if Player X has won.
     */
    @Test
    fun testDiagWin() {

        val firstTestCoord = Coordinates(1, 1)
        val secondTestCoord = Coordinates(2, 2)
        val thirdTestCoord = Coordinates(3, 3)

        val testGrid = Grid()

        testGrid.setCellStatus(firstTestCoord, 1)
        testGrid.setCellStatus(secondTestCoord, 1)
        testGrid.setCellStatus(thirdTestCoord, 1)

        val testGame = Game(testGrid)

        assert(testGame.hasWon(1, thirdTestCoord))
    }

    /**
     * Tests the win conditions for a row.
     * Three moves are made within the (1,3), (2,2), and (3,1) diagonal on the grid.
     * Player X is then given ownership to each cell in the row.
     * The tester then asserts if Player X has won.
     */
    @Test
    fun testRevDiagWin() {

        val firstTestCoord = Coordinates(1, 3)
        val secondTestCoord = Coordinates(2, 2)
        val thirdTestCoord = Coordinates(3, 1)

        val testGrid = Grid()

        testGrid.setCellStatus(firstTestCoord, 1)
        testGrid.setCellStatus(secondTestCoord, 1)
        testGrid.setCellStatus(thirdTestCoord, 1)

        val testGame = Game(testGrid)

        assert(testGame.hasWon(1, thirdTestCoord))
    }

    /**
     * Tests if hasWon() gives a false value if no player wins.
     */
    @Test
    fun testNoWin() {

        val firstTestCoord = Coordinates(1, 1)
        val secondTestCoord = Coordinates(3, 2)
        val thirdTestCoord = Coordinates(2, 3)

        val testGrid = Grid()

        testGrid.setCellStatus(firstTestCoord, 1)
        testGrid.setCellStatus(secondTestCoord, 1)
        testGrid.setCellStatus(thirdTestCoord, 1)

        val testGame = Game(testGrid)

        assert(!testGame.hasWon(1, thirdTestCoord))
    }

    /**
     * Sees if hasWon() returns false for a row check when two players occupy the same row.
     * For example: Row 1 contains X, O, and X.
     */
    @Test
    fun testOppositePlayerPlacement() {

        val firstTestCoord = Coordinates(1, 1)
        val secondTestCoord = Coordinates(1, 2)
        val thirdTestCoord = Coordinates(1, 3)

        val testGrid = Grid()

        testGrid.setCellStatus(firstTestCoord, 1)
        testGrid.setCellStatus(secondTestCoord, 2)
        testGrid.setCellStatus(thirdTestCoord, 1)

        val testGame = Game(testGrid)

        assert(!testGame.hasWon(1, thirdTestCoord))
    }

    /**
     * The same as testRowWin() only with Player O instead of Player X.
     */
    @Test
    fun testOWin() {

        val firstTestCoord = Coordinates(1, 1)
        val secondTestCoord = Coordinates(1, 2)
        val thirdTestCoord = Coordinates(1, 3)

        val testGrid = Grid()

        testGrid.setCellStatus(firstTestCoord, 2)
        testGrid.setCellStatus(secondTestCoord, 2)
        testGrid.setCellStatus(thirdTestCoord, 2)

        val testGame = Game(testGrid)

        assert(testGame.hasWon(2, thirdTestCoord))

    }

    /**
     * Changes the current player to 2 and then to 1 and asserts.
     */
    @Test
    fun setCurrPlayer() {

        val testGrid = Grid()
        val testGame = Game(testGrid)

        testGame.updatePlayer(2)
        assert(testGame.currPlayer == 2)

        testGame.updatePlayer(1)
        assert(testGame.currPlayer == 1)

    }
}

