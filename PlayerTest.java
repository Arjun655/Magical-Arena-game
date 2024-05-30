public class PlayerTest {
    @Test
    public void testPlayerHealthReduction() {
        Player player = new Player(50, 5, 10);
        player.reduceHealth(30);
        assertEquals(20, player.getHealth());
    }

    private void assertEquals(int i, int health) {
      
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    @Test
    public void testPlayerIsAlive() {
        Player player = new Player(50, 5, 10);
        assertTrue(player.isAlive());
        player.reduceHealth(50);
        assertTrue(player.isAlive());
    }

    private void assertTrue(boolean alive) {
        
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }
}
