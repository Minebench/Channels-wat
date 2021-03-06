package net.zaiyers.Channels.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.md_5.bungee.api.ChatColor;
import net.zaiyers.Channels.Channels;

public class LanguageConfig extends YamlConfig {
	public LanguageConfig(String configFilePath) throws IOException {
		super(configFilePath);
	}

	public void createDefaultConfig() {
		InputStream defaultConfig = Channels.getInstance().getResourceAsStream(configFile.getName());
		if (defaultConfig == null) {
			defaultConfig = Channels.getInstance().getResourceAsStream("lang.en.yml");
		}
		cfg = ymlCfg.load(new InputStreamReader(defaultConfig));
		
		save();
	}
	
	/**
	 * get translation from config
	 */
	public String getTranslation(String key) {
		if (cfg.getString(key, "").isEmpty()) {
			return ChatColor.RED + "Unknown language key: " + ChatColor.GOLD + key;
		} else {
			return ChatColor.translateAlternateColorCodes('&', cfg.getString(key));
		}
	}
}
