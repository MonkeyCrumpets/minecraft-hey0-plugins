import java.util.logging.Logger;
import java.util.List;

//@author MonkeyCrumpets

public class PlayerlistOnLogin extends Plugin  {
	private Listener l = new Listener(this);
	protected static final Logger log = Logger.getLogger("Minecraft");
	private String name = "PlayerlistOnLogin";
	private String version = "1.0";
	
		public void enable() {
	}
	
	public void disable() {
	}

	public void initialize() {
		log.info(name + " " + version + " initialized");
		etc.getLoader().addListener( PluginLoader.Hook.LOGIN, l, this, PluginListener.Priority.MEDIUM);
		etc.getLoader().addListener( PluginLoader.Hook.COMMAND, l, this, PluginListener.Priority.MEDIUM);
	}
	
	public class Listener extends PluginListener {
		PlayerlistOnLogin p;
		public Listener(PlayerlistOnLogin plugin) {
			p = plugin;
		}
		
		public void onLogin(Player player) {
            List<Player> listofplayers = etc.getServer().getPlayerList();
                String playernames = "Connected players: ";
                for (Player player2 : listofplayers) {
                    if(playernames == "Connected players: ") {
                        playernames = playernames+ player2.getColor() + player2.getName() ;
                    } 
					else {
						playernames = playernames+ ", " + player2.getColor() + player2.getName() ;
                    }
                }
                player.sendMessage(playernames);
        }
		public boolean onCommand (Player player, String[] split) {
            if (split[0].equalsIgnoreCase("/whom")) {
				List<Player> listofplayers = etc.getServer().getPlayerList();
					String playernames = "Connected players: ";
					for (Player player2 : listofplayers) {
						if(playernames == "Connected players: ") {
						playernames = playernames+ player2.getColor() + player2.getName() ;
						} 
						else {
							playernames = playernames+ ", " + player2.getColor() + player2.getName() ;
						}
					}
                player.sendMessage(playernames);
				
				return true;
			}
			return false;
		}
	}
}
