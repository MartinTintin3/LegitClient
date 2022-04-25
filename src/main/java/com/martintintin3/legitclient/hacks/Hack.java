package com.martintintin3.legitclient.hacks;

import com.martintintin3.legitclient.enums.Category;
import net.minecraft.client.MinecraftClient;

public class Hack {
	public final String name;
	public final Category category;

	private boolean enabled = true;

	public Hack(String name, Category category, boolean enabled) {
		this.name = name;
		this.category = category;

		this.setEnabled(enabled);
	}

	public Hack(String name, Category category) {
		this.name = name;
		this.category = category;

		this.setEnabled(false);
	}

	public final void setEnabled(boolean enabled) {
		this.enabled = enabled;

		if(enabled) {
			this.onEnable();
		} else {
			this.onDisable();
		}
	}

	public final boolean getEnabled() {
		return this.enabled;
	}

	public final void startTick(MinecraftClient client) {
		if(this.getEnabled()) {
			this.onStartTick(client);
		}
	}

	public final void endTick(MinecraftClient client) {
		if(this.getEnabled()) {
			this.onEndTick(client);
		}
	}

	protected void onEnable() {}
	protected void onDisable() {}
	protected void onStartTick(MinecraftClient client) {};
	protected void onEndTick(MinecraftClient client) {};
}
