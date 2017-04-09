package kanaami12.plugin.whitelistbutton;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyCommandExecutor implements CommandExecutor {
	
	private Main plugin;
	public static ArrayList<Player> adders = new ArrayList<>();
	public static ArrayList<Player> removers = new ArrayList<>();
	
	public MyCommandExecutor(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			if(args.length != 1){
				sender.sendMessage(Main.prefix +ChatColor.GRAY + "/whitelistbutton " + ChatColor.RED + "add\n" + 
						Main.prefix +ChatColor.GRAY + "/whitelistbutton " + ChatColor.RED + "remove");
				return true;
			}
			
	        Player player = (Player) sender;
	        if(args[0].equalsIgnoreCase("add")){
	        	adders.add(player);
	        	if(removers.contains(player)){
	        		removers.remove(player);
	        	}
	        	
	        	sender.sendMessage(Main.prefix + ChatColor.GREEN + "ボタンを右クリックしてください。");
	        }
	        else if(args[0].equalsIgnoreCase("remove")){
	        	removers.add(player);
	        	if(adders.contains(player)){
	        		adders.remove(player);
	        	}
	        	sender.sendMessage(Main.prefix + ChatColor.GREEN + "ボタンを右クリックしてください。");
	        }
	        else{
				sender.sendMessage(Main.prefix +ChatColor.GRAY + "/whitelistbutton " + ChatColor.RED + "add\n" + 
						Main.prefix +ChatColor.GRAY + "/whitelistbutton " + ChatColor.RED + "remove");
	        }
	        return true;
	    } else {
	        sender.sendMessage(Main.prefix + ChatColor.RED + "ゲーム内から実行してください。");
	        return true;
	    }
	}
}
