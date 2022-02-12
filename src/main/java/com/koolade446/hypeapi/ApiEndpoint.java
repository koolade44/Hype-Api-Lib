package com.koolade446.hypeapi;

public enum ApiEndpoint {
    KEY("key"),
    PLAYER("player"),
    FRIENDS("friends"),
    RECENT_GAMES("recent_games"),
    STATUS("status"),
    GUILD("guild"),
    PLAYER_RANKED_SKYWARS("player/ranked/skywars"),
    HYPIXEL_GAMES("resources/games"),
    HYPIXEL_ACHIEVEMENTS("resources/achievements"),
    HYPIXEL_CHALLENGES("resources/challenges"),
    HYPIXEL_QUESTS("resources/quests"),
    HYPIXEL_GUILD_ACHIEVEMENTS("resources/guilds/achievements"),
    HYPIXEL_VANITY_PETS("resources/vanity/pets"),
    HYPIXEL_VANITY_COMPANIONS("resources/vanity/companions"),
    SKYBLOCK_COLLECTIONS("resources/skyblock/collections"),
    SKYBLOCK_SKILLS("resources/skyblock/skills"),
    SKYBLOCK_ITEMS("resources/skyblock/items"),
    SKYBLOCK_ELECTION("resources/skyblock/election"),
    SKYBLOCK_NEWS("skyblock/news"),
    SKYBLOCK_AUCTION("skyblock/auction"),
    SKYBLOCK_AUCTIONS("skyblock/auctions") {
        @Override
        public ApiEndpoint withPageNumber(int pageNumber) {
            this.value = "skyblock/auctions?page" + pageNumber;
            return this;
        }
    },
    SKYBLOCK_AUCTIONS_ENDED("skyblock/auctions_ended"),
    SKYBLOCK_BAZZAR("skyblock/bazzar"),
    SKYBLOCK_PROFILE("skyblock/profile"),
    SKYBLOCK_PROFILES("skyblock/profiles"),
    NETWORK_BOOSTERS("boosters"),
    PLAYER_COUNT("counts"),
    LEADERBOARDS("leaderboards"),
    PUNISHMENTS("punishmentstats");



    String value;

    ApiEndpoint(String value) {
        this.value = value;
    }

    public ApiEndpoint withPageNumber(int pageNumber) {return this;}

    @Override
    public String toString() {
        return value;
    }
}
