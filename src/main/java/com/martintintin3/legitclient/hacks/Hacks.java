package com.martintintin3.legitclient.hacks;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

public class Hacks {
	public final NoFallHack noFallHack = new NoFallHack();

	public final ArrayDeque<Hack> list = new ArrayDeque<Hack>();

	public Hacks() {
		Arrays.stream(this.getClass().getFields()).filter(field -> Hack.class.isAssignableFrom(field.getType())).forEach(field -> {
			try {
				this.list.add((Hack) field.get(this));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});

		ClientTickEvents.START_CLIENT_TICK.register(this::startTick);
		ClientTickEvents.END_CLIENT_TICK.register(this::endTick);
	}

	public void startTick(MinecraftClient client) {
		Iterator<Hack> iterator = this.list.iterator();

		while(iterator.hasNext()) {
			iterator.next().startTick(client);
		}
	}

	public void endTick(MinecraftClient client) {
		Iterator<Hack> iterator = this.list.iterator();

		while(iterator.hasNext()) {
			iterator.next().endTick(client);
		}
	}
}
