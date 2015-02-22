package com.github.theholywaffle.lolchatapi;

/*
 * #%L
 * League of Legends XMPP Chat Library
 * %%
 * Copyright (C) 2014 Bert De Geyter
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

import org.custommonkey.xmlunit.Diff;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.SAXException;

public class LolStatus {

	public enum Division {
		NONE,
		I,
		II,
		III,
		IV,
		V;
	}

	public enum GameStatus {
		TEAM_SELECT("teamSelect"),
		HOSTING_NORMAL_GAME("hostingNormalGame"),
		HOSTING_PRACTICE_GAME("hostingPracticeGame"),
		HOSTING_RANKED_GAME("hostingRankedGame"),
		HOSTING_COOP_VS_AI_GAME("hostingCoopVsAIGame"),
		IN_QUEUE("inQueue"),
		SPECTATING("spectating"),
		OUT_OF_GAME("outOfGame"),
		CHAMPION_SELECT("championSelect"),
		IN_GAME("inGame"),
		IN_TEAMBUILDER("inTeamBuilder"),
		TUTORIAL("tutorial");

		private String internal;

		GameStatus(String internal) {
			this.internal = internal;
		}

		public String internal() {
			return internal;
		}
	}

	public enum Queue {
		NONE,
		NORMAL,
		NORMAL_3x3,
		ODIN_UNRANKED,
		ARAM_UNRANKED_5x5,
		BOT,
		BOT_3x3,
		RANKED_SOLO_5x5,
		RANKED_TEAM_3x3,
		RANKED_TEAM_5x5,
		ONEFORALL_5x5,
		FIRSTBLOOD_1x1,
		FIRSTBLOOD_2x2,
		SR_6x6,
		CAP_5x5,
		URF,
		URF_BOT,
		NIGHTMARE_BOT;
	}

	public enum Tier {
		UNRANKED,
		BRONZE,
		SILVER,
		GOLD,
		PLATINUM,
		DIAMOND,
		MASTER,
		CHALLENGER;
	}

	private enum XMLProperty {

		level,
		rankedLeagueDivision,
		rankedLosses,
		rankedRating,
		leaves,
		gameQueueType,
		skinname,
		profileIcon,
		rankedLeagueQueue,
		tier,
		rankedLeagueName,
		queueType,
		timeStamp,
		rankedWins,
		odinLeaves,
		dropInSpectateGameId,
		statusMsg,
		rankedLeagueTier,
		featuredGameData,
		odinWins,
		wins,
		gameStatus,
		isObservable,
		mobile,
		rankedSoloRestricted;

		@Override
		public String toString() {
			return name();
		}

	}

	private static final XMLOutputter outputter = new XMLOutputter();

	private final Document doc;

	/**
	 * Generate a default LoLStatus that can later be modified and be used to
	 * change the current LolStatus ({@link LolChat#setStatus(LolStatus)}).
	 * 
	 */
	public LolStatus() {
		outputter
				.setFormat(outputter.getFormat().setExpandEmptyElements(false));
		doc = new Document(new Element("body"));
		for (final XMLProperty p : XMLProperty.values()) {
			doc.getRootElement().addContent(new Element(p.toString()));
		}
	}

	/**
	 * This constructor is not intended for usage.
	 * 
	 * @param xml
	 *            An XML string
	 * @throws JDOMException
	 *             Is thrown when the xml string is invalid
	 * @throws IOException
	 *             Is thrown when the xml string is invalid
	 */
	public LolStatus(String xml) throws JDOMException, IOException {
		outputter
				.setFormat(outputter.getFormat().setExpandEmptyElements(false));
		final SAXBuilder saxBuilder = new SAXBuilder();
		doc = saxBuilder.build(new StringReader(xml));
		for (final Element e : doc.getRootElement().getChildren()) {
			boolean found = false;
			for (final XMLProperty p : XMLProperty.values()) {
				if (p.name().equals(e.getName())) {
					found = true;
				}
			}
			if (!found) {
				System.err.println("XMLProperty \"" + e.getName()
						+ "\" value: \"" + e.getValue()
						+ "\" not implemented yet!");
			}
		}
	}

	@Override
	public final boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof LolStatus))
			return false;
		final LolStatus otherStatus = (LolStatus) other;
		Diff diff;
		try {
			diff = new Diff(otherStatus.toString(), toString());
			return diff.similar();
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private String get(XMLProperty p) {
		final Element child = getElement(p);
		if (child == null) {
			return "";
		}
		return child.getValue();
	}

	public int getDominionLeaves() {
		return getInt(XMLProperty.odinLeaves);
	}

	public int getDominionWins() {
		return getInt(XMLProperty.odinWins);
	}

	private Element getElement(XMLProperty p) {
		return doc.getRootElement().getChild(p.toString());
	}

	public String getFeaturedGameData() {
		return get(XMLProperty.featuredGameData);
	}

	public String getGameQueueType() {
		return get(XMLProperty.gameQueueType);
	}

	public GameStatus getGameStatus() {
		final String status = get(XMLProperty.gameStatus);
		if (!status.isEmpty()) {
			for (final GameStatus s : GameStatus.values()) {
				if (s.internal.equals(status)) {
					return s;
				}
			}
			System.err
					.println("GameStatus " + status + " not implemented yet!");
		}
		return null;
	}

	private int getInt(XMLProperty p) {
		final String value = get(p);
		if (value.isEmpty()) {
			return -1;
		}
		return Integer.parseInt(value);
	}

	public int getLevel() {
		return getInt(XMLProperty.level);
	}

	private long getLong(XMLProperty p) {
		final String value = get(p);
		if (value.isEmpty()) {
			return -1L;
		}
		return Long.parseLong(value);
	}

	public int getNormalLeaves() {
		return getInt(XMLProperty.leaves);
	}

	public int getNormalWins() {
		return getInt(XMLProperty.wins);
	}

	public int getProfileIconId() {
		return getInt(XMLProperty.profileIcon);
	}

	/**
	 * Seems like an unused variable of Riot
	 * 
	 * @return Empty string
	 */
	@Deprecated
	public String getQueueType() {
		return get(XMLProperty.queueType);
	}

	public Division getRankedLeagueDivision() {
		final String div = get(XMLProperty.rankedLeagueDivision);
		if (!div.isEmpty()) {
			return Division.valueOf(div);
		}
		return Division.NONE;
	}

	public String getRankedLeagueName() {
		return get(XMLProperty.rankedLeagueName);
	}

	public String getRankedLeagueQueue() {
		return get(XMLProperty.rankedLeagueQueue);
	}

	public Tier getRankedLeagueTier() {
		final String tier = get(XMLProperty.rankedLeagueTier);
		if (!tier.isEmpty()) {
			return Tier.valueOf(tier);
		}
		return Tier.UNRANKED;
	}

	/**
	 * Seems like an unused variable of Riot.
	 * 
	 * @return 0
	 */
	@Deprecated
	public int getRankedLosses() {
		return getInt(XMLProperty.rankedLosses);
	}

	/**
	 * Seems like an unused variable of Riot.
	 * 
	 * @return 0
	 */
	@Deprecated
	public int getRankedRating() {
		return getInt(XMLProperty.rankedRating);
	}

	public int getRankedWins() {
		return getInt(XMLProperty.rankedWins);
	}

	public String getSkin() {
		return get(XMLProperty.skinname);
	}

	public String getSpectatedGameId() {
		return get(XMLProperty.dropInSpectateGameId);
	}

	public String getStatusMessage() {
		return get(XMLProperty.statusMsg);
	}

	public Tier getTier() {
		final String tier = get(XMLProperty.tier);
		if (!tier.isEmpty()) {
			return Tier.valueOf(tier);
		}
		return Tier.UNRANKED;
	}

	public Date getTimestamp() {
		final long l = getLong(XMLProperty.timeStamp);
		if (l > 0) {
			return new Date(l);
		}
		return null;
	}

	public boolean isObservable() {
		return get(XMLProperty.isObservable).equals("ALL");
	}

	public LolStatus setDominionLeaves(int leaves) {
		setElement(XMLProperty.odinLeaves, leaves);
		return this;
	}

	public LolStatus setDominionWins(int wins) {
		setElement(XMLProperty.odinWins, wins);
		return this;
	}

	private void setElement(XMLProperty p, int value) {
		setElement(p, String.valueOf(value));
	}

	private void setElement(XMLProperty p, long value) {
		setElement(p, String.valueOf(value));
	}

	private void setElement(XMLProperty p, String value) {
		getElement(p).setText(value);
	}

	private void setElement(XMLProperty p, boolean value) {
		setElement(p, String.valueOf(value));
	}

	public LolStatus setFeaturedGameData(String data) {
		setElement(XMLProperty.featuredGameData, data);
		return this;
	}

	public LolStatus setGameQueueType(Queue q) {
		return setGameQueueType(q.name());
	}

	public LolStatus setGameQueueType(String q) {
		setElement(XMLProperty.gameQueueType, q);
		return this;
	}

	public LolStatus setGameStatus(GameStatus s) {
		setElement(XMLProperty.gameStatus, s.internal);
		return this;
	}

	public LolStatus setLevel(int level) {
		setElement(XMLProperty.level, level);
		return this;
	}

	public LolStatus setNormalLeaves(int leaves) {
		setElement(XMLProperty.leaves, leaves);
		return this;
	}

	public LolStatus setNormalWins(int wins) {
		setElement(XMLProperty.wins, wins);
		return this;
	}

	public LolStatus setObservable() {
		setElement(XMLProperty.isObservable, "ALL");
		return this;
	}

	public LolStatus setProfileIconId(int id) {
		setElement(XMLProperty.profileIcon, id);
		return this;
	}

	@Deprecated
	public LolStatus setQueueType(Queue q) {
		setElement(XMLProperty.queueType, q.name());
		return this;
	}

	public LolStatus setRankedLeagueDivision(Division d) {
		setElement(XMLProperty.rankedLeagueDivision, d.name());
		return this;
	}

	public LolStatus setRankedLeagueName(String name) {
		setElement(XMLProperty.rankedLeagueName, name);
		return this;
	}

	public LolStatus setRankedLeagueQueue(Queue q) {
		setElement(XMLProperty.rankedLeagueQueue, q.name());
		return this;
	}

	public LolStatus setRankedLeagueTier(Tier t) {
		setElement(XMLProperty.rankedLeagueTier, t.name());
		return this;
	}

	@Deprecated
	public LolStatus setRankedLosses(int losses) {
		setElement(XMLProperty.rankedLosses, losses);
		return this;
	}

	@Deprecated
	public LolStatus setRankedRating(int rating) {
		setElement(XMLProperty.rankedRating, rating);
		return this;
	}

	public LolStatus setRankedWins(int wins) {
		setElement(XMLProperty.rankedWins, wins);
		return this;
	}

	public LolStatus setSkin(String name) {
		setElement(XMLProperty.skinname, name);
		return this;
	}

	public LolStatus setSpectatedGameId(String id) {
		setElement(XMLProperty.dropInSpectateGameId, id);
		return this;
	}

	public LolStatus setStatusMessage(String message) {
		setElement(XMLProperty.statusMsg, message);
		return this;
	}

	public LolStatus setTier(Tier t) {
		setElement(XMLProperty.tier, t.name());
		return this;
	}

	public LolStatus setTimestamp(Date date) {
		return setTimestamp(date.getTime());
	}

	public LolStatus setTimestamp(long date) {
		setElement(XMLProperty.timeStamp, date);
		return this;
	}

	public LolStatus setMobile(String mobile) {
		setElement(XMLProperty.mobile, mobile);
		return this;
	}

	public String getMobile() {
		return get(XMLProperty.mobile);
	}

	public LolStatus setRankedSoloRestricted(boolean rankedSoloRestricted) {
		setElement(XMLProperty.rankedSoloRestricted, rankedSoloRestricted);
		return this;
	}

	public boolean getRankedSoloRestricted() {
		return Boolean.valueOf(get(XMLProperty.rankedSoloRestricted));
	}

	@Override
	public String toString() {
		return outputter.outputString(doc.getRootElement());
	}

}
