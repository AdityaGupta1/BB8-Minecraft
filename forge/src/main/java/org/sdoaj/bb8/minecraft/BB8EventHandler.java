package org.sdoaj.bb8.minecraft;

import java.net.HttpURLConnection;
import java.net.URL;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BB8EventHandler {

	private void sendHTTPRequest(String urlText) throws Exception {
		URL url = new URL(urlText);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.getResponseCode();
		connection.disconnect();
	}

	@SubscribeEvent
	public void playerHurt(LivingHurtEvent event) throws Exception {
		if (!(event.getEntityLiving() instanceof EntityPlayer)) {
			return;
		}

		sendHTTPRequest("http://127.0.0.1:8081/player-hurt");
	}
	
	@SubscribeEvent
	public void playerJump(LivingJumpEvent event) throws Exception {
		if (!(event.getEntityLiving() instanceof EntityPlayer)) {
			return;
		}

		sendHTTPRequest("http://127.0.0.1:8081/player-jump");
	}
}