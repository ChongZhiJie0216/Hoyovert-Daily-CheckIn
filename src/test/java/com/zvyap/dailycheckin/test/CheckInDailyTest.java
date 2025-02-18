package com.zvyap.dailycheckin.test;

import com.zvyap.dailycheckin.CheckInAction;
import com.zvyap.dailycheckin.HoyoDaily;
import com.zvyap.dailycheckin.WebhookInfo;
import com.zvyap.hoyoapi.APIEnvironment;
import com.zvyap.hoyoapi.APILocale;
import com.zvyap.hoyoapi.GameType;
import com.zvyap.hoyoapi.HoyoToken;
import com.zvyap.hoyoapi.HoyoverseAPI;
import com.zvyap.hoyoapi.feature.daily.DailyCheckInFeature;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckInDailyTest {

    private final HoyoverseAPI api = new HoyoverseAPI(APIEnvironment.OVERSEA, APILocale.ZH_CN);
    private final DailyCheckInFeature feature = new DailyCheckInFeature(api);

    @Test
    public void checkIn() {
        HoyoDaily.checkIn(feature, List.of(

                CheckInAction.builder()
                        .token(HoyoToken.of(System.getenv("USER_1_ID"), System.getenv("USER_1_TOKEN")))
                         .webhook(WebhookInfo.builder()
                                .url(System.getenv("WEBHOOK_URL"))
                                .avatar("https://i.imgur.com/Plyx9IQ.png")
                                .name("银狼")
                                .build())
                        .game(GameType.GENSHIN_IMPACT)
                        .game(GameType.HONKAI_STAR_RAIL)
                        .game(GameType.HONKAI_IMPACT_3RD)
                        .build()
        ));
    }

}
