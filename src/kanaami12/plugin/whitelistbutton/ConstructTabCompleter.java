package kanaami12.plugin.whitelistbutton;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class ConstructTabCompleter implements TabCompleter{
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		List<String> tab = new ArrayList<>();
		if (sender instanceof Player && args.length == 1) {
			tab.add("add");
			tab.add("remove");
			return tab;			//タブ補完
		}
		
		return tab;
	}
}
