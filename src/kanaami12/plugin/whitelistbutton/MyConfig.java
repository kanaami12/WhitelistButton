package kanaami12.plugin.whitelistbutton;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class MyConfig extends Main{
	
	public static Main plugin = Main.plugin;
	public static ArrayList<Location> locations = new ArrayList<>();
	
	
	public static void loadConfig(){
		plugin.reloadConfig();
		locations = new ArrayList<>();
		locations = (ArrayList<Location>)plugin.getConfig().get("locations");
		if(locations == null){
			locations = new ArrayList<>();
		}
	}
	
	public static void addButton(Location loc, Player player){
		loadConfig();
		
		if(locations.contains(loc)){
			player.sendMessage(Main.prefix + ChatColor.RED + "既に追加されています");
			return;
		}
		
		locations.add(loc);
		plugin.getConfig().set("locations", null);
		plugin.getConfig().set("locations", locations);
		plugin.saveConfig();
		
		player.sendMessage(Main.prefix + ChatColor.GREEN + "ボタンを設定しました。");
	}
	
	public static void removeButton(Location loc, Player player){
		loadConfig();
		
		if(!locations.contains(loc)){
			player.sendMessage(Main.prefix + ChatColor.RED + "既に削除されています");
			return;
		}
		
		locations.remove(loc);
		plugin.getConfig().set("locations", null);
		plugin.getConfig().set("locations", locations);
		plugin.saveConfig();
		
		player.sendMessage(Main.prefix + ChatColor.GREEN + "ボタンを削除しました。");
	}
	
	public static void broadcast(String message){
		Bukkit.broadcastMessage(message);
	}
}
