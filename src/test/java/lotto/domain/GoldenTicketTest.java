package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GoldenTicketTest {

    @DisplayName("보너스 볼이 들어 있을 때, 포함되었는지 확인하는 테스트")
    @Test
    void containsBonusBallTest() {
        // given
        LottoTicket winningTicket = new LottoTicket(createPickedWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(45);
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
        LottoTicket lottoTicket = new LottoTicket(createPickedSecondNumbers());

        // when
        boolean isContainBonusBall = goldenTicket.containsBonusBall(lottoTicket);

        // then
        assertThat(isContainBonusBall).isTrue();
    }

    @DisplayName("2등으로 5개의 볼이 맞았을 때, 확인하는 테스트")
    @Test
    void getMatchedNumbersCountTest() {
        LottoTicket winningTicket = new LottoTicket(createPickedWinningNumbers());
        LottoNumber bonusNumber = LottoNumber.of(45);
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);
        LottoTicket lottoTicket = new LottoTicket(createPickedSecondNumbers());

        // when
        int matchedNumbersCount = goldenTicket.getMatchedNumbersCount(lottoTicket);

        // then
        assertThat(matchedNumbersCount).isEqualTo(5);
    }

    private List<LottoNumber> createPickedWinningNumbers() {
        return Arrays.asList(
                LottoNumber.of(8),
                LottoNumber.of(21),
                LottoNumber.of(23),
                LottoNumber.of(41),
                LottoNumber.of(42),
                LottoNumber.of(43)
        );
    }

    private List<LottoNumber> createPickedSecondNumbers() {
        return Arrays.asList(
                LottoNumber.of(8),
                LottoNumber.of(21),
                LottoNumber.of(23),
                LottoNumber.of(41),
                LottoNumber.of(42),
                LottoNumber.of(45)
        );
    }
}