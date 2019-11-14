package com.akardoo.paperconomy.objects;

import java.util.UUID;

import org.bukkit.entity.Player;

public class PaperPlayer {
	private UUID uuid;
	private Player player;
	private Currency c;
	private float credit;
	
	public PaperPlayer(UUID uuid, Currency c, float f){
		this.setUuid(uuid);
		this.setCurrency(c);
		this.credit = f;
	}
	
	public PaperPlayer(Player player, Currency c, float f){
		this.setPlayer(player);
		this.setCurrency(c);
		this.credit = f;
	}
	
	public float get(){
		return this.credit;
	}
	
	public void set(float f){
		this.credit = f;
	}
	
	public void add(float f){
		this.credit = this.credit +f;
	}
	
	public boolean subtract(float f, boolean force){
		if(force){
			this.credit = this.credit - f;
			return true;
		} else {
			return false;
		}
		
	}

	public Currency getCurrency() {
		return c;
	}

	public void setCurrency(Currency c) {
		this.c = c;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
}
