package com.akardoo.paperconomy;

import java.net.UnknownHostException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.akardoo.paperconomy.objects.Currency;
import com.akardoo.paperconomy.objects.PaperPlayer;
import com.akardoo.paperconomy.utils.FileManager;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import net.md_5.bungee.api.ChatColor;

public class PaperConomy extends JavaPlugin implements Listener {
	public static ConcurrentHashMap<Currency, ConcurrentHashMap<UUID, PaperPlayer>> conomy = new ConcurrentHashMap<Currency, ConcurrentHashMap<UUID, PaperPlayer>>();
	public static ConcurrentHashMap<String, Currency> currencies = new ConcurrentHashMap<String, Currency>();
	public static FileManager fm;
    private DB mcserverdb;
    private MongoClient client;
	
	public void onEnable(){
		fm = new FileManager(this);
		UUID ui = UUID.randomUUID();
		if(fm.getConfig("config.yml").get("pluginid") == null) fm.getConfig("config.yml").set("pluginid", ui);
		if(fm.getConfig("config.yml") == null){
			fm.getConfig("config.yml").copyDefaults(true);
			log("&cFirst run detected, please configure...");
			Bukkit.getServer().shutdown();
		}
		
        try {
            client = new MongoClient(new MongoClientURI( "mongodb://" + 
            		fm.getConfig("config.yml").get("data.user").toString() + ":" + 
            		fm.getConfig("config.yml").get("data.password").toString() + "@" + 
            		fm.getConfig("config.yml").get("data.host").toString() + "/" ));
        } catch (UnknownHostException e) {
        	log("&cCould not connect to mongodb, error: " + e.getMessage());
        }
		
	}
	
	public void onDisable(){
		
	}
	
	public void log(String s){
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		console.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e){
		Player p = e.getPlayer();
		for(Currency c : currencies.values()){
			conomy.put(c, new ConcurrentHashMap<UUID, PaperPlayer>());
			ConcurrentHashMap<UUID, PaperPlayer> co = conomy.get(c);
			co.put(p.getUniqueId(), new PaperPlayer(p, c, 0f));
		}
	}
	
	public static PaperPlayer getPlayer(Player p, Currency c){
		if(conomy.get(c).contains(p.getUniqueId())){
			return conomy.get(c).get(p.getUniqueId());
		} else return null;
	}
	
	
}
