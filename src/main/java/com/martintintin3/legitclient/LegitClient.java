package com.martintintin3.legitclient;

import com.martintintin3.legitclient.hacks.Hack;
import com.martintintin3.legitclient.hacks.Hacks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import java.util.Iterator;

@Environment(EnvType.CLIENT)
public class LegitClient implements ClientModInitializer {
	public final Hacks hacks = new Hacks();

	@Override
	public void onInitializeClient() {

	}
}
