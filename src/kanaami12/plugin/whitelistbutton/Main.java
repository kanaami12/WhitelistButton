package kanaami12.plugin.whitelistbutton;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public static Main plugin;                                          //他クラスからのアクセス用
	public static String prefix = ChatColor.GRAY + "[WhitelistButton]";	//プラグインメッセージ用接頭文字列
	
	@Override
	public void onEnable(){ //起動後1度だけ処理されるメソッド
		
		plugin = this;      //他クラスからMainクラスを扱う
		
		getCommand("whitelistbutton").setExecutor(new MyCommandExecutor(this));     //コマンドを登録(plugin.ymlにコマンドを登録しておかないとエラーが出る)
		getCommand("whitelistbutton").setTabCompleter(new ConstructTabCompleter()); //タブ補完を登録
		getServer().getPluginManager().registerEvents(new MyListener(), this);      //イベントリスナを登録
		this.saveDefaultConfig();                                                   //コンフィグを保存
	}
}
