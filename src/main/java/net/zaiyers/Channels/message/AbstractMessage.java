package net.zaiyers.Channels.message;

import net.md_5.bungee.api.chat.TextComponent;

import java.util.regex.Matcher;

abstract public class AbstractMessage implements Message {
	/**
	 * unprocessed message
	 */
	protected String rawMessage;
	
	/**
	 * pretty message
	 */
	protected TextComponent processedMessage;
	
	/**
	 * time this message was send
	 */
	final private long time = System.currentTimeMillis();
	
	/**
	 * the final message
	 */
	public TextComponent getProcessedMessage() {
		return processedMessage;
	}
	
	public String getRawMessage() {
		return rawMessage;
	}

	/**
	 * sets a new raw message
	 * @param rawMessage the new raw message
	 */
	public void setRawMessage(String rawMessage) {
		this.rawMessage = Matcher.quoteReplacement(rawMessage);
	}
	
	public long getTime() {
		return time;
	}
}
