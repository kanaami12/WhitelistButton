package kanaami12.plugin.whitelistbutton;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MyCommandExecutor implements CommandExecutor {
	
	private Main plugin;											//Mainクラスを扱う。このクラスでは使ってないからほんとはいらない。
	public static ArrayList<Player> adders = new ArrayList<>();
	public static ArrayList<Player> removers = new ArrayList<>();
	
	public MyCommandExecutor(Main plugin) {
		this.plugin = plugin;
	}
	
	/*
	 * onEnable()メソッドで定義したコマンドが実行されるとこのメソッドを通る。
	 * @param sender コマンド実行者
	 * @param cmd 実行されたコマンド
	 * @param label コマンドエイリアス
	 * @param args コマンドの引数
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {				//コマンドの発信者がコンソールでなくプレイヤーである場合のみ
			if(args.length != 1){					//引数がない場合
				sender.sendMessage(Main.prefix +ChatColor.GRAY + "/whitelistbutton " + ChatColor.RED + "add\n" + 
						Main.prefix +ChatColor.GRAY + "/whitelistbutton " + ChatColor.RED + "remove");
				return true;
			}
			
	        Player player = (Player) sender;		//senderをPlayer型にキャスト
	        if(args[0].equalsIgnoreCase("add")){	//第一引数がaddの場合
	        	adders.add(player);
	        	if(removers.contains(player)){
	        		removers.remove(player);
	        	}
	        	
	        	sender.sendMessage(Main.prefix + ChatColor.GREEN + "ボタンを右クリックしてください。");
	        }
	        else if(args[0].equalsIgnoreCase("remove")){	////第一引数がremoveの場合
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
