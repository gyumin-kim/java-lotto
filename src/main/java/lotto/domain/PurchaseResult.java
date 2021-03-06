package lotto.domain;

import java.util.List;

public class PurchaseResult {

    private final List<LottoTicket> lottoTickets;
    private final PurchaseAmount change;

    private PurchaseResult(final List<LottoTicket> lottoTickets, final PurchaseAmount purchaseAmount) {
        this.lottoTickets = lottoTickets;
        this.change = purchaseAmount;
    }

    public static PurchaseResult of(final List<LottoTicket> lottoTickets, final PurchaseAmount change) {
        return new PurchaseResult(lottoTickets, change);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public PurchaseAmount getChange() {
        return change;
    }

    public int getCount() {
        return this.lottoTickets.size();
    }
}
