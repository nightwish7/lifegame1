package lifegame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WorldTest {
	private static World world = new World();

	@BeforeEach
	void setUp() throws Exception {
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 50; j++) {
				world.set(i, j, 0);
			}
		}
	}

	@Test
	void testSet1() {
		world.set(1, 1, 1);
		assertEquals(1, world.currentGeneration[1][1]);
	}

	@Test
	void testSet2() {
		world.set(2, 2, 1);
		assertEquals(1, world.currentGeneration[2][2]);
	}

	@Test
	void testSet3() {
		world.set(3, 3, 1);
		assertEquals(1, world.currentGeneration[3][3]);
	}

	@Test
	void testEvolve1() {
		world.set(1, 2, 1);
		world.set(1, 0, 1);
		world.set(0, 1, 1);
		assertEquals(1, world.evolve(1, 1));
	}

	@Test
	void testEvolve2() {
		world.set(1, 2, 1);
		world.set(1, 0, 1);
		world.set(0, 1, 1);
		world.set(2, 1, 1);
		assertEquals(0, world.evolve(1, 1));
	}

	@Test
	void testEvolve3() {
		world.set(1, 2, 1);
		world.set(1, 0, 1);

		assertEquals(2, world.evolve(1, 1));
	}

	@Test
	void testIsValidCell1() {

		assertEquals(true, world.isValidCell(1, 1));
	}

	@Test
	void testIsValidCell2() {
		assertEquals(true, world.isValidCell(0, 1));
	}

	@Test
	void testIsValidCell3() {

		assertEquals(false, world.isValidCell(-1, -1));
	}
}
