package pl.zankowski.iextrading4j.hist.tops.field;

/**
 * @author Wojciech Zankowski
 */
public enum IEXSaleConditionFlag {

    NON_INTERMARKET_SWEEP_ORDER,
    INTERMARKET_SWEEP_FLAG,
    REGULAR_MARKET_SESSION_TRADE,
    EXTENDED_HOURS_FLAG,
    ROUND_OR_MIXED_LOT_TRADE,
    ODD_LOT_FLAG,
    TRADE_IS_SUBJECT_TO_RULE_611,
    TRADE_IS_NOT_SUBJECT_TO_RULE_611;

}
