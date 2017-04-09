package kanaami12.plugin.whitelistbutton;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements TabCompleter{
	
	public static Main plugin;
	public static String prefix = ChatColor.GRAY + "[WhitelistButton]";
	
	@Override
	public void onEnable(){
		
		plugin = this;
		
		getCommand("whitelistbutton").setExecutor(new MyCommandExecutor(this));
		getCommand("whitelistbutton").setTabCompleter(new ConstructTabCompleter());
		getServer().getPluginManager().registerEvents(new MyListener(), this);
		this.saveDefaultConfig();
	}
}
