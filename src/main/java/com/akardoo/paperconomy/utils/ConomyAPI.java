package com.akardoo.paperconomy.utils;

import org.bukkit.entity.Player;

import com.akardoo.paperconomy.PaperConomy;
import com.akardoo.paperconomy.objects.Currency;

public class ConomyAPI {
	
	public static void newCurrency(String name){
		
	}
	
	public static String transaction(Player p, Currency c, int id, float process){
		float money = PaperConomy.getPlayer(p, c).get();
		if(id == 0){
			//Minus operation
			if(money - process >= 0){
				PaperConomy.getPlayer(p, c).set(money - process);
				return "true";
			}
			else {
				return "error";
			}
		} else {
			//Plus operation
			PaperConomy.getPlayer(p, c).set(money + process);
			return "true";
		}
	}
	
}
