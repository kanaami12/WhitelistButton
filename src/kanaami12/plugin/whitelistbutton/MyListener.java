package kanaami12.plugin.whitelistbutton;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MyListener implements Listener {
	
	private Main plugin = Main.plugin;
	public static boolean isAdded = false;
	
	@EventHandler(ignoreCancelled = true)
	public void onCick(PlayerInteractEvent event){
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			Block block = event.getClickedBlock();
			Material material = block.getType();
			if(material.equals(Material.WOOD_BUTTON) || material.equals(Material.STONE_BUTTON)){
				Player player = event.getPlayer();
				
				if(MyCommandExecutor.adders.contains(player)){
					MyConfig.addButton(block.getLocation(), player);
					MyCommandExecutor.adders.remove(player);
					return;
				}
				if(MyCommandExecutor.removers.contains(player)){
					MyConfig.removeButton(block.getLocation(), player);
					MyCommandExecutor.removers.remove(player);
					return;
				}
				
				MyConfig.loadConfig();
				if(MyConfig.locations != null && MyConfig.locations.contains(block.getLocation())){
					for(Player p : plugin.getServer().getOnlinePlayers()){
							p.setWhitelisted(true);
					}
					player.sendMessage(Main.prefix + ChatColor.GREEN + "ホワイトリストに追加しました。");	
				}
			}
		}
	}
}
